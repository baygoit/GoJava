import java.util.Arrays;


public class LonelyNumber {

	public static void main(String[] args) {
		int m[]={2,3,2,4,3,7,2,3,4,4,5,5,5,7,7,50,100,100,100};
		int rez[]=new int[100];
		int lonelyNumber=0;
		int maxIndex=0;
		for(int i=0;i<m.length;i++)
		{
			int k=m[i];
			int j=0;
			while(k!=0)
			{
				if(j>=rez.length-1)
				{rez=Arrays.copyOf(rez, rez.length*2);}
				rez[j]=rez[j]+k%2;
				k=k/2;
				j++;
			}
			if(j>maxIndex)
				maxIndex=j;
		}
		for(int i=0;i<=maxIndex-1;i++)
			lonelyNumber=(int) (lonelyNumber+rez[i]%3*Math.pow(2, i));

		System.out.println(lonelyNumber);
	}

}
