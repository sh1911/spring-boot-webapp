<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
       <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegisterForm-BloodsBrother</title>
<link href="//db.onlinewebfonts.com/c/a4e256ed67403c6ad5d43937ed48a77b?family=Core+Sans+N+W01+35+Light" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style-registrationfrom.css" type="text/css">
</head>
<body>
<script type="text/javascript">
  function Toggle() { 
      var temp1 = document.getElementById("password"); 
      if (temp1.type === "password") { 
          temp1.type = "text";
       } 
      else { 
          temp1.type = "password"; 
      } 
  } 

</script>
<div class="body-content">
  <div class="module">
  <span>
	<i>Donating Blood Saves Life</i>
	<img id=rcorners1 src="<%=request.getContextPath()%>/images/bloodlogo.png" >
	</span>
    <h1>Create an account</h1>
    
    <form:form class="form" action="register" method="post" autocomplete="off" modelAttribute="user" onsubmit="return checkForm(this);">
      	<div class="alert alert-error"></div>
      <table style="float:left">
      	<tr style="border:1px">
      	
      	<th>	FristName *		<form:input type="text" placeholder="Frist Name" path="fname" required="true" /></th>
      	<th>	LastName 		<form:input type="text" placeholder="Last Name" path="lname" /></th>
      	</tr>
      	<tr style="border:1px">
      	<th ><form:errors path="fname" cssClass="alert alert-error" /></th>
      	<th ><form:errors path="lname" cssClass="alert alert-error"/></th>
      	</tr>
		<tr style="border:1px">
				<th><p>Gender *	
						<form:radiobutton path="gender" value="male" required="true"/> Male</p></th>
     					<th><form:radiobutton path="gender" vaue="female" required="true"/>Female</th>
		</tr>
		
		<tr style="border:5px">
			
				<th>DateOfBirth*</th>
    			<th><form:input  type="date" placeholder="dd/mm/yyyy" path="dateofbirth" required="true"/></th>
    			
		</tr>
		<tr style="border:1px">
				<th colspan="2">Email *<form:input type="email" placeholder="Email" path="email" required="true"/></th>
		</tr>
		<tr style="border:1px">
      	<th colspan="2"><form:errors path="email" cssClass="alert alert-error"/></th>
       	</tr>
		<tr style="border:1px">
    	<th colspan="2" >	Password *	<form:input type="password" placeholder="Password" path="password" autocomplete="new-password" required="true"/></th>
     	</tr>
     	<tr style="border:1px">
      	<th colspan="2"><form:errors path="password" cssClass="alert alert-error"/></th>
		<tr>
		<th><input type="checkbox" onclick="Toggle()"> 
    					<b>Show Password</b> 
		</th>
		</tr>
		<tr style="border:1px">
			<th colspan="2">
			<p style="color:white"><strong>Note:</strong>
			<em style="color:red;" >* </em><em>all are mandatory fields</em>
			</th>
		</tr>
		<tr style="border:1px">
      	<th colspan="2"><input type="submit" value="Register" name="register" class="btn btn-block btn-primary" /></th>
   		</tr>
	</table>
	 </form:form>
  </div>
</div>
</body>
</html>