package goit.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console extends Stream{
    private final String EXIT_CODE = "y";
    private String line;

    private String getLine() {
        return line;
    }

    private void setLine(String line) {
        this.line = line;
    }

    private String read(String inviteMessage) {
        System.out.println(inviteMessage);
        String result = null;
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            result = bufferRead.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getNext() {
        setLine(read("Input string"));
        return getLine();
    }

    public boolean hasNext() {
        String message = "Repeat(".concat(EXIT_CODE).concat(" - yes, otherwise - exit)?");
        return read(message).compareToIgnoreCase(EXIT_CODE) == 0;
    }

    public void showResult(String message) {
        System.out.println(getLine().concat("=").concat(message));
    }

    public void showError(String message) {
        System.out.println(message);
    }

}
