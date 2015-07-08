package ua.goit.kyrychok.domain;

import ua.goit.kyrychok.Loader;
import ua.goit.kyrychok.controllers.ApplicationController;
import ua.goit.kyrychok.views.ApplicationView;

public class Application {

    public void run() {
        ApplicationController controller = new ApplicationController(Loader.load(), new ApplicationView());
        controller.showModel("Location: ");
    }
}
