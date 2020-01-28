<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/header.jsp"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="includes/header.jsp"%>

</head>
<body class="text-center">
  
 <div class ="col-sm-5" >
    <form class="form-signin" action="signup" method="post">
     
      <h1 class="h3 mb-3 font-weight-normal">Registration from</h1>
      <div class ="form-group row" >
      <label for="inputEmail" class="sr-only">UserName</label>
       <div class ="col-sm-10" >
      <input type="text" name="userName" id="inputUserName" class="form-control" placeholder="User Name" required autofocus>
      </div>
      </div>
      <div class ="form-group row" >
      <label for="inputPassword" class="sr-only">Email</label>
      <div class ="col-sm-10" >
      <input type="email" name ="userEmail" id="inputUserEmail" class="form-control" placeholder="User Email" required>
      </div>
      </div>
     
       <div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success">Register</button>
      </div>
    </div>
     
   
     
    </form>
    </div>
    
  </body>
</html>