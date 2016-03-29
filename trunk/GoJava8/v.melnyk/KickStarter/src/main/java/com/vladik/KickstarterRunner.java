package com.vladik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.vladik.controller.KickstarterFile;
import com.vladik.controller.AbstractKickstarter;
import com.vladik.controller.KickstarterDatabase;
import com.vladik.controller.KickstarterMemory;

public class KickstarterRunner {

    public static void main(String[] args) {
        new KickstarterRunner().selectProgramMode();
    }

    private void selectProgramMode() {
        int userChoiseMode = 0;

        String startMenu = "Please select program mode (by default memory) : \n"
                + "1 : memory \n"
                + "2 : files \n"
                + "3 : database";
        System.out.println(startMenu);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                userChoiseMode = Integer.parseInt(in.readLine());
            } catch (NumberFormatException e1) {
                System.out.println("You entered forbidden symbol. Please try again : ");
            } catch (IOException e2) {
                System.out.println("Problems with the stream...");
            }

        } while (userChoiseMode == 0);

        switch (userChoiseMode) {
            case 1: {
                System.out.println("Program using memory storage");
                AbstractKickstarter kickstarter = new KickstarterMemory();
                kickstarter.start();
                kickstarter.stop();
                break;
            }
            case 2: {
                System.out.println("Program using files storage");
                AbstractKickstarter kickstarter = new KickstarterFile();
                kickstarter.start();
                kickstarter.stop();
                break;
            }
            case 3: {
                System.out.println("Program using database storage");
                AbstractKickstarter kickstarter = new KickstarterDatabase();
                kickstarter.start();
                kickstarter.stop();
                break;
            }
            default:
                System.out.println("Program using memory storage");
                AbstractKickstarter kickstarter = new KickstarterMemory();
                kickstarter.start();
                kickstarter.stop();
                break;
        }
    }
}
