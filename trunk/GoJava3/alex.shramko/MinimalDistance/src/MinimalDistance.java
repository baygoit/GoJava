import java.util.Scanner;

public class MinimalDistance {

    public static int calculateDistance(String input) {
        String[] arrIn = input.split(" ");
        if (arrIn.length < 2) {
            throw new RuntimeException(
                    "Inrut array should contain at least 2 elements");
        } else if (arrIn.length == 2)
            return 0;
        int min1 = Integer.parseInt(arrIn[0]);
        int index1 = 0;
        int min2 = Integer.parseInt(arrIn[1]);
        int index2 = 1;
        int distance = 1;
        for (int i = 2; i < arrIn.length; i++) {
            int currentInt = Integer.parseInt(arrIn[i]);
            if (currentInt < Math.max(min1, min2)) {
                if (min2 > min1) {
                    min2 = currentInt;
                    index2 = i;
                } else {
                    min1 = currentInt;
                    index1 = i;
                }
                distance = Math.abs(index2 - index1);
            } else if (currentInt == Math.max(min1, min2)) {
                if (min2 > min1) {
                    index2 = i;
                } else if (min1 > min2) {
                    index1 = i;
                } else {
                    index1 = Math.max(index1, index2);
                    min2 = currentInt;
                    index2 = i;
                    
                }
                distance = Math.min(distance, index2 - index1);
            }
        }
        return distance;
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
