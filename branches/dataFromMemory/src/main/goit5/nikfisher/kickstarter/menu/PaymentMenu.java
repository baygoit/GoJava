package goit5.nikfisher.kickstarter.menu;


import goit5.nikfisher.kickstarter.model.Project;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;

class PaymentMenu {

    final private ConsoleInterfaceIO IO;

    public PaymentMenu(ConsoleInterfaceIO io) {
        this.IO = io;
    }

    public void bonusMenu(Project project) {

        selectPaymentOption();
        needAmount(project);
        String name = enterMenu();
        enterNumberCard();
        int amount = enterMoney();
        outThanks(name);
        project.donate(amount);

    }

    private void outThanks(String name) {
        IO.println("Thank you " + name + " your money is successfully transferred to the account of the project");
        IO.println("---------------------------------------");
    }

    private int enterMoney() {
        IO.println("Enter the amount of money");
        return IO.consoleScanInt();
    }

    private void enterNumberCard() {
        IO.println("Enter the number of your card");
        IO.consoleScanInt();
    }

    private String enterMenu() {
        IO.println("Enter your name");
        return IO.consoleScanString();
    }

    private void needAmount(Project project) {
        int value = IO.consoleScanInt();
        int required_amount = project.getAmount();
        int needAmount;

        switch (value) {
            case 1: {
                needAmount = (required_amount / 100) * 10;
                break;
            }
            case 2: {
                needAmount = (required_amount / 100) * 50;
                break;
            }
            case 3: {
                needAmount = required_amount;
                break;
            }
            default:
                needAmount = required_amount;
        }

        IO.println("You need to make: " + needAmount);
        IO.println("-----------------");
    }

    private void selectPaymentOption() {
        IO.println("Please select payment option:");
        IO.println("1) If you invest 10% of the required amount, you will receive a 5%.");
        IO.println("2) If you invest 50% of the required amount, you will receive a 15%.");
        IO.println("3) If you invest 100% of the required amount, you will receive a 30%.");
    }
}

