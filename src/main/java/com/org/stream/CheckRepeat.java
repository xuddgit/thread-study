/*
 *company:jlc
 *author:xudd
 *date:2019/11/6:15:18
 *desc:{}
 **/


package com.org.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author:xudd
 * @date:2019/11/6 -15:18
 * @desc:
 **/
public class CheckRepeat {

    public static void main(String[] args) {
        List<Models> list = new ArrayList<>();
        Models model = new Models();
        model.setName("a");
        model.setAge("238");
        model.setSemi_fid("xxxcqqccbbb");
        model.setTid("111111");
        Models model1 = new Models();
        model1.setName("b");
        model1.setAge("237");
        model1.setSemi_fid("xxxccqcbbb");
        model1.setTid("11111133");
        Models model2 = new Models();
        model2.setName("c");
        model2.setAge("236");
        model2.setSemi_fid("xxxccqcbbb");
        model2.setTid("111111");
        Models model3 = new Models();
        model3.setName("d");
        model3.setAge("236");
        model3.setSemi_fid("xxxccqqcbbb");
        model3.setTid("111111");
        Models model4 = new Models();
        model4.setName("e");
        model4.setAge("25");
        model4.setSemi_fid("xxxcccqqqbbb");
        model4.setTid("111111");

        Models model5 = new Models();
        model5.setName("f");
        model5.setAge("23");
        model5.setSemi_fid("xxxcccqqqbbb");
        model5.setTid("111111");

        list.add(model);
        list.add(model1);

        list.add(model2);
        list.add(model1);
        list.add(model3);
        list.add(model4);
        list.add(model5);

        //顺序不变
      /*  List<Models> collect = list.stream().distinct().collect(Collectors.toList());
        collect.forEach(demo ->{
            System.out.println(demo.getName()+":"+demo.getAge()+":"+demo.getSemi_fid()+":"+demo.getTid());
        });*/
        //顺序发生变化
         List<Models> distinctClass = list.stream().
        collect(
        Collectors.collectingAndThen(
         Collectors.toCollection(
         () -> new TreeSet<>(
        Comparator.comparing(o -> o.getAge() + ";" + o.getName()
         ))), ArrayList::new));


        distinctClass.forEach(demo ->{
            System.out.println(demo.getName()+":"+demo.getAge()+":"+demo.getSemi_fid()+":"+demo.getTid());
        });
    }

}
