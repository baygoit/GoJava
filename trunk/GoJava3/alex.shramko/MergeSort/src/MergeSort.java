import java.util.Scanner;

public class MergeSort {

    public static int[] mergeSort(int[] list) {
        if (list.length <= 1) {
            return list;
        }
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
        mergeSort(first);
        mergeSort(second);
        merge(first, second, list);
        return list;
    }

    private static void merge(int[] first, int[] second, int[] result) {
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }

    public static void main(String[] args) {
        System.out.println("Insert your string of numbers separated by space:");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        String[] arrIn = input.split(" ");
        int[] values = new int[arrIn.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(arrIn[i]);
        }
        int[] result = mergeSort(values);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

}
