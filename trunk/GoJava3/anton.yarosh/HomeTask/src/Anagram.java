import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class Anagram {


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		String toPrint="";
		String []m=input.split(" ");
		String []result=new String[m.length];
		for(int i=0; i<m.length;i++)
		{
			result[i]=convert(m[i]);
		}

		for(int i=0; i<result.length-1; i++)
		{
			toPrint+=result[i]+" ";
		}
		toPrint+=result[result.length-1];
		System.out.println(toPrint);

	}

	static String convert(String m){
		String toReturn="";
		Stack conv=new Stack();
		for(int i=0; i<m.length();i++)
		{
			conv.push(m.charAt(i));
		}

		while(conv.size()!=0)
			toReturn+=conv.pop();

		return toReturn;
	}
}
