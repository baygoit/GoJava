package ua.dborisenko.kickstarter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IoHandler {

    public String read() {
        String input = "";
        try {
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
            input = inputStream.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return input;
    }

    public void writeMessage(String message) {
        System.out.print(message);
    }

    public void writeError(String error) {
        System.err.print(error);
    }
}
