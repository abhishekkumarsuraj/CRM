<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>List Customer</title>

<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css" />
     
</head>
<body>

<div id="wrapper">
 <div id="header" >
 
 <h2>CRM - Customer Relationship Manager</h2>
 
 </div>
 
 <div id="addCustomer">
 
  <button type="button" class="btn btn-primary"
  onclick="window.location.href='showFormForAdd'; return false;">Add Customer</button>
 
  <div class="logout">
  <!-- Add a logout Button -->
    
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
    
   
    <button type="submit" class="btn btn-info btn-lg">
   <span class="glyphicon glyphicon-log-out"></span> Logout
   </button>
  
    </form:form>
    </div>
 </div>
 


<div id="customerSearch" >

<form:form action="search" method="POST">

Search Customer:<input type="text" name="thesearchname" style="margin-top: 20px; padding :0px 10px 2px 0px; border-radius: 6px;">
                <button type="submit" class="btn btn-primary"
                   >Search</button>

</form:form>

<div id="linkref">
 
 <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
 
 </div>

</div>



 <div id="container">

 <table class="table">
 <thead>
 <tr>
 <th> First Name </th>
 <th> Last Name </th>
 <th> Email </th>
 <th> Action </th>
 </tr>
 </thead>
 
 
 <c:forEach var="tempCustomer" items="${customers}">
 
 <tbody>
      <!-- Create the Link for Update of customer --> 
      <c:url var="updatelink" value="/customer/showFormForUpdate">
      <c:param name="customerId" value="${tempCustomer.id}"></c:param>
      </c:url> 
      
       <!-- Create the Link for Delete of customer --> 
      <c:url var="Deletelink" value="/customer/delete">
      <c:param name="customerId" value="${tempCustomer.id}"></c:param>
      </c:url> 
      
 <tr class="success">
 <td> ${tempCustomer.firstName}</td>
 <td> ${tempCustomer.lastName}</td>
 <td> ${tempCustomer.email}</td>
 <td>
 <a href="${updatelink}">Update</a>
 |
 <a href="${Deletelink}"
  onclick="if(!(confirm('Are you Sure you want to delete this Customer ?'))) return false">Delete</a>
 
 </tr>
 </tbody>
 
 </c:forEach>
 
 </table>
 
 
 </div>

</div>



</body>

</html>