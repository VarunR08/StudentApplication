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
import jakarta.servlet.http.HttpSession; 

@WebServlet("/ForgotPin") 
public class ForgotPin extends HttpServlet {

	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		//collect the data from user 
		  String phonenumber=req.getParameter("phone"); 
		  String mail=req.getParameter("mail"); 
		  String password=req.getParameter("password"); 
		  String confirmPassword=req.getParameter("confirm"); 
		   
		  // calling session object
		  HttpSession s=req.getSession(false);
		  
		  //conversion of datatypes 
		  long phone=Long.parseLong(phonenumber); 
		  //PrintWriter out=resp.getWriter(); 
		   
		  //JDBC Implementation 
		  StudentDAO sdao=new StudentDAOImp(); 
		  Student s1= (Student)s.getAttribute("Student");
		  
		  if(s1!=null&&phone==s1.getPhone()&&mail.equals(s1.getMailId())&&password.equals(confirmPassword)) 
		  { 
		   s1.setPass(confirmPassword); 
		   boolean result=sdao.updateStudent(s1); 
		   if(result) 
		   {    
			   req.setAttribute("Update","Password Updated");
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
		   }
		   else 
		   { 
		   
			   req.setAttribute("Failure","Failed to update");
				RequestDispatcher rd=req.getRequestDispatcher("ForgotPin.jsp");
				rd.forward(req, resp);
		   } 
		   }
		  else 
		   { 
			   req.setAttribute("Failure","Failed to update");
				RequestDispatcher rd=req.getRequestDispatcher("ForgotPin.jsp");
				rd.forward(req, resp);
		   }
		   } 
		   }

