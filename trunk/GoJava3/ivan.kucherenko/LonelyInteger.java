 public class LonelyInteger {

    public static void main(String[] args) {
        int[]numbers = {5,8,3,9,9,5,8};
        
        int lonelyInteger = numbers[0];
        
        for(int i = 1; i < numbers.length; i++)
           lonelyInteger^=numbers[i];
        
        System.out.println(lonelyInteger);
    }
}