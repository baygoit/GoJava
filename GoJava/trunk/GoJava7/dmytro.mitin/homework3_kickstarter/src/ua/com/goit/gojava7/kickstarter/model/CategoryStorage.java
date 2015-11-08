package ua.com.goit.gojava7.kickstarter.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dmytro on 06.11.2015.
 */
public class CategoryStorage {
    private List<Category> categories;

    public List<Category> getCategories() {
        return Collections.unmodifiableList(categories);
    }

    public CategoryStorage() {
        categories = new ArrayList<>();

        List<Project> projects1 = new ArrayList<>();
        projects1.add(new Project("Multi-Purpose, All-Occasion Greeting Cards",
                "Be ready for any occasion, with funny, tick-your-own-sentiment greeting cards. " +
                        "General AND holiday cards available!",
                23_363,
                1));
        projects1.add(new Project("RADICALLY UNIQUE FOOTWEAR: The Coolest Pair You'll Ever Wear",
                "Designed for those who aren't afraid to stand out in a crowd, INKKAS are the perfect mix" +
                        " of comfort, durability & eye-catching style.",
                20_091,
                28));
        projects1.add(new Project("Infinity: Battlescape",
                "An epic space sim where 100's of players wage war across a seamless, procedurally generated, " +
                        "true to scale solar system!",
                220_677,
                13));
        categories.add(new Category("Art", projects1));

        List<Project> projects2 = new ArrayList<>();
        projects2.add(new Project("BRIAN PULIDO’S NEW GRAPHIC NOVEL: LA MUERTA #1: DESCENT!",
                "Help Lady Death’s creator, Brian Pulido, bring hard-boiled revenge story " +
                        "La Muerta #1: Descent -- to life!",
                28_005,
                28));
        projects2.add(new Project("Ascent from Akeron",
                "Interactive motion comic of 12 episodes about a group of superhero-inspired " +
                        "youngsters in an enslaved post-apocalyptic society.",
                8_966,
                4));
        categories.add(new Category("Comics", projects2));

        List<Project> projects3 = new ArrayList<>();
        projects3.add(new Project("name", "descr", 100_000, 10));
        categories.add(new Category("Crafts", projects3));

        categories.add(new Category("Dance", null));
        categories.add(new Category("Design", null));
        categories.add(new Category("Fashion", null));
        categories.add(new Category("Film & Video", null));
        categories.add(new Category("Food", null));
        categories.add(new Category("Games", null));
        categories.add(new Category("Journalism", null));
        categories.add(new Category("Music", null));
        categories.add(new Category("Photography", null));
        categories.add(new Category("Publishing", null));
        categories.add(new Category("Technology", null));
        categories.add(new Category("Theater", null));
    }
}
