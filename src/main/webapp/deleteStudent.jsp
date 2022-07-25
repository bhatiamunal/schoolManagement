<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.dao.Student"%>  
<jsp:useBean id="u" class="com.getterSetter.StudentGS"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
String y = request.getParameter("id");
Student obj=new Student();
int a = obj.delete(Integer.valueOf(y));
System.out.println("a"+a);
System.out.println("y"+y);
response.sendRedirect("viewStudent.jsp");  
%>  