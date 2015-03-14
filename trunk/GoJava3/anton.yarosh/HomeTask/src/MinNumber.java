import java.util.Arrays;
import java.util.Scanner;


public class MinNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		String []m=input.split(" ");
		int []n=new int[m.length];
		for(int i=0; i<m.length; i++)
		{
			n[i]=Integer.parseInt(m[i]);
		}
		int minElement=findMin(n)[0];
		int firstIndex=findMin(n)[1];
	
		for(int i=0; i<n.length;i++)
		{
			n[i]=n[i]-minElement;
		}

		int secondIndex=findMin(n)[1];

		System.out.println(Math.abs(firstIndex-secondIndex));
	}

	static int[] findMin(int []n){
		int minElement=1;
		int index=0;
		for(int i=0; i<n.length;i++)
		{
			if(n[i]!=0)
				if(minElement>=n[i])
				{
					minElement=n[i];
					index=i;
				}
		}
		return new int[]{minElement,index};
	}
}
