package goit.vh.kickstarter;

import goit.vh.kickstarter.model.Category;
import goit.vh.kickstarter.mvc.controller.MainPageController;
import goit.vh.kickstarter.mvc.model.MainPageModel;
import goit.vh.kickstarter.mvc.view.MainPageView;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class KickStarter {

    private MainPageController controller;

    public static void main(String[] args) {
        KickStarter kickStarter = new KickStarter();
        kickStarter.init();
        kickStarter.start();
    }

    private void init() {
        DataRegistry dataRegistry = new DataRegistry();
        dataRegistry.registerCategories(new Category[]{new Category("Sport"), new Category("Game"), new Category("Video")});

        MainPageModel model = new MainPageModel();
        model.setDataRegistry(dataRegistry);

        controller = new MainPageController(new MainPageView(new Output()), model);
    }

    private void start() {
        controller.onApplicationStart();
    }


}


