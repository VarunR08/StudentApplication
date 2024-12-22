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
    top: 170px;
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
.sucess{
color:green;
}
.failed{
color:red;
}
</style>
</head>
<body> 
	<div class="head">
<center><h1 >Pentagon Space</h1></center>
<center><h3>Application form</h3></center>
<%String success=(String)request.getAttribute("success");
if(success!=null){%>
<center><h3 class="success"><%=success %></h3></center>
<%} %>
<%String failuer=(String)request.getAttribute("failuer");
if(failuer!=null){%>
<center><h3 class="failed"><%=failuer %></h3></center>
<%} %>
</div>
<form action="SignUp" class="frm" method="post">
<lable>Enter your Name: </lable>
<input type="text" name="name" >
<br><br>
<lable>Enter Phone Number: </lable>
<input type="tel" name="phone">
<br><br>
<lable>Enter Mail ID: </lable>
<input type="email" name="email">
<br><br>
<lable>Enter the Branch: </lable>
<input type="text" name="branch">
<br><br>
<lable>Enter the Location: </lable>
<input type="text" name="location">
<br><br>
<lable>Enter the password: </lable>
<input type="password" name="password">
<br><br>
<lable>Confirm the password: </lable>
<input type="password" name="confirm_password">

<input type="submit" value="create account" class="btn"> 
already have a account?<a href="Login.jsp">login</a> 
</form>
</body>
</html>