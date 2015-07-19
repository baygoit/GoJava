package tyomsky.kickstarter;

import java.util.List;
import java.util.Scanner;

public class Kickstarter {

    List<Category> categories;

    public Kickstarter(List<Category> categories) {
        this.categories = categories;
    }

    public void run() {
        System.out.println(new QuoteGenerator().getQuote());

        for (int i = 0; i < categories.size(); i++) {
            int menuIndex = i + 1;
            System.out.println(menuIndex +": "+categories.get(i).getName());
        }

        System.out.println("Make a choice: ");
        Scanner scanner = new Scanner(System.in);
        int chosenMenuIndex = scanner.nextInt();

        Category chosenCategory = categories.get(chosenMenuIndex-1);

        System.out.println("You have chosen: " + chosenCategory.getName());


    }

}
