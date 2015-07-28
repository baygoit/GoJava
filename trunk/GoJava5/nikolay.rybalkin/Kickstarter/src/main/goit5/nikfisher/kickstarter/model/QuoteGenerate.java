package goit5.nikfisher.kickstarter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class QuoteGenerate {

    private Random random;

    public QuoteGenerate(Random random) {
        this.random = random;
    }

    public String quoteGenerate() {

        List<String> motivators = new ArrayList<>();

        motivators.add("Get involved in the development of interesting projects!");
        motivators.add("Get involved in the development of interesting projects!_1");
        motivators.add("Get involved in the development of interesting projects!_2");

        int index = random.nextInt(motivators.size());

        return motivators.get(index);
    }

}