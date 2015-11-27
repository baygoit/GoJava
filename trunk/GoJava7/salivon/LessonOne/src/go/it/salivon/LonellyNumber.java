
package go.it.salivon;

import go.it.main.LonelyNumber;
import java.util.Arrays;
import java.util.List;

public class LonellyNumber extends LonelyNumber {

    private List<Integer> arrNum;
    private int numRepeat;

    public static void main(String[] args) {
        LonellyNumber ln = new LonellyNumber();
        System.out.println("Search number - " + ln.findLonely(Arrays.asList(1, 51, 1, 2, 6, 51, 6, 10, 8, 5, 51, 5, 14, 7, 17, 56, 2), 3));
    }

    @Override
    public Integer findLonely(List<Integer> array, int repeatCount) {
        arrNum = array;
        numRepeat = repeatCount;
        return searchNum();
    }

    private int searchNum() {
        int num = 0;
        int numRepeat = 0;
        begin:
        for (int i = 0; i <= arrNum.size() - 1; i++) {
            num = arrNum.get(i);
            numRepeat = 1;
            for (int j = i + 1; j <= arrNum.size() - 1; j++) {

                if (num == arrNum.get(j)) {
                    numRepeat++;
                    if (numRepeat == this.numRepeat) {
                        break begin;
                    }
                }
            }

        }
        return num;
    }

}
