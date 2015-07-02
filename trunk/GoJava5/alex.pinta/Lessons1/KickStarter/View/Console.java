package Lessons1.KickStarter.View;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 4:45
 * @version: 1.0
 */
public class Console {
    private Scanner locScanner;
    public Console(InputStream pInputStream) {
        locScanner = new Scanner(pInputStream);
    }

    public String read(){
        String inputType = "";
        while (inputType.equals("")) {
            inputType = locScanner.nextLine();
        }
        return inputType;
    }

    public void write(String prompt){

    }

    public void writeTable(){

    }
}
