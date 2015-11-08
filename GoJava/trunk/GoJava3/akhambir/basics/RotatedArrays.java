package ua.goit.alg;

public class RotatedArrays {

    public static int binarySearch(int[] array, int target) {
        int middlePoint = array.length / 2;
        int leftPoint = 0;
        int rightPoint = array.length - 1;

        while (target != array[middlePoint]) {
            if (middlePoint == leftPoint || middlePoint == rightPoint) {
                return -1;
            }
            if (target > array[middlePoint]) {
                if (target <= array[rightPoint]) {
                    leftPoint = middlePoint;
                    middlePoint = goRight(leftPoint, rightPoint, middlePoint);
                } else if (array[rightPoint] < array[middlePoint]) {
                    leftPoint = middlePoint;
                    middlePoint = goRight(leftPoint, rightPoint, middlePoint);
                } else {
                    rightPoint = middlePoint;
                    middlePoint = goLeft(leftPoint, rightPoint);
                }
            } else {
                if (target >= array[leftPoint]) {
                    rightPoint = middlePoint;
                    middlePoint = goLeft(leftPoint, rightPoint);
                } else if (array[leftPoint] > array[middlePoint]) {
                    rightPoint = middlePoint;
                    middlePoint = goLeft(leftPoint, rightPoint);
                } else {
                    leftPoint = middlePoint;
                    middlePoint = goRight(leftPoint, rightPoint, middlePoint);
                }
            }
        }

        return middlePoint;
    }

    public static int goRight(int leftPoint, int rightPoint, int middlePoint) {
        return (rightPoint - leftPoint + 1) / 2 + middlePoint;
    }

    public static int goLeft(int leftPoint, int rightPoint) {
        return (leftPoint + rightPoint) / 2;
    }

}
