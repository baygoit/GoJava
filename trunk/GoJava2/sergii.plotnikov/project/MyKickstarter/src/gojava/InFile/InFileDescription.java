package gojava.InFile;

import gojava.Interface.Description;

import java.io.*;

public class InFileDescription implements Description{
	private File dir;
	private File description;

	public InFileDescription(File dir) {
		this.dir = new File(dir+"/descr");
		this.dir.mkdir();
		
		this.description = new File(this.dir+"/description.txt");
		if(!description.exists()){
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(description));
				writer.write(dir.getName() + "\r\n");
				writer.write("this is a short description" + "\r\n");
				writer.write("this is a very interesting project story" + "\r\n");
				writer.write("www.link.com" + "\r\n");
		    	writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getTitle() {
		String result = getLineFromFile(1);
        return result;
	}

	@Override
	public String getShortDescr() {
		String result = getLineFromFile(2);
        return result;
	}

	@Override
	public String getProjectStory() {
		String result = getLineFromFile(3);
        return result;
	}

	@Override
	public String getLink() {
		String result = getLineFromFile(4);
        return result;
	}

	public String getLineFromFile(int i) {
		BufferedReader reader=null;
		int line;
		String result="";
		try {
			reader = new BufferedReader(new FileReader(description));
			for(line=1;line<5;line++){
				if(line==i){
					result=reader.readLine();
				}else{
					reader.readLine();
				}
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
