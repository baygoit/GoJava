package belskii.artem.kickstarter.dao.category;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CategoryDaoImplFile implements CategoryDao {
	String FILE_PATH="src/main/resources/dataInFiles/categories.txt";


	public void addCategory(String categoryInfo) {
		 try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true)))
	        {
	           
	           	int index = this.getCategoryList().size();
	            writer.write(String.valueOf(index));
	            writer.append(";");
	            writer.append(categoryInfo);
	            writer.append('\n');
				writer.close();
	        }
	        catch(IOException ex){
	            
	            System.out.println(ex.getMessage());
	        } 
	}

	public Map<Integer, String> getCategoryList() {
		HashMap<Integer, String> categoryList = new HashMap<Integer, String>();
		
	      try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH)))
	        {
	    	  	for(String line; (line = reader.readLine()) != null; ) {
	    	  		String splittedString [] = line.split(";");
	    	  		int index = new Integer(splittedString[0]);
	    	  		String categoryName=splittedString[1];
	    	  		categoryList.put(index, categoryName);
	    	  	}
    	  		reader.close();
	        }
	        catch(IOException ex){
	            
	            System.out.println(ex.getMessage());
	        }   
	      return categoryList;
	}

	public String getCategoryNameById(int id) {
		String answer=this.getCategoryList().get(id);
		return answer;
	}

	@Override
	public void initDemoDB() {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false)))
        {   writer.write("");
            writer.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
		this.addCategory("Art");
		this.addCategory("Comics");
		this.addCategory("Crafts");
		this.addCategory("Dance");
		this.addCategory("Design");
		this.addCategory("Fashion");
		this.addCategory("Film & Video");
		this.addCategory("Food");
		this.addCategory("Games");
		this.addCategory("Journalism");
		this.addCategory("Music");
		this.addCategory("Photography");
		this.addCategory("Publishing");
		this.addCategory("Technology");
		this.addCategory("Theater");
	}

}
