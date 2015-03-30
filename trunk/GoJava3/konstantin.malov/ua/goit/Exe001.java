
public class Exe001 {
  public static final int[] NUMBER_ARR = {21, 1, 2, 7, 3, 5, 6, 7, 8, 8};

  public static void main(String[] args) {
    System.out.println(distanceBetweenLowest(NUMBER_ARR));
  }

  public static int distanceBetweenLowest(int numberArr[]) {
    int min1 = numberArr[0];
    int min2 = numberArr[0];
    int minIndex1 = 0;
    int minIndex2 = 0;
    for (int i = 0; i < numberArr.length; i++) {
      if (min1 >= numberArr[i]) {
        min1 = numberArr[i];
        minIndex2 = minIndex1;
        min2 = min1;
        minIndex1 = i;
      } else if (min2 > numberArr[i]) {
        min2 = numberArr[i];
        minIndex2 = i;
      }
    }

    return Math.abs(minIndex2 - minIndex1);
  }
}
