<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%

    String url = request.getParameter("wxUrl");
    System.out.println("获取的跳转链接时"+url);
    response.sendRedirect(url);
%>