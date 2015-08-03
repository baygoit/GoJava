package KickStarter.controller;

import KickStarter.Output;
import KickStarter.model.MainPageModel;
import KickStarter.view.ViewMainPage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 12.07.15
 * Time: 15:08
 * @version: 1.0
 */
public class MainPageController implements EventHandler{
    public final int LEVEL_OF_INTERCEPTION_OUTPUT = 1;
    public Output deviceOut;
    public MainPageModel mainPageModel;
    public ViewMainPage viewMainPage;
    public List<Integer> userChoice;

    public MainPageController(ViewMainPage viewMainPage, MainPageModel mainPageModel, Output deviceOut) {
        this.viewMainPage = viewMainPage;
        this.mainPageModel = mainPageModel;
        this.deviceOut = deviceOut;
    }

    @Override
    public boolean isHaveToProcessed(List<Integer> userChoice) {
        if ((userChoice.get(0) == 0)) {
            return true;
        }
        return false;
    }

    @Override
    public void actionPerformed(List<Integer> userChoice){
        this.userChoice = userChoice;
        viewMainPage.render(this);
    }

    @Override
    public boolean isHaveToExpand(int verifiableID) {
        if ((userChoice.get(LEVEL_OF_INTERCEPTION_OUTPUT-1) != 0) && userChoice.get(LEVEL_OF_INTERCEPTION_OUTPUT-1) == verifiableID){
            return true;
        }
        return false;
    }
}
