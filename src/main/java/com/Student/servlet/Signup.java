package com.Student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.Student.DAO.StudentDAO;
import com.Student.DAO.StudentDAOImp;
import com.Student.DTO.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignUp")
public class Signup extends HttpServlet{

	// collecting the data
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name=req.getParameter("name");
		String phonenumber=req.getParameter("phone");
		String mail=req.getParameter("email");
		String branch=req.getParameter("branch");
		String location=req.getParameter("location");
		String password=req.getParameter("password");
		String confirmpass=req.getParameter("confirm_password");
		
		//converting necessary datatypes
		long phone=Long.parseLong(phonenumber);
		//PrintWriter out=resp.getWriter();
		
		//adding to database
		Student s=new Student();
		StudentDAO sdao=new StudentDAOImp();
		if(password.equals(confirmpass)) {
			s.setName(name);
			s.setPhone(phone);
			s.setMailId(mail);
			s.setLocation(location);
			s.setBranch(branch);
			s.setPass(confirmpass);
			boolean result=sdao.insertStudent(s);
			if(result) {
				//out.println("<h1>Data Added successfully</h1>");
				req.setAttribute("success","signup successfull");
				RequestDispatcher rd=req.getRequestDispatcher("SignUp.jsp");
				rd.forward(req, resp);
			}
			else {
			//	out.println("<h1>Failed to add the data</h1>");
				req.setAttribute("failuer","signup failed");
				RequestDispatcher rd=req.getRequestDispatcher("SignUp.jsp");
				rd.forward(req, resp);
			}
		}
		
	}
	
	
}
