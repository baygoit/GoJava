import java.io.*;
import java.util.*;

public class DivisionView {
    static final int RESULT_ACCURACY = 6;
    
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter division sequence:");
        String input = in.nextLine();
        int divisor, divident;
        String answer;
        String divisionRow = "";
        String space = "";
        
        String[] arrayString = input.split("/");
        
        divisor = Integer.parseInt(arrayString[0]);
        divident = Integer.parseInt(arrayString[1]);

        answer = Integer.toString(divisor/divident);
        answer += (".(");
        divisor *= 10;
        for ( int i = 0; i < RESULT_ACCURACY; i++ ) {
            answer += Integer.toString(divisor/divident);
            if ( divisor/divident == 0 ) {
            	i = RESULT_ACCURACY;
            }
            divisionRow += (
            	Integer.toString(divident*(divisor/divident)) + "\n" + space + 
            	"- - -\n" + space + Integer.toString((divisor%divident)*10) +"\n" + space
            );
            space += " ";
            divisor = (divisor%divident)*10;
            System.out.println(divisor);
        }
        answer += (")");
        String[] parts = divisionRow.split("\n", 1);
        System.out.println(arrayString[0] + " |" + arrayString[1] +
        "\n" + "   |" + answer + "\n" + divisionRow);
    }
}