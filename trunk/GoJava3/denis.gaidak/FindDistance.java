import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindDistance {
    public static void main(String[] args) {

        while (true) {

            String[] inputValue = new Scanner(System.in).nextLine().split(" ");
            ArrayList<Integer> intArrayList = new ArrayList<Integer>();

            for (String n: inputValue) {
                intArrayList.add(new Integer(n));
            }

            Map<String, Integer> results = findDistance(intArrayList);

            System.out.println(results.toString());
            
        }
    }


    public static Map<String, Integer> findDistance(ArrayList<Integer> intArrayList){
        Map<String, Integer> results = new HashMap<String, Integer>();

        int indexMin1 = 0, indexMin2 = 1;
        Integer min1 = intArrayList.get(0);
        Integer min2 = intArrayList.get(1);
        if (min1 > min2) {
            min1 = intArrayList.get(1);
            indexMin1 = 1;
            min2 = intArrayList.get(0);
            indexMin2 = 0;
        }

        int distance = intArrayList.size();
        for (int i=2; i < intArrayList.size(); i++) {
            Integer el = intArrayList.get(i);
            if (min1 > el) {
                min2 = min1;
                min1 = el;
                indexMin2 = indexMin1;
                indexMin1 = i;
                distance = Math.abs(indexMin1 - indexMin2);
            } else if (min2 > el) {
                min2 = el;
                indexMin2 = i;
                distance = Math.abs(indexMin1 - indexMin2);
            }

            if (min1==el || min2==el) {
                distance = Math.min(distance, Math.abs(indexMin1 - indexMin2));
            }

        }
        results.put("dis", distance - 1);
        results.put("min1", min1);
        results.put("min2", min2);

        return results;
    }

}
