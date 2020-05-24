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
<script type="text/javascript">
  function Toggle() { 
      var temp1 = document.getElementById("oldpassword"); 
      var temp2 = document.getElementById("newpassword"); 
      if (temp1.type == "password"&&temp2.type=="password") { 
          temp1.type = "text";
          temp2.type="text"
       } 
      else { 
          temp1.type = "password"; 
          temp2.type="password"
      } 
  } 

</script>
<div class="body-content">
  <div class="module">
    <span>
	<i>Donating Blood Saves Life</i>
	<img id=rcorners1 src="<%=request.getContextPath()%>/images/bloodlogo.png" >
	</span>
    <h1>Update Profile</h1>
    
    <form class="form" action="/user/saveUser" method="post" autocomplete="off">
      	<div class="alert alert-error">${message}</div>
      <table style="float:left">
      	<tr style="border:1px">
      	    	<th colspan="2">FullName <input type="text"  value="${user.fname} ${user.lname}" readonly/></th>
      	</tr>
      	<tr style="border:1px">
			<th colspan="2">Email<em style="color:red;" >* </em><input type=email name="email" value="${user.email}" required="required"/></th>
		</tr>	
		</tr>
     	<tr style="border:1px">
			<th colspan="2">
			<p style="color:white"><strong>Note:</strong>
			<em style="color:red;" >* </em><em>all are mandatory fields</em>
			</th>
		</tr>
		<tr style="border:1px">
      	<th colspan="2"><input type="submit" value="update"  class="btn btn-block btn-primary" /></th>
   		</tr>
	</table>
	 </form>
  </div>
</div>
</body>
</html>