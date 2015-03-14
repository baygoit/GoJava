/**
 * Created by roznalex on 13.03.2015.
 */
public class Distance {
    public static void main(String[] args) {
        Distance test = new Distance();
        int[] numbers = {2, 45, 4, 33, 45, 4, 3, 56, 2, 44, 100};
        int distance = test.calcDistance(numbers);
        System.out.println(distance);
    }

    int calcDistance(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int minIndex = -1;
        int secondMinIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] < secondMin && numbers[i] != min) {
                secondMin = numbers[i];
                secondMinIndex = i;
            }
        }
        return Math.abs(minIndex - secondMinIndex);
    }
}
