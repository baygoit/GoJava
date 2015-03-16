import java.util.ArrayList;
import java.util.Scanner;

public class FindDistance {
    public static void main(String[] args) {

        while (true) {
            String input = new Scanner(System.in).nextLine();
            String[] inputValue = input.split(" ");
            ArrayList<Integer> intArrayList = new ArrayList<Integer>();

            for (String n: inputValue) {
                intArrayList.add(new Integer(n));
            }

            Integer min1 = intArrayList.get(0);
            Integer min2 = intArrayList.get(1);
            if (min1 < min2) {
                min1 = intArrayList.get(1);
                min2 = intArrayList.get(0);
            }

            for (int i=2; i < intArrayList.size(); i++) {
                Integer el = intArrayList.get(i);
                if (min1 > el) {
                    min2 = min1;
                    min1 = el;
                } else if (min2 > el) {
                    min2 = el;
                }
            }

            Integer dis = Math.abs(intArrayList.indexOf(min1) - intArrayList.indexOf(min2));
            System.out.println(intArrayList.toString());
            System.out.println("min1: " + min1 + ", min2: " + min2 + ", distance: "+ dis);

        }
    }

}
