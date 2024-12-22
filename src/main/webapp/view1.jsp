
<%@page import="java.util.Iterator"%>
<%@page import="com.Student.DTO.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.Student.DAO.StudentDAOImp"%>
<%@page import="com.Student.DAO.StudentDAO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
    <style>
        table {
            width: 50%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid black;
            text-align: center;
        }
    </style>
</head>
<body>
    <h2 style="text-align:center;">Student Information</h2>
    <table>
        <tr>
            <th>Student ID</th>
            <th>Name</th>
            <th>Branch</th>
            <th>mail_Id</th>
            <th>Delete Student</th>
        </tr>
        <%StudentDAO dao = new StudentDAOImp();
       List <Student> students = dao.getStudent();
       Student s=null;
       Iterator<Student> it = students.iterator();
       while(it.hasNext()){
    	   s=it.next();
       
        %>
        <tr>
            <td><%=s.getId() %></td>
            <td><%=s.getName()%></td>
            <td><%=s.getBranch() %></td>
            <td><%=s.getMailId() %></td>
            <td><form action="delete" method="post"><button type="submit" value="Delete">Delete</button></form></td>
        </tr>
        <%} %>
        
       
    </table>
</body>
</html>
    