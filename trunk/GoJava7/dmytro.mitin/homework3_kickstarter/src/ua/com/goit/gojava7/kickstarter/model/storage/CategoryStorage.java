package ua.com.goit.gojava7.kickstarter.model.storage;

import ua.com.goit.gojava7.kickstarter.model.*;

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

        Category category0 = new Category("Art");
        addCategory(category0);
        String description00 = "Be ready for any occasion, with funny, tick-your-own-sentiment greeting cards. " +
                "General AND holiday cards available!";
        addProject(new Project("Multi-Purpose, All-Occasion Greeting Cards",
                description00,
                description00,
                "Very interesting history...",
                "http://youtube...",
                23_363,
                1),category0);
        String description01 = "Designed for those who aren't afraid to stand out in a crowd, INKKAS are the perfect mix" +
                " of comfort, durability & eye-catching style.";
        addProject(new Project("RADICALLY UNIQUE FOOTWEAR: The Coolest Pair You'll Ever Wear",
                description01,
                description01,
                "Very interesting history...",
                "http://vimeo...",
                20_091,
                28), category0);
        String description02 = "An epic space sim where 100's of players wage war across a seamless, procedurally generated, " +
                "true to scale solar system!";
        addProject(new Project("Infinity: Battlescape",
                description02,
                description02,
                "Very interesting history...",
                "http://video.facebook...",
                220_677,
                13), category0);


        Category category1 = new Category("Comics");
        addCategory(category1);
        String description10 = "Help Lady Death’s creator, Brian Pulido, bring hard-boiled revenge story " +
                "La Muerta #1: Descent -- to life!";
        addProject(new Project("BRIAN PULIDO'S NEW GRAPHIC NOVEL: LA MUERTA #1: DESCENT!",
                description10,
                description10,
                "Very interesting history...",
                "http://youtube...",
                28_005,
                28), category1);
        String desciption11 = "Interactive motion comic of 12 episodes about a group of superhero-inspired " +
                "youngsters in an enslaved post-apocalyptic society.";
        addProject(new Project("Ascent from Akeron",
                desciption11,
                desciption11,
                "Very interesting history...",
                "http://youtube...",
                8_966,
                4),category1);
        addProject(new Project("name", "short description", "long description", "", "video...", 100_000, 10), category1);

        addCategory(new Category("Crafts"));
        addCategory(new Category("Dance"));
        addCategory(new Category("Design"));
        addCategory(new Category("Fashion"));
        addCategory(new Category("Film & Video"));
        addCategory(new Category("Food"));
        addCategory(new Category("Games"));
        addCategory(new Category("Journalism"));
        addCategory(new Category("Music"));
        addCategory(new Category("Photography"));
        addCategory(new Category("Publishing"));
        addCategory(new Category("Technology"));
        addCategory(new Category("Theater"));
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void addProject(Project project, Category category) {
        category.getProjects().add(project);
        project.setCategory(category);
    }
}
