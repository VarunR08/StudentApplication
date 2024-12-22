
	package com.Student.DAO;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import com.Student.DTO.Student;
	import com.Student.Connector.ConnectionFactory;

	public class StudentDAOImp implements StudentDAO{

		private Connection con;

		public StudentDAOImp() {
			this.con = ConnectionFactory.requestConnection();
		}

		@Override
		public boolean insertStudent(Student s) {
			String query="INSERT INTO STUDENT VALUES(0,?,?,?,?,?,?,SYSDATE())";
			PreparedStatement ps=null;
			int res=0;
			try {
				ps=con.prepareStatement(query);
				ps.setString(1, s.getName());
				ps.setLong(2, s.getPhone());
				ps.setString(3, s.getMailId());
				ps.setString(4, s.getBranch());
				ps.setString(5, s.getLocation());
				ps.setString(6, s.getPass());
				res=ps.executeUpdate(); //Results stores the value whether the data inserted or not.  
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if(res>0) {
				return true;
			}
			
			return false;
		}

		@Override
		public boolean updateStudent(Student s) {
			String query="update student set name=?,phone=?,mail_id=?,branch=?,location=?,password=? where id=?;";
			PreparedStatement ps=null;
			int res=0;
			try {
				ps=con.prepareStatement(query);
				ps.setString(1,s.getName());
				ps.setLong(2, s.getPhone());
				ps.setString(3, s.getMailId());
				ps.setString(4, s.getBranch());
				ps.setString(5, s.getLocation());
				ps.setString(6, s.getPass());
				ps.setInt(7, s.getId());
				res=ps.executeUpdate();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			if(res>0) {
				return true;
			}
			
			return false;
		}

		@Override
		public boolean deleteStudent(Student s) {
			String DeleteQuery="DELETE FROM STUDENT WHERE name=? and password=?";
			PreparedStatement ps=null;
			int res=0;
			try {
				ps=con.prepareStatement(DeleteQuery);
				ps.setString(1, s.getName());
				ps.setString(2, s.getPass());
				 res=ps.executeUpdate();
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if(res>0) {
				return true;
			}
			
			return false;
		}

		@Override
		public Student getStudent(String mailId, String pass) {
			String query="select * from student where mail_id=? and password=?;";
			PreparedStatement ps=null;
			ResultSet rs=null;
			Student s=null;
			try {
				ps=con.prepareStatement(query);
				ps.setString(1, mailId);
				ps.setString(2, pass);
				rs=ps.executeQuery();
				while(rs.next()) 
				{
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMailId(rs.getString("mail_id"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPass(rs.getString("password"));
				s.setDate(rs.getString("date"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return s;
		}

		@Override
		public List<Student> getStudent() {
			ArrayList<Student> students= new ArrayList<Student>();
			Student s=null;
			String query="SELECT * FROM STUDENT";
			PreparedStatement ps=null;
			ResultSet rs =null;
			try {
				ps=con.prepareStatement(query);
				rs=ps.executeQuery();
				while(rs.next()) {
					s=new Student();
					s.setId(rs.getInt("id"));
					s.setName(rs.getString("name"));
					s.setPhone(rs.getLong("phone"));
					s.setMailId(rs.getString("mail_id"));
					s.setBranch(rs.getString("branch"));
					s.setLocation(rs.getString("location"));
					s.setPass(rs.getString("password"));
					s.setDate(rs.getString("date"));
					students.add(s);
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return students;
		}

		@Override
		public Student getStudent(long phone, String mail_id) {
			
			String query="SELECT * FROM STUDENT WHERE PHONE=? AND mail_id=?"; 
					Student s=null; 
					PreparedStatement ps=null; 
					ResultSet rs=null; 
					try { 
					ps=con.prepareStatement(query); 
					ps.setLong(1, phone);
					ps.setString(2,mail_id); 
					   rs=ps.executeQuery(); 
					   while(rs.next()) 
					   { 
					    s=new Student(); 
					    //String name=rs.getString("name"); 
					    //s.setName(name); 
					    s.setId(rs.getInt("id")); 
					    s.setName(rs.getString("name")); 
					    s.setPhone(rs.getLong("phone")); 
					    s.setMailId(rs.getString("mail_id"));
					    s.setBranch(rs.getString("branch")); 
					    s.setLocation(rs.getString("location")); 
					    s.setPass(rs.getString("password")); 
					    s.setDate(rs.getString("date")); 
					   } 
					  } catch (SQLException e) { 
					   // TODO Auto-generated catch block 
					   e.printStackTrace(); 
					  } 
					  return s;
		}

	}


