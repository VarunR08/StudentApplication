<%@page import="com.Student.DTO.Student"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
          font-family:times new roman;
            background-color: #B8C2CE;
            color: brown;
            padding: 1rem;
            text-align: center;
        }
        nav {
            background-color: #333;
            overflow: hidden;
        }
        nav a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        nav a:hover {
            background-color: #575757;
        }
        .container {
            padding: 20px;
        }
        .card {
            background: white;
            margin: 10px;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        }
        
        .grid {
            display: flex;
            gap: 20px;
            flex-wrap: wrap;
        }
        .grid .card {
            flex: 1 1 calc(33.333% - 20px);
        }
        footer {
            text-align: center;
            padding: 10px;
            background: #333;
            color: white;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
.logout{
float: right;
 display: block;

}

    </style>
</head>
<body>
<%Student s=(Student)session.getAttribute("Student"); %>
    <header>
        <h1>Pentagon Space</h1>
    </header>
    <nav>
        <a href="#">Home</a>
        <a href="Project.jsp">Projects</a>
        <a href="#">Mock Ratting</a>
        <a href="Profile.jsp">Profile</a>
        <a href="ForgotPin.jsp">Reset Pin</a>
        <%if(s.getId()==1){ %>
        <a href="view1.jsp">View Users</a>
        <%} %>
        <span class="logout"><a><form action="logout" method="post"><input type="submit" value="logout" name="logout"></form></a></span>
    </nav>
    <div class="container">
    <%if(s.getId()==1){ %>
    <h2>Welcome Admin, <%=s.getName() %></h2>
    <%}else{ %>
        <h2>Welcome, <%=s.getName() %></h2>
        <%} %>
        <div class="grid">
            <div class="card">
                <h3>PROJECTS</h3>
                <p>1.Student_Application</p>
            </div>
            <div class="card">
                <h3>Courses</h3>
                <p>Java Development, Web Design, Devops</p>
            </div>
            <div class="card">
            <h3>Mock Ratting</h3>
                <p> Grade: 9.5</p> 
              
            </div>
        </div>
    </div>
    <footer>
        <p>&copy; 2024 Student Management System</p>
    </footer>
</body>
</html>
    