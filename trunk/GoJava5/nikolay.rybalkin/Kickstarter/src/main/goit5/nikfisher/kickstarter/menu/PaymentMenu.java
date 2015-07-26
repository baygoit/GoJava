package goit5.nikfisher.kickstarter.menu;


import goit5.nikfisher.kickstarter.model.Project;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;

public class PaymentMenu {

    private static ConsoleInterfaceIO io;

    public PaymentMenu(ConsoleInterfaceIO io) {
        PaymentMenu.io = io;
    }

    public void bonusMenu(Project project){

        io.println("Please select payment option:");
        io.println("1) If you invest 10% of the required amount, you will receive a 5%.");
        io.println("2) If you invest 50% of the required amount, you will receive a 15%.");
        io.println("3) If you invest 100% of the required amount, you will receive a 30%.");

        int value = io.consoleScanInt();
        int required_amount = project.getAmount();
        int needAmount;

        switch (value){
            case 1: {
                needAmount =  (required_amount / 100) * 10;
                break;
            }
            case 2: {
                needAmount =  (required_amount / 100) * 50;
                break;
            }
            case 3: {
                needAmount =  required_amount;
                break;
            }
            default:
                needAmount = required_amount;
        }

        io.println("You need to make: " + needAmount);
        io.println("-----------------");
        io.println("Enter your name");
        String name = io.consoleScanString();
        io.println("Enter the number of your card");
        int cardNumber = io.consoleScanInt();

        io.println("Enter the amount of money");
        int amount = io.consoleScanInt();

        io.println("Thank you " + name + " your money is successfully transferred to the account of the project");
        io.println("---------------------------------------");

        project.donate((amount));

    }
}

