package Anagrama;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 12.07.15
 * Time: 10:08
 * @version: 1.0
 */
public class Input {
    private Scanner locScanner;

    public Input(InputStream pInputStream) {
        locScanner = new Scanner(pInputStream);
    }

    public String inputString(){
        return locScanner.nextLine();
    }
}
