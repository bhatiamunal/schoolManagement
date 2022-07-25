<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.dao.teacher"%>  
<jsp:useBean id="u" class="com.getterSetter.TeacherGS"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
String y = request.getParameter("id");
teacher obj=new teacher();
int a = obj.delete(Integer.valueOf(y));
System.out.println("a"+a);
System.out.println("y"+y);
response.sendRedirect("viewTeacher.jsp");  
%>