package goit5.nikfisher.kickstarter.menu;


import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;

public class BonusMenu {

    private static ConsoleInterfaceIO io;

    public BonusMenu(ConsoleInterfaceIO io) {
        BonusMenu.io = io;
    }

    public void bonusMenu(){

        while (true) {

            io.println("Please select payment option:");
            io.println("1) If you invest up to 10% of the required amount, you will receive a 1% to 5%.");
            io.println("2) If you invest up to 50% of the required amount, you will receive a 5% to 15%.");
            io.println("3) If you invest up to 100% of the required amount, you will receive a 15% to 30%.");

            int value = io.consoleScanInt();

            if (value == 1) {
                io.println("You will receive a 1% to 5%.");
                break;
            }

            if (value == 2) {
                io.println("You will receive a 5% to 15%.");
                break;
            }

            if (value == 3) {
                io.println("You will receive a 15% to 30%.");
                break;
            }

            if (value > 3 || value < 1) {
                io.println("You entered incorrect data.");
                io.println("Please enter the correct data: ");
                continue;
            }
        }
    }
}

