package ua.com.goit.gojava1.grigorius0sol.RCCreateModel;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ViewParts {
	
	
	public List<String> getDetailsCat(){
		
		List<String> categoryList = new ArrayList<String>();
		File current = new File("C:\\workspace\\RCModelConstructor\\src\\ua\\com\\goit\\gojava1\\grigorius0sol\\RCCreateModel\\Data\\Details\\");
		for( File f : current.listFiles()){
			
            categoryList.add(f.getName());
        }
		return categoryList;
	}
	
	public List<String> getDetails(String name) throws IOException{
		
		List<String> detailsList = new ArrayList<String>();
		File details = new File("C:\\workspace\\RCModelConstructor\\src\\ua\\com\\goit\\gojava1\\grigorius0sol\\RCCreateModel\\Data\\Details\\" + name);
		try {
			String s;
			BufferedReader reader = new BufferedReader(new FileReader(details));
			while((s = reader.readLine()) != null){
				
				detailsList.add(s);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return detailsList;
	}
}
