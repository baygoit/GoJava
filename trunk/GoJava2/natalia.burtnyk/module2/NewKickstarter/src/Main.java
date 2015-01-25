import java.util.List;

public class Main {

    public static void main(String[] args) {
        Quote quote = new Quote();
        System.out.println(" Welcome to Kickstarter" + "\n"
                + "  *** *** *** *** *** " + "\n" + quote.printQuote() + "\n"
                + "  *** *** *** *** *** ");

        List<Сategory> a = new CategoryStorage().getCategoriesList();
        int i = 1;
        for (Сategory c : a) {
            System.out.println(i + ". " + c.getName());
            i++;
		}
	}
}