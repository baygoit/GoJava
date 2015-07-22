package goit.vh.kickstarter;

import goit.vh.kickstarter.mvc.controller.CategoryController;
import goit.vh.kickstarter.mvc.controller.MainPageController;
import goit.vh.kickstarter.mvc.controller.ProjectController;
import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.MainPageModel;
import goit.vh.kickstarter.mvc.model.ProjectModel;
import goit.vh.kickstarter.mvc.view.CategoryView;
import goit.vh.kickstarter.mvc.view.MainPageView;
import goit.vh.kickstarter.mvc.view.ProjectView;
import goit.vh.kickstarter.model.Category;
import goit.vh.kickstarter.model.Project;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class KickStarter {

    private final Output output = new Output();
    private MainPageController mainPageController;//TODO remove fields
    private CategoryController categoryController;
    private MainPageView mainPageView;
    private ProjectController projectController;
    private LocationManager locationManager;

    public static void main(String[] args) {
        KickStarter kickStarter = new KickStarter();
        kickStarter.init();
        kickStarter.start();
    }

    private void init() {

        DataRegistry dataRegistry = new DataRegistry();
        dataRegistry.registerCategories(new Category[]{new Category("Sport"), new Category("TableGame"), new Category("Ecology startap")});
        Map<Integer, Project[]> hm = new HashMap<>();

        Calendar calendar =  Calendar.getInstance();
        calendar.set(2018, 05, 9);
        hm.put(1, new Project[]{new Project("Gluconazol -","Brend new anabolics;",25000000,7500000,calendar.getTime() ,
                                            "New MOC politics dictetes new requirements for pharmasy;",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0"),
                                new Project("Eczoskeleton -","This thing upgrades muscle power;",4000000,2500000,calendar.getTime() ,
                                            "Limites of human body was reached, but sport of big achievements  isn`t stopped;",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0"),
                                new Project("Slow Ball -","New game with a big, heavy ball",740000,300000,calendar.getTime() ,
                                            "Football, basketball is no longer attractive. People want to see something new;",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0")});

        hm.put(2, new Project[]{new Project("Warriors of eternity -", "New game, clone of 'Game of thrones';", 10000, 1500, calendar.getTime(),
                                            "Game of thrones was a very good game, but it starts to bore people, so new game is on!!;",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0"),
                                new Project("Robo rally 2 -", "Reincarnation of good old strategy;", 7500, 3000, calendar.getTime(),
                                            "You will be able to construct factories in new version. The game map become twise bigger;",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0"),
                                new Project("Slow Ball table game -", "New table game;", 12000, 10000, calendar.getTime(),
                                            "Astoneshing gameplay, provided by Julius Beismann. We promise, You will sink in variety of game strategy; ",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0"),
                                new Project("Leprecons -", "The game based on old movie;", 3000, 2750, calendar.getTime(),
                                            "Classical 2*2 game, which will be easy to play with friends;",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0")});

        hm.put(3, new Project[]{new Project("Garbage collector -", "Tool for utilization of home garbage;", 500000, 50000, calendar.getTime(),
                                            "In partnership with norvegian ecological ministry we developing a revolutionary device for utilization;",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0"),
                                new Project("Pioneers -", "New forest ecosystem ceepeng organization;", 11000000, 3000000, calendar.getTime(),
                                            "In times when forrest pollution grows, sosiety needs not only better culture, but people who will " +
                                             "stend on guard of our forests; ",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0")});

        dataRegistry.registerProjects(hm);


        MainPageModel mainPageModel = new MainPageModel();
        mainPageModel.setDataRegistry(dataRegistry);


        CategoryModel categoryModel = new CategoryModel(dataRegistry);

        ProjectModel projectModel = new ProjectModel(dataRegistry);
        mainPageView = new MainPageView(output);



        mainPageController = new MainPageController(mainPageView, mainPageModel);
        categoryController = new CategoryController(new CategoryView(output), new ProjectView(output), categoryModel, projectModel);
        projectController = new ProjectController(new ProjectView(output), projectModel);
        locationManager = new LocationManager(mainPageController, categoryController, projectController);
        mainPageController.setLocationManager(locationManager);
        categoryController.setLocationManager(locationManager);
        projectController.setLocationManager(locationManager);
        projectController.setDataRegistry(dataRegistry);
    }

    private void start() {
        locationManager.dispatch();
    }


}


