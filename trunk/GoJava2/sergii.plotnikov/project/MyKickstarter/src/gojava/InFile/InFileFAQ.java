package gojava.InFile;

import gojava.Interface.FAQ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InFileFAQ implements FAQ{
	private File dir;
	private File faq;
	
	public InFileFAQ(String string){
		this.dir=new File(string); 
		dir.mkdir();
		
		faq=new File(dir+"/FAQ.txt");
		if(!faq.exists()){
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(faq));
				for(int i = 0; i<3; i++){
					writer.write("Q: this is a question" +"\r\n");
					writer.write("A: this is an answer" +"\r\n");
				}
		    	writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String showFAQ() {
		BufferedReader reader=null;
		String result="";
		try {
			reader = new BufferedReader(new FileReader(faq));
			String data = reader.readLine();
	        
	        while (data != null) {
	            result += data+"\n";
	            data = reader.readLine();
	        }
	        reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void addQuestion(String q) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(faq, true));
			writer.write("Q: " + q +"\r\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
