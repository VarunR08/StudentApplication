package com.Project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Project.DTO.Project;
import com.Student.Connector.ConnectionFactory;
import com.Student.DTO.Student;

public class ProjectDAOimp implements ProjectDAO{
	
	private Connection con;

	public ProjectDAOimp() {
		this.con = ConnectionFactory.requestConnection();
	}

	@Override
	public boolean insertProject(Project p) {
		String query="INSERT INTO Project VALUES(?,?)";
		PreparedStatement ps=null;
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getProject_name());
			
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
	public Project getProjects(int id) {
		String query="select * from Project where id=? ;";
		PreparedStatement ps=null;
		ResultSet rs=null;
		Project p=null;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1,p.getId());
			
			rs=ps.executeQuery();
			while(rs.next()) 
			{
			p=new Project();
			p.setId(rs.getInt("id"));
			p.setProject_name(rs.getString("Project_name"));
			
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}

}
