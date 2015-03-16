
public class GoITFirst {

	public static void main(String[] args) {
	    int [] test = {8,5,6,7,1,6,7,4,5,3};
	    int b = test[0];
	    int a = test[0];
	    int first = 0;
	    int second = 0;
	    
	    for (int i = 1; i < test.length; i++)
	    {
	       if (test[i] < a) 
	       	{
	                a = test[i];
	                second = first;
	                first = i;
	        }else if (test[i] < b)
	        {
	                second = i;
	                b = test[i];
	        }

	     }
	   System.out.println(Math.abs(first - second));

}
}