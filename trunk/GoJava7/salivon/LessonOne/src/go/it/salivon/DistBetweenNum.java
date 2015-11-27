package go.it.salivon;

import go.it.main.MinDistanse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistBetweenNum extends MinDistanse {

    private List<Integer> arr;
    private Integer min1;
    private Integer min2;
    private ArrayList<Integer> numMin1 = new ArrayList();
    private ArrayList<Integer> numMin2 = new ArrayList();

    public static void main(String[] args) {
        DistBetweenNum dbn = new DistBetweenNum();
        System.out.println(dbn.calculateDistances(Arrays.asList(0, 1, 1, 1, 2, 3, 12)));
    }

    public List<Integer> getArr() {
        return arr;
    }

    private void readArray(List<Integer> arr) {
        System.out.print("Have array {");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
            if (i != arr.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    private void calculateMinNum() {
        if (!arr.isEmpty()) {
            calculateMin1Num();
            calculateMin2Num();
        }

        outResultDist();
    }

    private void calculateMin1Num() {
        min1 = arr.get(0);
        numMin1.add(0);
        for (int i = 1; i < arr.size(); i++) {
            if (min1 == arr.get(i)) {
                numMin1.add(i);
            }
            if (min1 > arr.get(i)) {
                min1 = arr.get(i);
                numMin1.clear();
                numMin1.add(i);
            }
        }
    }

    private void calculateMin2Num() {
        arr.stream().filter((arr1) -> (arr1 > min1 && (min2 == null || arr1 < min2))).forEach((arr1) -> {
            min2 = arr1;
        });
        if (min2 != null) {
            for (int i = 0; i < arr.size(); i++) {
                if (min2 == arr.get(i)) {
                    numMin2.add(i);
                }
            }
        }
    }

    private Map<String, Integer> outResultDist() {
        Map<String, Integer> outText = new HashMap<>();
        if ((arr.size() == 1 || min2 == null) || arr.isEmpty()) {
            outText.put("Distance does not exist!", 0);
            return outText;
        }

        numMin1.stream().forEach((numMin11) -> {
            numMin2.stream().forEach((numMin21) -> {
                int distance = Math.abs(numMin11 - numMin21);
                String str = "\n" + "Distance between min1(" + min1 + "|" + numMin11 + ") and min2(" + min2 + "|" + numMin21 + ")";
                outText.put(str, distance);
            });
        });
        return outText;
    }

    @Override
    public Map<String, Integer> calculateDistances(List<Integer> array) {
        arr = array;
        readArray(array);
        calculateMinNum();
        return outResultDist();
    }
}
