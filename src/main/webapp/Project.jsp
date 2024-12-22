<%@page import="com.Student.DTO.Student"%>
<%@page import="com.Project.DTO.Project"%>
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
</style>
</head>
<body>
<%Student s=(Student)session.getAttribute("Student"); %>
<%Project p=(Project)session.getAttribute("Project"); %>
<h1><%=s.getName() %> Projects </h1>
<ol>
<%if(p!=null){ %>
<li><%=p.getProject_name() %></li>
<%} %>
</ol>
<form action="Project" method="post">
<h3>Add Projects</h3>
<input type="text" name="project_name" placeholder="Enter the Projetc name" required>
<input type="submit" value="Add Project">
</form>
</body>
</html>