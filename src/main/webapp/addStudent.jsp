<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />  
<div class="container mt-3">
  
  	<div class="row">
  		<div class="col-10"> <h2>Add Student</h2> </div>
  		
  		<div class="col-2">
  		<a href="viewStudent.jsp" class="btn btn-success"> View Student </a>

  		  </div>
	</div>
  <form action="<%= request.getContextPath() %>/NewStudent" method="post">
    <div class="mb-3 mt-3">
      <label for="email">Name of Student:</label>
      <input type="text" class="form-control" name="name" placeholder="Enter Name">
    </div>
    <div class="mb-3">
      <label for="pwd">Email of Student:</label>
      <input type="text" class="form-control" placeholder="Enter email" name="email">
    </div>
    <div class="mb-3">
      <label for="pwd">Country:</label>
      <input type="text" class="form-control" placeholder="Enter email" name="country">
    </div>
    <div class="mb-3 mt-3">
      <label for="email">Gender:</label>
      <input type="text" class="form-control" name="gender" placeholder="Enter Gender">
    </div>
    <div class="mb-3">
      <label for="pwd">Mobile Number:</label>
      <input type="text" class="form-control" placeholder="Enter Mobile Number" name="mobileNumber">
    </div>
    <div class="mb-3">
      <label for="pwd">student Address:</label>
      <input type="text" class="form-control" placeholder="Enter student Address" name="studAddress">
    </div>
     <div class="mb-3">
      <label for="pwd">Student Course :</label>
      <input type="text" class="form-control" placeholder="Enter Student Course" name="StudCources">
    </div>
    <div class="mb-3">
      <label for="pwd">Student Section:</label>
      <input type="text" class="form-control" placeholder="Enter Student Section " name="studSection">
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
  </form>
</div>

</body>
</html>