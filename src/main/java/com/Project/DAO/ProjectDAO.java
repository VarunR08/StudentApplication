package com.Project.DAO;

import com.Project.DTO.Project;


public interface ProjectDAO {
public boolean insertProject(Project p);
public Project getProjects(int id);
}
