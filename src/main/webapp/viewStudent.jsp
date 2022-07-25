<%@page import="com.getterSetter.StudentGS"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />  
<% 
List<StudentGS> studentList= new ArrayList<StudentGS>(); 
studentList=Student.getAllStudent();

%>
<div class="container-fluid mt-3">
<div class="container mt-3">
 <div class="row">
  		<div class="col-10"> <h2>View Student</h2> </div>
  		
  		<div class="col-2">
  		
		<a href="addStudent.jsp" class="btn btn-success"> Add Student </a>
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
    for(int i=0;i<studentList.size();i++){
    	StudentGS s=studentList.get(i);
    	
    %>

      <tr>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getStudCources() %></td>
         <td> <a href="deleteStudent.jsp?id=<%= s.getId() %>">  Delete </a></td>
      </tr>
    <% 	} %>
     
    </tbody>
  </table>
</div>
</div>

</body>
</html>
