<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>password</title>
<style type="text/css">
	body{
			background-image:url("/StudentApplications/bg.jpg");
			background-repeat: no-repeat;
			 width:100%;
             height: 100%;
    background-size: cover;
   background-color: aliceblue;
   }

.form{
    width: 450px;
    height: 480px;
    background: linear-gradient(to top,rgba(230, 247, 255,.8)50%,rgba(230, 247, 255,0.8)50%);

    position: absolute;
    top: 150px;
    left: 550px;
    border-radius: 10px;
    padding: 25px;
}
.form h2{
    width: 220px;
    font-family: sans-serif;
    text-align: center;
    color: black;
    font-size: 22px;
  
    border-radius: 10px;
    margin: 2px;
    padding: 8px;
}
.form input:focus{
    outline: none;
}

.head{
	color:brown;
}
.head h3{
	color: blue;
}
.failed{
color:red;
}
</style>



</head>
<body >
<div class="head">
<center><h1 >Pentagon Space</h1></center>
<center><h3>Forgot Password</h3></center>
<%String failuer=(String)request.getAttribute("Failure");
if(failuer!=null){%>
<center><h3 class="failed"><%=failuer%></h3></center>
<%} %>
</div>
<form class="form" action="ForgotPin" method="post">
 <h2><u>Change Password</u></h2>
 <p>Phone Number :</p>
<input type="tel" name="phone" placeholder="Enter your phone-number"><br>
<p>Email :</p>
<input type="email" name="mail" placeholder="Enter your Email"><br>
<p>Password :</p>
<input type="password" name="password" placeholder="Enter password"><br>
<p>Confirm Password :</p>
<input type="password" name="confirm" placeholder="Confirm password">
 <br>
<br>
<input type="submit" value="Update"> <br>
<br> 
<a href="Login.jsp">Back</a>   
</form>
</body>
</html>