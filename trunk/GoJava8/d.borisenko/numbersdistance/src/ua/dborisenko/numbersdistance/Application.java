package ua.dborisenko.numbersdistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Application {

    private static int INPUT_ARRAY_LENGTH = 21;
    private static int INPUT_ARRAY_MAX_VALUE = 50;

    private void fillArrayRandomValues(int[] inputArray) {
        Random random = new Random();
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = random.nextInt(INPUT_ARRAY_MAX_VALUE + 1);
        }
    }

    private int getMinValueIndex(int[] inputArray) {
        int minValueIndex = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < inputArray[minValueIndex]) {
                minValueIndex = i;
            }
        }
        return (minValueIndex);
    }

    private int getPrevMinValueIndex(int[] inputArray, int minValueIndex) {
        int prevMinValueIndex = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] <= inputArray[prevMinValueIndex] && i != minValueIndex
                    && !(inputArray[i] == inputArray[prevMinValueIndex]
                            && Math.abs(minValueIndex - prevMinValueIndex) < Math.abs(minValueIndex - i))) {
                prevMinValueIndex = i;
            }
        }
        return (prevMinValueIndex);
    }

    private List<Integer> getAllSameValueIndexes(int[] inputArray, int minValueIndex) {
        List<Integer> minIndexes = new ArrayList<Integer>();
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == inputArray[minValueIndex]) {
                minIndexes.add(i);
            }
        }
        return (minIndexes);
    }

    private List<Integer> getMinIndexes(int[] inputArray) {
        if (inputArray.length < 2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int minValueIndex = getMinValueIndex(inputArray);
        int prevMinValueIndex = getPrevMinValueIndex(inputArray, minValueIndex);
        List<Integer> minIndexes = new ArrayList<Integer>();
        if (inputArray[minValueIndex] == inputArray[prevMinValueIndex]) {
            minIndexes = getAllSameValueIndexes(inputArray, minValueIndex);
        } else {
            minIndexes.add(minValueIndex);
            minIndexes.add(prevMinValueIndex);
        }
        return (minIndexes);
    }

    private List<Integer> getMinValues(int[] inputArray, List<Integer> indexList) {
        List<Integer> minValues = new ArrayList<Integer>();
        for (int index : indexList) {
            minValues.add(inputArray[index]);
        }
        return minValues;
    }

    private List<Integer> getDistances(List<Integer> indexList) {
        List<Integer> distances = new ArrayList<Integer>();
        for (int i = 0; i < indexList.size(); i++) {
            for (int j = i + 1; j < indexList.size(); j++) {
                distances.add(Math.abs(indexList.get(i) - indexList.get(j)));
            }
        }
        return (distances);
    }

    public void start() {
        int[] inputArray;
        inputArray = new int[INPUT_ARRAY_LENGTH];
        this.fillArrayRandomValues(inputArray);
        System.out.println("Given array:");
        System.out.println(Arrays.toString(inputArray));
        System.out.println("Minimal values:");
        System.out.println(this.getMinValues(inputArray, this.getMinIndexes(inputArray)).toString());
        System.out.println("Distances:");
        System.out.println(this.getDistances(this.getMinIndexes(inputArray)).toString());
    }
}
