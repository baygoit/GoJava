package goit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

    public static final String EXIT_CODE = "y";

    public static String read(String inviteMessage) {
        System.out.println(inviteMessage);
        String result = null;
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            result = bufferRead.readLine();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
