import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MinimalDistance {

    public static int calculateDistance(String input) throws Exception {
        String[] arrIn = input.split(" ");
        if (arrIn.length < 2) {
            throw new Exception(
                    "Inrut array should contain at least 2 elements");
        }
        int min1 = Integer.parseInt(arrIn[0]);
        int min2 = Integer.parseInt(arrIn[1]);
        for (int i = 2; i < arrIn.length; i++) {
            int currentInt = Integer.parseInt(arrIn[i]);
            if (currentInt < Math.max(min1, min2)) {
                if (min1 > min2)
                    min1 = currentInt;
                else
                    min2 = currentInt;
            }
        }

        Set<Integer> pos1 = new HashSet<Integer>();
        Set<Integer> pos2 = new HashSet<Integer>();

        for (int i = 0; i < arrIn.length; i++) {
            int currentInt = Integer.parseInt(arrIn[i]);
            if (currentInt == min1)
                pos1.add(i);
            if (currentInt == min2)
                pos2.add(i);
        }

        int minDistance = Integer.MAX_VALUE;
        for (Integer intPos1 : pos1) {
            for (Integer intPos2 : pos2) {
                if (intPos1 != intPos2) {
                    minDistance = Math.min(minDistance,
                            Math.abs(intPos1 - intPos2));
                }
            }
        }
        int returnValue = Math.abs(minDistance);
        return returnValue;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Insert your string of numbers separated by space:");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        int distance = calculateDistance(input);
        System.out.println(distance);

    }

}
