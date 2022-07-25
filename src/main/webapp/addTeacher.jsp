<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />  
<div class="container mt-3">
  
  	<div class="row">
  		<div class="col-10"> <h2>Add Teacher</h2> </div>
  		
  		<div class="col-2">
  		<a href="viewTeacher.jsp" class="btn btn-success"> View Teacher </a>

  		  </div>
	</div>
  <form action="<%= request.getContextPath() %>/NewTeacher" method="post">
    <div class="mb-3 mt-3">
      <label for="email">Name of Teacher:</label>
      <input type="text" class="form-control" name="name" placeholder="Enter Name">
    </div>
    <div class="mb-3">
      <label for="pwd">Email of Teacher:</label>
      <input type="text" class="form-control" placeholder="Enter email" name="email">
    </div>

     <div class="mb-3">
      <label for="pwd">Teacher subject :</label>
      <input type="text" class="form-control" placeholder="Enter Student Course" name="subject">
    </div>
    <div class="mb-3">
      <label for="pwd">Teacher  Class:</label>
      <input type="text" class="form-control" placeholder="Enter Student Section " name="schoolClass">
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
  </form>
</div>

</body>
</html>