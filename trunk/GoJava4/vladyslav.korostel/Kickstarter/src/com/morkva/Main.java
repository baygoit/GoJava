package com.morkva;

import com.morkva.logic.ConsolePrinter;

import java.io.IOException;

/**
 * Created by vladyslav on 07.05.15.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        KickstarterApp app = new KickstarterApp(new ConsolePrinter());
        app.showMenu();
    }
}
