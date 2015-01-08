import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MinRange {
	
	private static int getMinRange(List<Integer> list) {
        int i1 = 0; // Index of very first minimum value of array
        int i2 = 0; // Index of second minimum value of array
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++) {
            Integer currentValue = list.get(i);
            if (currentValue <= min) {
                min = currentValue;
                i2 = i1;
                i1 = i;
            } else if (currentValue == min) {
                i2 = i;
            }
        }
        return Math.abs(i2 - i1);
    }

    public static void main(String[] args) {
        System.out.print("Enter array, add \'q\' symbol at and of array: ");
        List<Integer> list = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        try {
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            scanner.close();
        }
        System.out.println(getMinRange(list));
    }
}
