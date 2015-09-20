package ua.com.goit.gojava.plotnikov.stolbik;
import java.io.*;

public class stolbik {

	public static class Division{
		int x1;
		int x2;
		float result;
		int vychet;
		
		int marginCounter = 0;
		
		public int newX1(){ return (x1%x2)*10; }
		
		public void newVychet(){ vychet=(x1-(x1%x2)); }
		
		public void marginCheck(){
			int nextX1=newX1()/10;
			int length1=String.valueOf(nextX1).length();
			int length2=String.valueOf(vychet).length();
			marginCounter+=(length2-length1);
		}
		
		public void thisOperationMargin(){
			int length1=String.valueOf(x1).length();
			int length2=String.valueOf(vychet).length();
			marginCounter+=(length1-length2);
		}
		
		public void margin(int a){
			for(int i=0; i<marginCounter-a; i++){
				System.out.print(" ");
			}
		}
		
		public void show(int numOfOperations){
			for(int i = 0; i < numOfOperations; i++){
				margin(0);
				System.out.println("----");
				
				marginCheck();
				x1=newX1();
				
				if(x1==0){
					margin(0);
					System.out.println("0");
					break;
				}
				
				margin(0);			
				System.out.println(x1);
				
				newVychet();
				thisOperationMargin();
				margin(1);
				System.out.println("-" + vychet);
			}
		}
	}
		
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Division div = new Division();
		
		System.out.print("1-е число");
		String s = reader.readLine();
		div.x1 = Integer.parseInt(s);
		
		System.out.print("2-е число");
		s = reader.readLine();
		div.x2 = Integer.parseInt(s);
				
		div.result = (float)div.x1/div.x2;
		
		if(div.x1<div.x2){ div.x1*=10; }
		
		System.out.println(" " + div.x1 + " |" + div.x2);
		div.newVychet();
		div.thisOperationMargin();
		div.margin(0);
		
		System.out.println("-" + div.vychet + " |" + div.result);
		div.marginCounter++;
		
		div.show(5);
	}
}