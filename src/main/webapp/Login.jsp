<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	body{
		background-image: url("/StudentApplications/bg.jpg");
	}
	form{
    width: 260px;
    height: 380px;
    background: linear-gradient(to top,rgba(230, 247, 255,.8)50%,rgba(230, 247, 255,0.8)50%);

    position: absolute;
    top: 160px;
    left: 620px;
    border-radius: 10px;
    padding: 25px;
}
	
	.form input{
    width:240px;
    height: 35px;
    background:transparent;
    border-bottom: 1px solid #ff7200;
    border-top: none;
    border-right: none;
    border-left: none;
    color: black;
    font-size: 15px;
    letter-spacing: 1px;
    margin-top: 30px;
    font-family: sans-serif;
}

.form input:focus{
    outline: none;
}
::placeholder{
    color: black;
    font-family: Arial;
}

.btn{
    width: 240px;
    height: 40px;
    background: skyblue;
    border: none;
    margin-top: 30px;
    font-size: 18px;
    border-radius: 10px;
    cursor: pointer;
    color: black;
    transition: 0.4s ease;
}

.btn:hover{
    background: #006999;
    color: #ff7200;
}
.btn a{
    text-decoration: none;
    color: #000;
    font-weight: bold;
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
.update{
color:green;
}
    
    
</style>
</head>
<body style="background-color:Aliceblue">
	<div class="head">
<center><h1 >Pentagon Space</h1></center>
<center><h3>Login</h3></center>
<%String success=(String)request.getAttribute("success");
if(success!=null){%>
<center><h3 class="update"><%=success%></h3></center>
<%} %>
<%String failuer=(String)request.getAttribute("failuer");
if(failuer!=null){%>
<center><h3 class="failed"><%=failuer%></h3></center>
<%} %>
<%String Update=(String)request.getAttribute("Update");
if(Update!=null){%>
<center><h3 class="update"><%=Update%></h3></center>
<%} %>
</div>

<form action="Login" method="post">

<p>UserMail<p>
<input type="email" name="mail" placeholder="Enter email">
<p>Password</p>
<input type="password" name="password" placeholder="Enter password"><br><br>
<a href="ForgotPin.jsp">forget password?</a>
<br>

<input type="submit" value="login" class="btn">
<br>
Don't have a account.?<br>
<a href="SignUp.jsp">SignUp</a>



</form>
</body>
</html>