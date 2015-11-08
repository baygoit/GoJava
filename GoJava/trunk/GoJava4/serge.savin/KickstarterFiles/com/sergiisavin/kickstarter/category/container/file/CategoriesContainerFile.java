package com.sergiisavin.kickstarter.category.container.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.naming.OperationNotSupportedException;

import com.sergiisavin.kickstarter.category.Category;
import com.sergiisavin.kickstarter.category.container.Categories;

public class CategoriesContainerFile implements Categories{

	private static final String PATH = System.getProperty("user.dir"); 
	private static final String FILE_NAME = "categories.dat";
	private static final String FILE = PATH + "\\" + FILE_NAME;
	
	public CategoriesContainerFile(){}
	
	public CategoriesContainerFile(String...strings){
		
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(FILE));
			for(String category : strings){
				writer.write(category + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void add(String categoryName) throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}

	@Override
	public void add(Category category) throws OperationNotSupportedException {
		throw new OperationNotSupportedException();
	}

	@Override
	public Category get(int targetIndex) {
		
		if(targetIndex < 0 || targetIndex > (getSize()-1)){
			throw new Categories.IllegalArgumentException();
		}
		
		BufferedReader reader = null;
		int fileIndex = 0;
		String line = null;
		try {
			reader = new BufferedReader(new FileReader(FILE));
			while( (line = reader.readLine()) != null){
				if(fileIndex == targetIndex){
					return new Category(line);
				}
				fileIndex++;
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
		
		return null;
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
		
		return size;
	}

}
