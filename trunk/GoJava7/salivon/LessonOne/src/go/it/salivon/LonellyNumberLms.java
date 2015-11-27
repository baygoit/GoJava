package go.it.salivon;

import java.util.ArrayList;
import go.it.main.LonelyNumber;
import java.util.Arrays;
import java.util.List;

public class LonellyNumberLms extends LonelyNumber {

    private List<Integer> arrNum;

    public static void main(String[] args) {
        LonellyNumberLms ln = new LonellyNumberLms();
        System.out.println("Search number - " + ln.findLonely(Arrays.asList(5, 10, 10, 10, 2, 2, 6, 56, 56, 56, 5, 5, 2), 1));

    }

    public Integer findLonely(List<Integer> array, int repeatCount) {
        arrNum = array;
        return searchNum();
    }

    private int searchNum() {
        int num = 0;
        int searchNum = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        out:
        for (int i = 0; i < arrNum.size(); i++) {

            num = arrNum.get(i);

            if (!arr.isEmpty()) {
                for (Integer arr1 : arr) {
                    if (num == arr1) {
                        continue out;
                    }
                }
            }
            if (i == arrNum.size() - 1) {
                searchNum = arrNum.get(i);
            }
            for (int j = i + 1; j < arrNum.size(); j++) {

                if (num == arrNum.get(j)) {
                    arr.add(arrNum.get(j));
                    break;
                } else {
                    searchNum = num;
                }
                if (j == arrNum.size() - 1) {
                    break out;
                }
            }

        }
        return searchNum;
    }
}
