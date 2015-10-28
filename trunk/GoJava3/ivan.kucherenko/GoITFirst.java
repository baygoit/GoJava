
public class GoITFirst {
	/*Test case
	 * Condition: Find the smallest distance between two elements of the array
	 * input: {2,9,6,7,3,6,7,4,5,3}, {0,9,6,7,3,6,7,4,5,3}
	 * {1,0,6,7,3,6,7,4,5,3},{0,8,2,7,3,6,7,4,5,3}
	 * */

	public static void main(String[] args) {
	    int [] test = {0,8,2,7,3,6,7,4,5,3};
	    int a = test[0];
	    int b = test[1];
	    int first = 0;
	    int second = 1;
	    for (int i = 2; i < test.length; i++)
	    {
	       if (test[i] < a) 
	       	{
	           a = test[i];
	           second = first;
	           first = i;
	        }else if (test[i] >= a && test[i] < b)
	        {
	           second = i;
	           b = test[i];
	        }
	     }
	    
	   System.out.println(Math.abs(first - second));

}
}