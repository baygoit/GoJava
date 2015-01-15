package ua.com.goit.gojava.Moisa.Distance;

import java.util.Scanner;

/* “во€ задача создать консольное приложение, которое принимало бы на вход 
 * р€д чисел и выводило рассто€ние между двум€ наименьшими. 
 Ќапример, дано р€д чисел: "23 45 34 12 45 4 38 56 2 49 100". 
 Ќаименьшие числа в нем 2 и 4. –ассто€ние между ними - 3. 
 */

// Without try-catch
public class Distance {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("Please enter number, use <spacebar> to separate number:");
		String s = scan.nextLine();
		String parts[] = s.split(" ");

		int[] num = new int[parts.length];

		for (int i = 0; i < parts.length; i++) {
			num[i] = Integer.parseInt(parts[i]);
		}
			
		int min1 = num[0];
		int min2 = num[1];
		int pos1 = 0;
		int pos2 = 0;
		
		for (int i = 0; i < num.length; i++) {
			if (num[i] <= min1) {
				min1 = num[i];
				pos1 = i;
			}
		}

		for (int i = 0; i < num.length; i++) {
			if (num[i] <= min2 && num[i] != min1) {
				min2 = num[i];
				pos2 = i;
			}
		}
		System.out.println("The distance between two smaller numbers = " + Math.abs(pos1 - pos2));
	}
}
