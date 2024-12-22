package com.Student.servlet;

import java.io.IOException;

import com.Project.DAO.ProjectDAO;
import com.Project.DAO.ProjectDAOimp;
import com.Project.DTO.Project;
import com.Student.DTO.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Project")
public class Projects extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession s = req.getSession();
	String projectname=req.getParameter("project_name");
	
	
	ProjectDAO pdao=new ProjectDAOimp();
	Student s1 = (Student) s.getAttribute("Student");
	Project p=new Project();
	p.setProject_name(projectname);
	p.setId(s1.getId());
	boolean result=pdao.insertProject(p);
	if(result) {
		
		s.setAttribute("Project",p);
		RequestDispatcher rd=req.getRequestDispatcher("Project.jsp");
		rd.forward(req, resp);
	}
	else {
	
		req.setAttribute("failuer","failed to add");
		RequestDispatcher rd=req.getRequestDispatcher("Project.jsp");
		rd.forward(req, resp);
	}

}
}
