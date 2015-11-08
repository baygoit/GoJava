package gojava.InFile;

import gojava.Payment;
import gojava.Interface.Payments;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InFilePayments implements Payments{
	private File dir;
	private File payments;
	private File rewards;
	
	
	public InFilePayments(String string) {
		this.dir = new File(string);
		dir.mkdir();
		
		this.payments = new File(dir+"/payments.txt");
		if(!payments.exists()){
			try {
				payments.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.rewards = new File(dir+"/rewards.txt");
		if(!rewards.exists()){
			BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(rewards, true));
				writer.write("1"+"/"+"thanks!"+"\r\n");
				writer.write("5"+"/"+"thank you!"+"\r\n");
				writer.write("10"+"/"+"THANK YOU!"+"\r\n");
				
		    	writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void makePayment(Payment p) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(payments, true));
			writer.write(p.getName()+"/"+p.getCard()+"/"+p.getAmount() +"\r\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String showRewards() {
		BufferedReader reader=null;
		String result="";
		int num=1;
		try {
			reader = new BufferedReader(new FileReader(rewards));
			String data = reader.readLine();
        	
	        while (data != null) {
	        	String[] parts = data.split("/");
	        	
	            result +=num+" - "+ parts[0] + "$, "+ parts[1] + "\n";
	            data = reader.readLine();
	            num++;
	        }
	        reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result+=num + " - Another amount\n0 - Go back\n";
		return result;
	}

	@Override
	public int getRewardsLength() {
		BufferedReader reader=null;
		int counter=0;
		try {
			reader = new BufferedReader(new FileReader(rewards));
			String data = reader.readLine();
	        
	        while (data != null) {
	        	counter++;
	        	data = reader.readLine();
	        }
	        reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return counter;
	}

	@Override
	public String getReward(int i) {
		BufferedReader reader=null;
		int line;
		String result="";
		try {
			reader = new BufferedReader(new FileReader(rewards));
			for(line=1;line<=getRewardsLength();line++){
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
