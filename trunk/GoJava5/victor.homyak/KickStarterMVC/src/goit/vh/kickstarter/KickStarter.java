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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class KickStarter {

    private MainPageController mainPageController;
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
        dataRegistry.registerCategories(new Category[]{new Category("Sport"), new Category("TableGame"), new Category("Video")});

        Map<Integer, Project[]> hm = new HashMap<>();




        Calendar calendar =  Calendar.getInstance();
        calendar.set(2018,05, 9);
        hm.put(1, new Project[]{new Project("Gluconazol","Brend new anabolics",25000000,7500000,calendar.getTime() ,
                                            "New MOC politics dictetes new requirements for pharmasy",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0"),
                                new Project("Eczoskeleton","Brend new anabolics",25000000,7500000,calendar.getTime() ,
                                        "New MOC politics dictetes new requirements for pharmasy",
                                        "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                        "https://www.youtube.com/watch?v=tk7RUVJmLk0"),
                                new Project("Slow Ball","New game with a big, heavy ball",25000000,7500000,calendar.getTime() ,
                                        "New MOC politics dictetes new requirements for pharmasy",
                                        "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                        "https://www.youtube.com/watch?v=tk7RUVJmLk0")});



        hm.put(2, new Project[]{new Project("Gluconazol","Brend new anabolics",25000000,7500000,calendar.getTime() ,
                                            "New MOC politics dictetes new requirements for pharmasy",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0"),
                                new Project("Eczoskeleton","Brend new anabolics",25000000,7500000,calendar.getTime() ,
                                            "New MOC politics dictetes new requirements for pharmasy",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0"),
                                new Project("Slow Ball","New game with a big, heavy ball",25000000,7500000,calendar.getTime() ,
                                            "New MOC politics dictetes new requirements for pharmasy",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0"),
                                new Project("Slow Ball","New game with a big, heavy ball",25000000,7500000,calendar.getTime() ,
                                             "New MOC politics dictetes new requirements for pharmasy",
                                             "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                             "https://www.youtube.com/watch?v=tk7RUVJmLk0")});
        hm.put(3, new Project[]{new Project("Gluconazol","Brend new anabolics",25000000,7500000,calendar.getTime() ,
                                            "New MOC politics dictetes new requirements for pharmasy",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0"),
                                new Project("Eczoskeleton","Brend new anabolics",25000000,7500000,calendar.getTime() ,
                                            "New MOC politics dictetes new requirements for pharmasy",
                                            "Is it legal?\nno\nWhat side effects?\n85% brain cancer",
                                            "https://www.youtube.com/watch?v=tk7RUVJmLk0")});

        dataRegistry.registerMapOfProjects(hm);


        MainPageModel mainPageModel = new MainPageModel();
        mainPageModel.setDataRegistry(dataRegistry);


        CategoryModel categoryModel = new CategoryModel(dataRegistry);

        ProjectModel projectModel = new ProjectModel(dataRegistry);
        mainPageView = new MainPageView(new Output());


        mainPageController = new MainPageController(mainPageView, mainPageModel);
        categoryController = new CategoryController(new CategoryView(new Output()), categoryModel);
        projectController = new ProjectController(new ProjectView(new Output()), projectModel);
        locationManager = new LocationManager(mainPageController, categoryController, projectController);
        mainPageController.setLocationManager(locationManager);
        categoryController.setLocationManager(locationManager);
        projectController.setLocationManager(locationManager);

        projectController.setDataRegistry(dataRegistry);
    }

    private void start() {
        locationManager.onApplicationStart();
    }


}


