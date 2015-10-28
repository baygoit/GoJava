import java.io.*;
import java.util.ArrayList;

public class LonelyInteger {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	System.out.println("Please enter the numbers.");
    	System.out.println("write 'exit' if you want to display a sum");
    	String input = reader.readLine();
    	
    	while(!input.equals("exit")){
    		list.add(Integer.parseInt(input));
    		input = reader.readLine();
    	}
    	
       int temp = 0;
       int result = 0;
       for (int i = 0; i < 32; i++) {
           int mask = 1 << i;
           for (int num : list) {
               int nextBit = num & mask;
               if (nextBit > 0) {
                    temp = temp | nextBit;
                }
            }
            if(temp % 3 > 0) {
                result = result | mask;
            }
            temp = 0;
        }

        System.out.println("Lonely Number is " + result);
    }
}