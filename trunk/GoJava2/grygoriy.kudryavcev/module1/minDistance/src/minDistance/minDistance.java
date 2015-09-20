package minDistance;
// import java.util.Scanner;



public class minDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int i;
		int x1;
		int pos1;
		int x2;
		int pos2;
	
		
		int[] nums = {23,45,34,12,45,4,3,38,56,2,49,100};
		x1 = nums[0];
		x2 = nums[0];
		pos1 = 0;
		pos2 = 0;
		
		
		for (int i = 0; i < nums.length; i++)
		{
	
				if (nums[i] < x1)
				{
				pos1 = i;
				x1 = nums[i];	
				}
					
												}
		
		 for (int i = 0; i < nums.length; i++)
		 {
			
			 	if (x2 > nums[i] && i != pos1 )
			 	{
			 	pos2 = i;
			 	x2 = nums[i];	
			 	}
			
		 }
		
		 
		 int dist = pos2 - pos1;
		
	System.out.println("Minimum1:" + nums[pos1]);			
	System.out.println("Minimum2:" + nums[pos2]);
	System.out.println("Distance:" + dist);

	
	}
		
			
		
	}
