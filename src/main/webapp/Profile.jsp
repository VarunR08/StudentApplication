<%@page import="com.Student.DTO.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Profile Update</title>
    <style>
        body {
        background-image: url("/StudentApplications/bg.jpg");
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f9;
        }
        .profile-container {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 400px;
            
        }
        h2 {
            margin-bottom: 20px;
            color: #333;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }
        input, textarea, button {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        input[type="file"] {
            padding: 5px;
        }
        button {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            transition: background 0.3s ease;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%Student s=(Student)session.getAttribute("Student"); %>
    <div class="profile-container">
    <%String update=(String)request.getAttribute("Update"); 
    if(update!=null){ %>
    <h2><%=update %></h2><%} %>
     <%String failuer=(String)request.getAttribute("Failure");
if(failuer!=null){%>
<center><h2 class="failed"><%=failuer%></h2></center>
<%} %> 
        <h2><%=s.getName() %>'s Profile</h2>
        <form action="Update" method="post">
            <label for="name">Student ID:</label>
            <input type="tel" id="id" name="id"  value="<%=s.getId() %>">
            
            <label for="name">Full Name:</label>
            <input type="text" id="name" name="name" value="<%= s.getName()%>" >

            <label for="email">Email Address:</label>
            <input type="email" id="email" name="email" value="<%= s.getMailId()%>">

            <label for="phone">Phone Number:</label>
            <input type="tel" id="phone" name="phone" value="<%= s.getPhone()%>">

            <label for="phone">Branch:</label>
            <input type="text" id="branch" name="branch" value="<%= s.getBranch()%>">
            
            <label for="address">Location:</label>
            <input type="text" id="location" name="location" value="<%= s.getLocation()%>">

            <label for="profile-pic">Signup Date:</label>
            <input type="text" id="date" name="data" disabled="disabled" value="<%= s.getDate() %>" >

            <button type="submit">Save Changes</button>
        </form>
    </div>
</body>
</html>
    