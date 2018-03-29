<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"   %>

<!DOCTYPE html>
<html>
<head>
<title>Customer Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css" />

 <%-- <link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
 --%>


</head>

<body>
 
 <div class="container">
 <h2>Customer Registration</h2>
 
 <form:form action="saveCustomer" modelAttribute="customer" method="POST">
 
    <!-- need to associate this date with customer id  --> 
    
    <form:hidden path="id"/>
 
    <div class="form-group">
      <label for="text">First Name:</label>
      <form:input type="text" class="form-control" id="firstName" placeholder="firstName" name="firstName" path="firstName" />
    </div>
    <div class="form-group">
      <label for="text">Last Name:</label>
      <form:input type="text" class="form-control" id="lastName" placeholder="lastName" name="lastName" path="lastName"/>
    </div>
  <div class="form-group">
      <label for="email">Email:</label>
      <form:input type="email" class="form-control" id="email" placeholder="Enter email" name="email"  path="email"/>
    </div>
    
     <button type="submit" class="btn btn-success" > Submit </button>
    
  </form:form>

 </div>

 <div id="linkref">
 
 <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
 
</div>

</html>