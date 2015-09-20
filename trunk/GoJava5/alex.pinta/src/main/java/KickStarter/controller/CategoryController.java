package KickStarter.controller;

import KickStarter.Output;
import KickStarter.model.Category;
import KickStarter.view.ViewCategory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 12.07.15
 * Time: 21:28
 * @version: 1.0
 */
public class CategoryController implements EventHandler{
    public final int LEVEL_OF_INTERCEPTION_OUTPUT = 2;
    public Output deviceOut;
    public Category categoryModel;
    public ViewCategory viewCategory;
    public List<Integer> userChoice;
    private EventHandler parentController;

    public CategoryController(ViewCategory viewCategory, EventHandler parentController, Output deviceOut) {
        this.deviceOut = deviceOut;
        this.viewCategory = viewCategory;
        this.parentController = parentController;
    }

    public Category getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(Category categoryModel) {
        this.categoryModel = categoryModel;
    }

    @Override
    public void actionPerformed(List<Integer> userChoice) {
        this.userChoice = userChoice;
        parentController.actionPerformed(userChoice);
        setCategoryModel(((MainPageController)parentController).mainPageModel.getCatalogCategory().get(
                         ((MainPageController)parentController).viewMainPage.getCurrentOutputPosition()));
        viewCategory.render(this);
    }

    @Override
    public boolean isHaveToProcessed(List<Integer> userChoice) {
        if (userChoice.size() == LEVEL_OF_INTERCEPTION_OUTPUT-1 && userChoice.get(LEVEL_OF_INTERCEPTION_OUTPUT - 2) != 0) {
            this.userChoice = userChoice;
            return true;
        }
        return false;
   }

    @Override
    public boolean isHaveToExpand(int verifiableID) {
        if (userChoice.size() >= LEVEL_OF_INTERCEPTION_OUTPUT && userChoice.get(LEVEL_OF_INTERCEPTION_OUTPUT-1) == verifiableID){
            return true;
        }
        return false;
    }

    public EventHandler getParentController() {
        return parentController;
    }

    public Output getDeviceOut() {
        return deviceOut;
    }
}
