package ua.dborisenko.kickstarter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

    protected String readInput() {
        String input = "";
        try {
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
            input = inputStream.readLine();
        } catch (IOException e) {
            return "";
        }
        return input;
    }

    protected void drawHeaderBlock() {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║           Kickstarter demo            ║");
        System.out.println("╚═══════════════════════════════════════╝");
    }

    protected void drawDivider() {
        System.out.println("─────────────────────────────────────────");
    }

    public String generate() {
        return "";
    }
}
