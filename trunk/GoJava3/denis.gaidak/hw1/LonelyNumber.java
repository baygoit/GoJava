import java.util.HashMap;

public class LonelyNumber {

    public static void main(String[] args) {

        int[] arr = {2, 3, 2, 4, 3, 8, 2, 3, 4, 4};

        Integer lonNumber = lonelyNumber(arr);
        if (lonNumber == null) {
            System.out.println("no lonely number in array");
        } else {
            System.out.println(lonNumber);
        }

    }

    public static Integer lonelyNumber(int[] arr) {
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for (int i : arr) {
            if (temp.containsKey(i)) {
                int k = temp.get(i) + 1;
                temp.put(i, k);
            } else {
                temp.put(i, 1);
            }
        }

        for (int i : temp.keySet()) {
            if (temp.get(i).equals(1)) return i;
        }
        return null;
    }

}


