/**
 * Created by roznalex on 13.03.2015.
 */
public class Distance {
    public static void main(String[] args) {
        Distance test = new Distance();
        int[] numbers = {1, 45, 3, 33, 45, 4, 2, 56, 2, 12, 100};
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
                secondMin = min;
                secondMinIndex = minIndex;
                min = numbers[i];
                minIndex = i;

            } else if (numbers[i] < secondMin) {
                secondMin = numbers[i];
                secondMinIndex = i;
            }
        }

        return Math.abs(minIndex - secondMinIndex);
    }
}
