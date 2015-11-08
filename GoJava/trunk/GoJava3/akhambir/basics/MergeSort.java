package ua.goit.basics;

public class MergeSort
{
    public static void main(String[] args) {
        int[] array = new int[] {5, 6, 7, 8, 9, 1, 2, 3, 4, 5};
        int[] array2 = sort(array, 0, array.length);
        for (int i =0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
    }

    public static int[] sort(int[] array, int startIndex, int length) {

        if (length == 0) {
            return new int[0];
        } else if (length == 1) {
            return new int[] {array[startIndex]};
        } else if (length == 2) {
            if (array[startIndex] > array[startIndex + 1]) {
                return new int[] {array[startIndex + 1], array[startIndex]};
            } else {
                return new int[] {array[startIndex], array[startIndex + 1]};
            }
        }

        else {
            int[] leftPart = sort(array, startIndex, (length / 2));
            int[] rightPart = sort(array, startIndex + (length / 2), length - (length / 2));

            return merge(leftPart, rightPart);
        }
    }

    private static int[] merge(int[] leftPart, int[] rightPart) {

        int[] result = new int[leftPart.length + rightPart.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < leftPart.length && rightIndex < rightPart.length) {
            if (leftPart[leftIndex] < rightPart[rightIndex]) {
                result[resultIndex] = leftPart[leftIndex++];
                resultIndex++;
            } else {
                result[resultIndex] = rightPart[rightIndex++];
                resultIndex++;
            }
        }

        while (leftIndex < leftPart.length) {
            result[resultIndex] = leftPart[leftIndex++];
            resultIndex++;
        }

        while (rightIndex < rightPart.length) {
            result[resultIndex] = rightPart[rightIndex++];
            resultIndex++;
        }

        return result;
    }
}
