import java.util.Arrays;



public class MergeSort {
       
        private static int [] sort(int[] array){
               
                if (array.length <= 1)
                        return array;
               
                        int [] half1 = new int[array.length/2];
                        int [] half2 = new int[array.length - half1.length];
               
                        System.arraycopy(array, 0, half1, 0, half1.length);
                        System.arraycopy(array, half1.length, half2, 0, half2.length);
                       
                        sort(half1);
                        sort(half2);
                       
                        int countLeft = 0;
                     
                int countRight = 0;
               
                int i = 0;
               
                while (countLeft < half1.length && countRight < half2.length) {
                    if (half1[countLeft] < half2[countRight]) {
                        array[i] = half1[countLeft];
                        countLeft++;
                        } else {
                        array[i] = half2[countRight];
                        countRight++;
                    }
                    i++;
                }
               
                System.arraycopy(half1, countLeft, array, i, half1.length - countLeft);
                System.arraycopy(half2, countRight, array, i, half2.length - countRight);
               
                return array;
        }
       
        public static void main(String[] args) {
                int [] array1 = {7,5,8,9,21,5,7,6,15,3};
       
                System.out.println(Arrays.toString(sort(array1)));

        }

}
