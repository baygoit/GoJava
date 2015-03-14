import java.util.Scanner;

public class MinimalDistance {

	public static int[] checkInput(String input) throws Exception {
		String[] arrIn = input.split(" ");
		if (arrIn.length < 2) {
			throw new Exception(
					"Inrut array should contain more than 2 elements");
		}
		int min1 = Integer.parseInt(arrIn[0]);
		int minPos1 = 0;
		int min2 = Integer.parseInt(arrIn[1]);
		int minPos2 = 1;
		for (int i = 2; i < arrIn.length; i++) {
			int currentInt = Integer.parseInt(arrIn[i]);
			if (currentInt < Math.max(min1, min2)) {
				if (min1 != min2) {
					if (min1 > min2) {
						min1 = currentInt;
						minPos1 = i;
					} else {
						min2 = currentInt;
						minPos2 = i;
					}
				} else {
					if (Math.abs(i - minPos1) < Math.abs(i - minPos2)) {
						min2 = currentInt;
						minPos2 = i;
					} else {
						min1 = currentInt;
						minPos1 = i;
					}
				}
			} else if (currentInt == Math.max(min1, min2)) {
				if ((min1 > min2)
						&& (Math.abs(i - minPos2) < Math.abs(minPos1 - minPos2))) {
					minPos1 = i;
				} else if ((min2 > min1)
						&& (Math.abs(i - minPos1) < Math.abs(minPos2 - minPos1))) {
					minPos1 = i;
				} else if (min2 == min1) {
					if (Math.abs(i - minPos1) < Math.abs(i - minPos2)) {
						min2 = currentInt;
						minPos2 = i;
					} else {
						min1 = currentInt;
						minPos1 = i;
					}
				}
			}
		}
		
		int[] returnValues = new int[3];
		returnValues[0] = Math.min(min1,min2);
		returnValues[1] = Math.max(min1,min2);;
		returnValues[2] = Math.abs(minPos2-minPos1);
		return returnValues;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Insert your string of numbers separated by space:");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		int[] values = checkInput(input);
		
		System.out.println("Minimal numbers are: "+values[0]+", "+values[1]);
		
		System.out.println("Distance between them are: "+values[2]);

	}

}
