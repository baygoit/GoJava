package com.sergiisavin.kickstarter.project.container.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.naming.OperationNotSupportedException;

import com.sergiisavin.kickstarter.project.Project;
import com.sergiisavin.kickstarter.project.container.Projects;

public class ProjectsContainerFile implements Projects {

	private static final String PATH = System.getProperty("user.dir"); 
	private static final String FILE_NAME = "projects.dat";
	private static final String FILE = PATH + "\\" + FILE_NAME;
	
	private static final int LINES_PER_PROJECT = 10;
	
	@Override
	public void add(Project project) throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}

	@Override
	public int getSize() {
		
		int size = 0;
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(FILE));
			String line = null;
			while( (line = reader.readLine()) != null ){
				size++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(size % LINES_PER_PROJECT != 0){
			throw new Projects.ProjectsFileCorruptedException();
		}
		
		return size / LINES_PER_PROJECT;
	}

	@Override
	public Project getProject(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}

