package lonelynumber;

public class LonelyNumber {

    public static void main(String[] args) {
        int[] numberList = {2, 3, 2, 4, 3, 7, 7, 7, 11, 2, 3, 4, 4};
        System.out.println(findLonelyNumber(numberList));
        }

    private static int findLonelyNumber(int[] array){
        int result = 0;
        int count = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(i != j){
                    if(array[j] == array[i]){
                        count++;
                    }
                }
                if(count == 1){
                    result = array[j];
                }
            }
        }
        return result;
    }
}
