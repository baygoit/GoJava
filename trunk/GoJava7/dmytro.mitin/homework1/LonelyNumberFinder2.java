/**
 * Created by Dmytro on 03.12.2015.
 */
public class LonelyNumberFinder2 {
    public static void main(String[] args) {
        LonelyNumberFinder2 finder = new LonelyNumberFinder2();
        int[] numbers = {1, 2, 3, 1, 2, 3, 1, 4, 4};
        System.out.println(finder.findLonelyNumber(numbers));
    }

    private int findLonelyNumber(int[] numbers) {
        int res = 0;
        for (int num : numbers) {
            res ^= num;
        }
        return res;
    }
}
