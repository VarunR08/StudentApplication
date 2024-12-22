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
@WebServlet("/Login")
public class Login extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, 
				HttpServletResponse resp) throws ServletException, IOException { 
				   // Creating Session object
			HttpSession s=req.getSession();
			
				  //collect the data from the user  
				  String mail=req.getParameter("mail"); 
				  String password=req.getParameter("password"); 
				  //PrintWriter out=resp.getWriter(); 
				   
				  //jdbc implementation 
				  StudentDAO sdao=new StudentDAOImp(); 
				  Student s1=sdao.getStudent(mail, password); 
				  if(s1!=null && s1.getId()==1) {
					  s.setAttribute("Student",s1);
						RequestDispatcher rd=req.getRequestDispatcher("Success.jsp");
						rd.forward(req, resp);
				  }
				  if(s1!=null && s1.getId()!=1) 
				  { 
				  // out.println("<h1>Login successful, Welcome "+s.getName()+"</h1>"+ "<br>"+ "<a href=\"Login.html\">Back</a>");
					//  resp.sendRedirect("Success.jsp");
					  
					  s.setAttribute("Student",s1);
						RequestDispatcher rd=req.getRequestDispatcher("Success.jsp");
						rd.forward(req, resp);
				  } 
				  else 
				  { 
				  // out.println("<h1>Invalid mail or password!</h1>"+ "<br>"+ "<a href=\"Login.html\">Back</a>"); 
					 // resp.sendRedirect("Failure.html");
					  req.setAttribute("failure","Failed to Logins");
					  RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
						rd.forward(req, resp);
				  }   
				  
		} 
		}

