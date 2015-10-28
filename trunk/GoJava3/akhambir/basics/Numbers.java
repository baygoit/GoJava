import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by root on 11.03.2015.
 */
public class Numbers {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int [] numbers = new int[10];
        int incomingInt = 0;

        for (int i = 0; i < numbers.length; i++){
            incomingInt = Integer.parseInt(reader.readLine());
            numbers[i] = incomingInt;
        }

        int min1 = numbers[0];
        int min2 = numbers[0];
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] < min1){
                min1 = numbers[i];
                index1 = i;
            }
            else if (numbers[i] <= min2 && numbers[i] > min1){
                min2 = numbers[i];
                index2 = i;
            }
            else if (min1 == min2){
                min2 = numbers[i + 1];
                index2 = i + 1;
            }
        }

        int distance = Math.abs(index1 - index2);

        System.out.println(distance);

    }
}
