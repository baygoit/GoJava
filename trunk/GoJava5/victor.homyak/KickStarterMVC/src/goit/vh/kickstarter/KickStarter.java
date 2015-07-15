package goit.vh.kickstarter;

import goit.vh.kickstarter.model.Category;
import goit.vh.kickstarter.model.Project;
import goit.vh.kickstarter.mvc.controller.CategoryController;
import goit.vh.kickstarter.mvc.controller.MainPageController;
import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.MainPageModel;
import goit.vh.kickstarter.mvc.view.CategoryView;
import goit.vh.kickstarter.mvc.view.MainPageView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class KickStarter {

    private MainPageController mainPageController;
    private CategoryController categoryController;
    private MainPageView mainPageView;
    private LocationManager locationManager;
    public static void main(String[] args) {
        KickStarter kickStarter = new KickStarter();
        kickStarter.init();
        kickStarter.start();
    }

    private void init() {

        DataRegistry dataRegistry = new DataRegistry();
        dataRegistry.registerCategories(new Category[]{new Category("Sport"), new Category("TableGame"), new Category("Video")});

        Map<Integer,Project[]> hm = new HashMap<Integer, Project[]>();

        hm.put(1,new Project[]{new Project("Basketball"), new Project("Surfing"), new Project("Golf")});
        hm.put(2,new Project[]{new Project("GameOfThrones"), new Project("Manager"), new Project("Bang"), new Project("Bingo")});
        hm.put(3,new Project[]{new Project("ManInBlack4"), new Project("GreatAdventuresOfJesus")});
        dataRegistry.registerMapOfProjects(hm);


        MainPageModel mainPageModel = new MainPageModel();
        mainPageModel.setDataRegistry(dataRegistry);
        CategoryModel categoryModel = new CategoryModel(dataRegistry);
         mainPageView = new MainPageView(new Output());

        mainPageController = new MainPageController(mainPageView, mainPageModel);
        categoryController = new CategoryController(new CategoryView(new Output()),categoryModel);
        locationManager = new LocationManager(mainPageController,categoryController);
        mainPageController.setLocationManager(locationManager);
        categoryController.setLocationManager(locationManager);
    }

    private void start() {
        locationManager.onApplicationStart();
    }


}


