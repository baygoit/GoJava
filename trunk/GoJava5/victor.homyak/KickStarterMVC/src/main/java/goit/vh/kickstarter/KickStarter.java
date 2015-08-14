package goit.vh.kickstarter;

import goit.vh.kickstarter.dao.*;
import goit.vh.kickstarter.mvc.controller.CategoryController;
import goit.vh.kickstarter.mvc.controller.MainPageController;
import goit.vh.kickstarter.mvc.controller.ProjectController;
import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.ProjectModel;
import goit.vh.kickstarter.mvc.view.CategoryView;
import goit.vh.kickstarter.mvc.view.MainPageView;
import goit.vh.kickstarter.mvc.view.ProjectView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class KickStarter {

    private final Output output = new Output();
    private LocationManager locationManager;

    public static void main(String[] args) {
        KickStarter kickStarter = new KickStarter();
        kickStarter.init();
        kickStarter.start();
    }

    private void init() {
        //Here we initialize from what data storage we want to take
        //TODO save type of connection in property file
        DAOFactory daoFactory =
                DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);



        DataRegistry dataRegistry = new DataRegistry();
        Map<Integer, ArrayList<ProjectModel>> categories = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 05, 9);

        ArrayList<ProjectModel> category1 = new ArrayList<>();
        category1.add(new ProjectModel("Gluconazol -", "Brend new anabolics;", 25000000, 7500000, calendar.getTime(),
                "New MOC politics dictetes new requirements for pharmasy;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Sport", 1));
        category1.add(new ProjectModel("Eczoskeleton -", "This thing upgrades muscle power;", 4000000, 2500000, calendar.getTime(),
                "Limites of human body was reached, but sport of big achievements  isn`t stopped;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Sport", 1));
        category1.add(new ProjectModel("Slow Ball -", "New game with a big, heavy ball", 740000, 300000, calendar.getTime(),
                "Football, basketball is no longer attractive. People want to see something new;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Sport", 1));
        categories.put(1, category1);

        ArrayList<ProjectModel> category2 = new ArrayList<>();
        category2.add(new ProjectModel("Warriors of eternity -", "New game, clone of 'Game of thrones';", 10000, 1500, calendar.getTime(),
                "Game of thrones was a very good game, but it starts to bore people, so new game is on!!;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Table games", 2));
        category2.add(new ProjectModel("Robo rally 2 -", "Reincarnation of good old strategy;", 7500, 3000, calendar.getTime(),
                "You will be able to construct factories in new version. The game map become twise bigger;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Table games", 2));
        category2.add(new ProjectModel("Slow Ball table game -", "New table game;", 12000, 10000, calendar.getTime(),
                "Astoneshing gameplay, provided by Julius Beismann. We promise, You will sink in variety of game strategy; ",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Table games", 2));
        category2.add(new ProjectModel("Leprecons -", "The game based on old movie;", 3000, 2750, calendar.getTime(),
                "Classical 2*2 game, which will be easy to play with friends;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Table games", 2));
        categories.put(2, category2);

        ArrayList<ProjectModel> category3 = new ArrayList<>();
        category3.add(new ProjectModel("Garbage collector -", "Tool for utilization of home garbage;", 500000, 50000, calendar.getTime(),
                "In partnership with norvegian ecological ministry we developing a revolutionary device for utilization;",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Ecology projects", 3));
        category3.add(new ProjectModel("Pioneers -", "New forest ecosystem ceepeng organization;", 11000000, 3000000, calendar.getTime(),
                "In times when forrest pollution grows, sosiety needs not only better culture, but people who will " +
                        "stend on guard of our forests; ",
                "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                "https://www.youtube.com/watch?v=tk7RUVJmLk0", "Ecology projects", 3));

        categories.put(3, category3);




        CategoryDAO categoryDAO = daoFactory.getCategoryDAO();
        categoryDAO.registerCategories(categories);

        dataRegistry.registerCategories(categoryDAO.getCategories());

        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setDataRegistry(dataRegistry);

        ProjectModel projectModel = new ProjectModel();
        projectModel.setDataRegistry(dataRegistry);


        MainPageController mainPageController = new MainPageController(new MainPageView(output),categoryModel);
        CategoryController categoryController = new CategoryController(new CategoryView(output), new ProjectView(output),
                categoryModel, projectModel);
        ProjectController projectController = new ProjectController(new ProjectView(output), projectModel);


        locationManager = new LocationManager(mainPageController, categoryController, projectController);

        mainPageController.setLocationManager(locationManager);
        categoryController.setLocationManager(locationManager);
        projectController.setLocationManager(locationManager);
    }

    private void start() {
        locationManager.dispatch();
    }


}


