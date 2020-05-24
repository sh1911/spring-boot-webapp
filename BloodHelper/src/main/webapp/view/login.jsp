<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="//db.onlinewebfonts.com/c/a4e256ed67403c6ad5d43937ed48a77b?family=Core+Sans+N+W01+35+Light" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style-loginfrom.css" type="text/css">
<style type="text/css">
th{
text-align:left;
}

</style>
</head>
<body>
<div class="body-content">
  <div class="login-box">
  	<span>
		<i>Donating Blood Saves Life</i>
		<img id=rcorners1 src="<%=request.getContextPath()%>/images/bloodlogo.png" >
	</span>
	<h1>Login</h1>
	<form action="/login" method="POST">
		<span>
			<em style="color:red;" >${SPRING_SECURITY_LAST_EXCEPTION.message}</em>
		</span>
		<table style="float:left">
      	<tr style="border:1px">
      	<th>Email *	</th>
      	</tr>
      	<tr style="border:1px">
      	<th colspan="2"><input type="email" name="username" required="required"></th>
      	</tr>
      	<tr style="border:1px">
      	<th>	Password* </th>
      	</tr>
      	<tr style="border:1px">
      	<th colspan="2"><input type="password" name="password" required="required"></th>
      	</tr>
		<tr style="border:1px">
      	<th colspan="2"><input type="submit" value="Login" name="register" class="btn btn-block btn-primary" /></th>
   		</tr>
	</table>
	</form>
	</div>
</div>
</body>
</html>