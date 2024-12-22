package com.Student.servlet;

import java.io.IOException;

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

@WebServlet("/Update")
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Long phone = Long.parseLong(req.getParameter("phone"));
		String mail = req.getParameter("email");
		String Branch = req.getParameter("branch");
		String Location = req.getParameter("location");

		HttpSession s = req.getSession(false);

		StudentDAO sdao = new StudentDAOImp();

		Student s1 = (Student) s.getAttribute("Student");

		if (s1 != null && id == s1.getId()) {
			s1.setName(name);
			s1.setPhone(phone);
			s1.setMailId(mail);
			s1.setBranch(Branch);
			s1.setLocation(Location);
		

			boolean result = sdao.updateStudent(s1);
			if (result) {
				req.setAttribute("Update", "Profile updated");
				RequestDispatcher rd = req.getRequestDispatcher("Profile.jsp");
				rd.forward(req, resp);
			}else {
				req.setAttribute("Failure", "Failed to update");
				RequestDispatcher rd = req.getRequestDispatcher("Profile.jsp");
				rd.forward(req, resp);
			}

		} else {
			req.setAttribute("Failure", "Failed to update");
			RequestDispatcher rd = req.getRequestDispatcher("Profile.jsp");
			rd.forward(req, resp);
		}
	}
}
