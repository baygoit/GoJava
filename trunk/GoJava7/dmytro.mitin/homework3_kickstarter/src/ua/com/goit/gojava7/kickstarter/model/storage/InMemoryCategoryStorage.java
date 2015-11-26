package ua.com.goit.gojava7.kickstarter.model.storage;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryCategoryStorage implements CategoryStorage {
    private List<Category> categories;

    public InMemoryCategoryStorage() {
        categories = new ArrayList<>();

        Category category0 = new Category("Art");
        add(category0);

        String description00 = "Be ready for any occasion, with funny, tick-your-own-sentiment greeting cards. " +
                "General AND holiday cards available!";
        category0.add(new Project("Multi-Purpose, All-Occasion Greeting Cards",
                category0,
                description00,
                description00,
                "Very interesting history...",
                "http://youtube...",
                23_363,
                1));
        String description01 = "Designed for those who aren't afraid to stand out in a crowd, INKKAS are the perfect mix" +
                " of comfort, durability & eye-catching style.";
        category0.add(new Project("RADICALLY UNIQUE FOOTWEAR: The Coolest Pair You'll Ever Wear",
                category0,
                description01,
                description01,
                "Very interesting history...",
                "http://vimeo...",
                20_091,
                28));
        String description02 = "An epic space sim where 100's of players wage war across a seamless, procedurally generated, " +
                "true to scale solar system!";
        category0.add(new Project("Infinity: Battlescape",
                category0,
                description02,
                description02,
                "Very interesting history...",
                "http://video.facebook...",
                220_677,
                13));


        Category category1 = new Category("Comics");
        add(category1);

        String description10 = "Help Lady Death's creator, Brian Pulido, bring hard-boiled revenge story " +
                "La Muerta #1: Descent -- to life!";
        category1.add(new Project("BRIAN PULIDO'S NEW GRAPHIC NOVEL: LA MUERTA #1: DESCENT!",
                category1,
                description10,
                description10,
                "Very interesting history...",
                "http://youtube...",
                28_005,
                28));
        String desciption11 = "Interactive motion comic of 12 episodes about a group of superhero-inspired " +
                "youngsters in an enslaved post-apocalyptic society.";
        category1.add(new Project("Ascent from Akeron",
                category1,
                desciption11,
                desciption11,
                "Very interesting history...",
                "http://youtube...",
                8_966,
                4));
        category1.add(new Project("name", category1, "short description", "long description", "", "video...",
                100_000, 10));

        add(new Category("Crafts"));
        add(new Category("Dance"));
        add(new Category("Design"));
        add(new Category("Fashion"));
        add(new Category("Film & Video"));
        add(new Category("Food"));
        add(new Category("Games"));
        add(new Category("Journalism"));
        add(new Category("Music"));
        add(new Category("Photography"));
        add(new Category("Publishing"));
        add(new Category("Technology"));
        add(new Category("Theater"));
    }

    @Override
    public List<Category> getCategories() {
        return Collections.unmodifiableList(categories);
    }

    @Override
    public void add(Category category) {
        categories.add(category);
    }

}
