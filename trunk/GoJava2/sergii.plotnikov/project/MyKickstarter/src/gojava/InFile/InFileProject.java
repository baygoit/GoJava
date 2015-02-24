package gojava.InFile;

import gojava.Payment;
import gojava.Interface.Payments;
import gojava.Interface.Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InFileProject implements Project{
	private File dir;
	private File positions;
	private File money;
	private InFileDescription descr;
	private InFileFAQ faq;
	private InFilePayments payments;
	
	public InFileProject(String string) {
		this.dir = new File(string);
		dir.mkdir();
		
		this.descr = new InFileDescription(dir);
		
		this.positions = new File(dir+"/positions");
		positions.mkdir();
		
		this.faq = new InFileFAQ(positions+"/FAQ");
		
		this.payments = new InFilePayments(positions+"/payments");

		this.money = new File(dir+"/money.txt");	
		if(!money.exists()){
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(money));
				writer.write("10000" + "\n");
				writer.write("0" + "\n");
				writer.write("7" + "\n");
		    	writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getTitle() {		
		return descr.getTitle();
	}

	@Override
	public String getShortDescr() {
		return descr.getShortDescr();
	}

	@Override
	public int getPositionsLength() {
		int counter=0;
		if(!positions.exists()){
			return 0;
		}
		if(positions.isDirectory()){
			for(File f : positions.listFiles()){
				if(f.isDirectory()){
					counter++;
				}
			}
		}
		return counter;
	}

	@Override
	public void addQuestion(String q) {
		faq.addQuestion(q);
	}

	@Override
	public int getRewardsLength() {
		return payments.getRewardsLength();
	}

	@Override
	public int getRewardPrice(int i) {
		String reward =payments.getReward(i+1);
		String[] parts = reward.split("/");
		int result = Integer.parseInt(parts[0]);
		return result;
	}

	@Override
	public void makePayment(Payment p, int amount) {
		payments.makePayment(p);
		try {
			setRecievedMoney(amount);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String shortProjectDescr() {
		String result=getTitle()+"\n";
		result +=getShortDescr()+"\n";
		result+="Money needed: " + getProjectValue() + "; Money collected: " + getRecievedMoney()+"\n";
		result+="Days left: " + getDaysLeft()+"\n";
		result+="--------------------------"+"\n";
		return result;
	}

	@Override
	public String showProject() {
		String result=getTitle()+"\n";
		result +=getShortDescr()+"\n";
		result+="Money needed: " + getProjectValue() + "; Money collected: " + getRecievedMoney()+"\n";
		result+="Days left: " + getDaysLeft()+"\n";
		result+=descr.getProjectStory()+"\n";
		result+=descr.getLink()+"\n";
		result+=faq.showFAQ();
		result+="--------------------------"+"\n";
		result+="1 - Ask question\n2 - Invest\n0 - Go back\n";
		return result;
	}

	public String getProjectValue(){
		return getLineFromFile(1);
	}
	
	public String getRecievedMoney(){
		return getLineFromFile(2);
	}
	
	public String getDaysLeft(){
		return getLineFromFile(3);
	}
	
	public String getLineFromFile(int i) {
		BufferedReader reader=null;
		int line;
		String result="";
		try {
			reader = new BufferedReader(new FileReader(money));
			for(line=1;line<4;line++){
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
	
	public void setRecievedMoney(int amount) throws IOException{
		String recieved = getLineFromFile(2);
		int result = amount + (Integer.parseInt(recieved));
		updateLine(Integer.toString(result));
	}
	
	public void updateLine(String updated) throws IOException {
	    BufferedReader file = new BufferedReader(new FileReader(money));
	    String line;
	    String input = "";

	    while ((line = file.readLine()) != null){
	        input += line+"/";
	    }
	    String[]parts = input.split("/");
	    parts[1]=updated;
	    input=parts[0]+"\n"+parts[1]+"\n"+parts[2]+"\n";
	    file.close();

	    FileOutputStream os = new FileOutputStream(money);
	    os.write(input.getBytes());

	    os.close();
	}

	@Override
	public Payments getPayments() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString(){
		return (positions+"/payments");
	}
}
