<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OTP-VERIFICATION	</title>
<link href="//db.onlinewebfonts.com/c/a4e256ed67403c6ad5d43937ed48a77b?family=Core+Sans+N+W01+35+Light" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style-loginfrom.css" type="text/css">
</head>
<body>
<script type="text/javascript">
var timeleft = 6;
var downloadTimer = setInterval(function(){
timeleft--;
document.getElementById("timer").textContent = timeleft;
if(timeleft <= 0)
	{
	    clearInterval(downloadTimer);
	    linker();
	    
	}
},1000);
function linker()
{
	 var str = "ResendOTP";
	  var result = str.link("resend");
	  document.getElementById("link").innerHTML = result;
}
</script>
<div class="body-content">
  <div class="login-box">
  <img src="/images/index.png" alt="Donating Blood Saves Life" width="20"
         height="80" border-radius= 15px 50px;>
    <h1>Confirm OneTime Password</h1>
    
    <form class="form" action="userAuth" method="post" autocomplete="off" >
      	${mailreponse}
      <table style="float:left">
      	<tr style="border:1px">
      			<th>Enter OTP *</th>
      	</tr>
      	<tr>
      	    <th colspan="2"><input type="text"  palceholder="Enter OTP" name="otpstring"  /></th>
      	</tr>
      	<tr>
      		<th></th>
      	    <th>
      	    <div>remaining seconds:<span id="timer"></span></div>
      	    </th>
      	</tr>
       	<tr>
      		<th></th>
      	    <th>
      	    <span id="link" style="right: 16px; color: #FF9933" > </span>
      	    </th>
      	</tr>
      	<tr style="border:1px">
      	<th colspan="2"><input type="submit" value="Submit OTP"  class="btn btn-block btn-primary" /></th>
   		</tr>
      </table>
      </form>
	</div>
</div> 
</body>
</html>