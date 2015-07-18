package goit.vh.kickstarter;


 import java.util.Random;

public class QuoteGenerator {

    public String getQuote() {
        String[] ArrayOfQuotes = { "By giving, you receive!", "Maby you helping to start something BIG!",
                "If you liked an idea, the best you can help - send some money!" };
        int index = new Random().nextInt(ArrayOfQuotes.length);

        return ArrayOfQuotes[index];

    }
}