package gojava.InFile;

import gojava.Interface.Categories;

import java.io.*;

public class InFileCategories implements Categories{
	private File dir = new File("txt");
	
	@Override
	public String showCategories() {
		String result="";
		int num=1;
		if (dir.isDirectory()) {
			String [] dirContents = dir.list();
			for (int i = 0; i < dirContents.length ; i++) {
			result+=num+ " - " + (dirContents[i])+"\n";
			num++;
			}
		}
		result+="0 - Go back\n";
		return result;
	}

	@Override
	public String getCategory(int i) {
		if (dir.isDirectory()) {
			String [] dirContents = dir.list();
			return (dir + "/" + dirContents[i]);
		}else return null;
	}

	@Override
	public void addCategory(String string) {
		new InFileCategory(dir +"/"+ string);
	}

	@Override
	public int getLength() {
		int counter=0;
		if(!dir.exists()){
			return 0;
		}
		if(dir.isDirectory()){
			for(File f : dir.listFiles()){
				if(f.isDirectory()){
					counter++;
				}
			}
		}
		return counter;
	}
	
	@Override
	public void fillCategories() {
		dir.mkdir();
		addCategory("Sport");
		addCategory("Music");
		addCategory("Games");
		
		new InFileProject(getCategory(2) + "/Football");
		new InFileProject(getCategory(2) + "/Basketball");
	}
}
