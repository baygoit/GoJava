package gojava.InFile;

import gojava.Interface.Category;

import java.io.*;

public class InFileCategory implements Category{
	private File dir;
	
	public InFileCategory(String string) {
		this.dir = new File(string);
		dir.mkdir();
	}
	
	@Override
	public File getTitle() {
		return dir;
	}

	@Override
	public String showProjects() {
		String result="You have chosen Category "+dir.getName()+"\n";
		int num =1;
		if (dir.isDirectory()) {
			String [] dirContents = dir.list();
			if(dirContents.length==0){
				return "Empty!\n0 - Go back\n";
			}
			for (int i = 0; i < dirContents.length ; i++) {
				InFileProject tempProj=new InFileProject(dir+"/"+dirContents[i]);
				result+=num + " - " + tempProj.shortProjectDescr();
				num++;
			}
		}
		result+="0 - Go back\n";
		return result;
	}

	@Override
	public String getProject(int i) {
		if (dir.isDirectory()) {
			String [] dirContents = dir.list();
			return (dir + "/" + dirContents[i]);
		}else return null;
		
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
	public void addProject(String string) {
		new InFileProject(dir +"/"+ string);
	}
}
