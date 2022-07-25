<%@page import="com.getterSetter.TeacherGS"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />  
<% 
List<TeacherGS> teacherList= new ArrayList<TeacherGS>(); 
teacherList=teacher.getAllTeacher();

%>
<div class="container-fluid mt-3">
<div class="container mt-3">
 <div class="row">
  		<div class="col-10"> <h2>View Teacher</h2> </div>
  		
  		<div class="col-2">
  		
		<a href="addTeacher.jsp" class="btn btn-success"> Add Teacher </a>
  		  </div>
</div>
           
  <table class="table table-striped">
    <thead>
   
      <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Class</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
     <% 
    for(int i=0;i<teacherList.size();i++){
    	TeacherGS s=teacherList.get(i);
    	
    %>

      <tr>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getSchoolClass() %></td>
         <td> <a href="deleteTeacher.jsp?id=<%= s.getId() %>">  Delete </a></td>
      </tr>
    <% 	} %>
     
    </tbody>
  </table>
</div>
</div>

</body>
</html>