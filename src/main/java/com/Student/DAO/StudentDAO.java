package com.Student.DAO;


	import java.util.List;

	import com.Student.DTO.Student;

	public interface StudentDAO {

		public boolean insertStudent(Student s);
		public boolean updateStudent(Student s);
		public boolean deleteStudent(Student s);
		public Student getStudent (String mail_id,String pass);
		public List<Student> getStudent();
		public Student getStudent (long phone,String mail_id);
		
		
		
	}

