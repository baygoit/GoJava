package KickStarter.controller;

import KickStarter.Input;
import KickStarter.Output;
import KickStarter.dao.LoadingData;
import KickStarter.model.MainPageModel;
import KickStarter.view.ViewCategory;
import KickStarter.view.ViewMainPage;
import KickStarter.view.ViewProject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 12.07.15
 * Time: 21:19
 * @version: 1.0
 */
public class Dispatcher {
    private Input deviceIn;
    private Output deviceOut;
    ViewMainPage viewMainPage;
    MainPageModel mainPageModel;
    List<EventHandler> listOfController = new ArrayList<>();

    public Dispatcher(Input deviceIn, Output deviceOut) {
        this.deviceIn = deviceIn;
        this.deviceOut = deviceOut;
    }

    public void initController(){
        //initialization list of controllers
        EventHandler controller;
        controller = new MainPageController(viewMainPage, mainPageModel, deviceOut);
        listOfController.add(controller);
        controller = new CategoryController(new ViewCategory(), controller, new Output(System.out));
        listOfController.add(controller);
        controller = new ProjectController(new ViewProject(), controller, new Output(System.out));
        listOfController.add(controller);
    }

    public void startApplication(LoadingData loader) {
        loader.load();
        mainPageModel = new MainPageModel();
        mainPageModel.setModelSource(loader.getMapping(), loader.getCategoryList());
        List<Integer> defaultChoice = new ArrayList<>();
        defaultChoice.add(0, 0);
        mainPageModel.setUserChoice(defaultChoice);
        viewMainPage = new ViewMainPage();
        viewMainPage.setPropertiesForRendering(150, "-");
        initController();
    }

    public void actionPerformed(){
        String userChoice = "";
        while (true) {
            deviceOut.clear();
            for (EventHandler elemController : listOfController){
                if (elemController.isHaveToProcessed(mainPageModel.getUserChoice())){
                    elemController.actionPerformed(mainPageModel.getUserChoice());
                }
            }
            deviceOut.writeln(viewMainPage.getStringSeparator());
            deviceOut.write("Choose interested position: ");
            deviceOut.show();
            userChoice = deviceIn.inputChoice();
            if (userChoice.equalsIgnoreCase("Q")){
                break;
            }
            if (userChoice.equals("0")){
                List<Integer> updatedList = mainPageModel.getUserChoice();
                updatedList.remove(updatedList.size()-1);
                if (updatedList.size() == 0){
                    updatedList.add(0);
                }
                mainPageModel.setUserChoice(updatedList);
            } else {
                if (validateChoice(userChoice)){
                    List<Integer> updatedList = mainPageModel.getUserChoice();
                    if (updatedList.get(0) == 0 ){
                        updatedList.set(0, Integer.parseInt(userChoice));
                    } else {
                        updatedList.add(Integer.parseInt(userChoice));
                    }
                    mainPageModel.setUserChoice(updatedList);
                } else{
                    deviceOut.writeln("Incorrect choice!");
                }
            }
        }
    }

    public boolean validateChoice(String userChoice){
        Pattern pattern = Pattern.compile("[^\\d^"+"]");
        Matcher matcher = pattern.matcher(userChoice);
        if (matcher.lookingAt()){
            return false;
        }
        return true;
    }

    public Input getDeviceIn() {
        return deviceIn;
    }

    public Output getDeviceOut() {
        return deviceOut;
    }
}
