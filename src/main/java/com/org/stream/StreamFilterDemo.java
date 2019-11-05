/*
 *company:jlc
 *author:xudd
 *date:2019/11/5:14:53
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
 * @date:2019/11/5 -14:53
 * @desc:
 **/
public class StreamFilterDemo {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        for(int i=0;i<100;i++){
            Person p = new Person();
            p.setId("1");
            p.setName("zs");
            p.setAge(10);
            Person p1 = new Person();
            p1.setId("2");
            p1.setName("zs");
            p1.setAge(10);
            persons.add(p1);

            Person p2 = new Person();
            p2.setId("3");
            p2.setName("zw");
            p2.setAge(10);
            persons.add(p2);
        }

        List<Person> unique = persons.parallelStream().collect(
                Collectors. collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getName() + ";" + o.getAge()))), ArrayList::new)
        );

       System.out.println(unique);
    }
}
