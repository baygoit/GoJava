import java.util.Arrays;
import java.util.Scanner;
public class MinNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//String input = sc.nextLine();
		//String input ="0 2 5 1 8 4 0 7 2 6 4 2 1 8 6 0 0 1";
		//String input ="1 5 5 5 1 0 9 9 0";
		String input="6 5 3 1 6 2 1 5 8 3 1 1";
		String[]m = input.split(" ");
		int []rez = new int[m.length];
		for (int i = 0; i < m.length; i++) {
			rez[i] = Integer.parseInt(m[i]);
		}
		int minElement = rez[0];
		int minIndex = 0;
		int minGapIndex = 1;
		int minGap = Math.abs(rez[minIndex] - rez[minGapIndex]);
		int equalGap = Integer.MAX_VALUE;
		int finalGap = 0;
		for (int i = minIndex + 1; i < rez.length; i++) {
			if (minElement > rez[i]) {
				minGap = minElement - rez[i];
				minElement = rez[i];
				minGapIndex = minIndex;
				minIndex = i;
				equalGap = Integer.MAX_VALUE;
			}
			else if (minElement == rez[i]) {
				if (Math.abs(minIndex - i) < equalGap){
					equalGap = Math.abs(minIndex - i);
					minIndex = i;
				}
				else {
					minIndex = i;						
				}
			}
			else {
				if (Math.abs(minElement - rez[i]) < minGap) {
					minGap = Math.abs(minElement - rez[i]);
					minGapIndex = i;
				}
				else if(Math.abs(minElement - rez[i]) == minGap) {
					if (Math.abs(minIndex - minGapIndex) > Math.abs(minIndex - i)) {
						minGapIndex = i;
					}
				}
			}
		}
		if (equalGap == Integer.MAX_VALUE) {
			finalGap = Math.abs(minIndex - minGapIndex); 
			System.out.println("Min element: " + rez[minIndex] + ", next closets value: " + rez[minGapIndex]);
		}
		else {
			finalGap = equalGap;
			System.out.println("Minimal repeated value: " + rez[minIndex]);			
		}
		System.out.println("Minimal distance: " + finalGap);
	}
}
