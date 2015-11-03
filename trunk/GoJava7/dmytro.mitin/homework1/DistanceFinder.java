/**
 * Created by Dmytro on 22.10.2015.
 */
public class DistanceFinder {
    public static void main(String[] args) {
        DistanceFinder finder = new DistanceFinder();
        System.out.println(finder.findDistanceBetween2Mins(new int[]{10, 30, 20, 5, 40}));
    }

    public int findDistanceBetween2Mins(int[] numbers){
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("Array must contain at least 2 numbers!");
        }

        int min;
        int nextMin;
        int indexOfMin;
        int indexOfNextMin;

        if (numbers[0] <= numbers[1]) {
            min = numbers[0];
            nextMin = numbers[1];
            indexOfMin = 0;
            indexOfNextMin = 1;
        } else {
            min = numbers[1];
            nextMin = numbers[0];
            indexOfMin = 1;
            indexOfNextMin = 0;
        }

        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] < min) {
                nextMin = min;
                min = numbers[i];
                indexOfNextMin = indexOfMin;
                indexOfMin = i;
            } else if (numbers[i] < nextMin) {
                nextMin = numbers[i];
                indexOfNextMin = i;
            }
        }

        return Math.abs(indexOfMin - indexOfNextMin);
    }
}
