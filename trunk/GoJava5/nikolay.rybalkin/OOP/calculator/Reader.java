package calculator;
import java.util.Scanner;

public class Reader {
    public static String read(String scanString){
        Scanner scan = new Scanner(System.in);
        scanString = scan.nextLine();
        return scanString;
    }
}
