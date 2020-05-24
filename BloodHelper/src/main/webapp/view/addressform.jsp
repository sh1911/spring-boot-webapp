<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Profile</title>
<link href="//db.onlinewebfonts.com/c/a4e256ed67403c6ad5d43937ed48a77b?family=Core+Sans+N+W01+35+Light" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style-registrationfrom.css" type="text/css">
</head>
<body>
<div class="body-content">
  <div class="module">
  <img src="/images/index.png" alt="Donating Blood Saves Life" width="20"
         height="80">
    <h1>Add Address</h1>
    
    <form:form class="form" action="formsubmit" method="post" autocomplete="off" modelAttribute="alien">
      	<div class="alert alert-error"></div>
      <table style="float:left">
      	<tr style="border:1px">
      	    	<th colspan="2">FullName *<input type="text"  value="${alien.fname} ${alien.lname}" readonly  /></th>
      	</tr>
		<tr>
				<th colspan="2">MobileNo *<form:input type="text" placeholder="Mobile Number" path="mobileno" autocomplete="off" required="true" /></th>
		</tr>
		<tr>
      	<th colspan="2"><form:errors path="mobileno" cssClass="alert alert-error" /></th>
      	</tr>
		<tr style="border:1px">
        		<th>Country *
        		<form:select path="country" required="true" value=>
        				<form:option value="--select country--" name=""></form:option>
      					<form:option value="India" name="India"></form:option>
      					<form:option value="USA" name="TheUnitedStatesOfAmerica"></form:option>
      					<form:option value="UE" name="UnitedStaesOfEmirates"></form:option>
      					<form:option value="France" name="France"></form:option>
      					<form:option value="Uk" name="UnitedKingdom"></form:option>
      					</form:select>
      			</th>
      			<th>State *
			<form:select path="state" required="true">
						<form:option value="--select state--" name=""></form:option>
      					<form:option value="AndraPradesh" name="AndraPradesh"></form:option>
      					<form:option value="Maharastra" name="Maharastra"></form:option>
      					<form:option value="TamilNadu" name="TamilNadu"></form:option>
      					<form:option value="Kerala" name="Kerala"></form:option>
      					<form:option value="Banglore" name="Banglore"></form:option>
      		</form:select>
      	</th>
      	</tr>
		<tr style="border:1px">
			<th colspan="2">Address *<form:input type="text" placeholder="Flat No/House No,Street" path="address" autocomplete="off" required="true"/></th>
    	</tr>
		<tr style="border:1px">
			<th>City *<form:input type="text" placeholder="City" path="city" autocomplete="off" required="true"/></th>
			<th>Pincode *<form:input type="text" placeholder="Pincode" path="pincode" autocomplete="off" required="true"/></th>
    	</tr>
    	<tr style="border:1px">
      	<th colspan="2"><form:errors path="city" cssClass="alert alert-error" /></th>
      	</tr>
      	<tr>
      	<th colspan="2"><form:errors path="pincode"  cssClass="alert alert-error"/></th>
      	</tr>
		<tr style="border:1px">
			<th colspan="2">
			<p style="color:white"><strong>Note:</strong>
			<em style="color:red;" >* </em><em>all are mandatory fields</em>
			</th>
		</tr>
		<tr style="border:1px">
      	<th colspan="2"><input type="submit" value="Add Address"  class="btn btn-block btn-primary" /></th>
   		</tr>
	</table>
	 </form:form>
  </div>
</div>
</body>
</html>