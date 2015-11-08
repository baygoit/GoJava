package KickStarter.controller;

import KickStarter.Input;
import KickStarter.Output;
import KickStarter.dao.InputFromFile;
import KickStarter.dao.InputFromJDBC;
import KickStarter.dao.LoadingData;
import KickStarter.model.MainPageModel;
import KickStarter.model.Project;
import KickStarter.view.*;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    LoadingData loader;
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
        controller = new CategoryController(new ViewCategory(), controller, deviceOut);
        listOfController.add(controller);
        controller = new ProjectController(new ViewProject(), controller, deviceOut);
        listOfController.add(controller);
        controller = new ProjectMenuController(new ViewProjectMenu(), controller, deviceOut);
        listOfController.add(controller);
    }

    public void startApplication(LoadingData ploader) {
        loader = ploader;
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

    public void actionPerformed() {
        while (true) {
            deviceOut.clear();
            for (EventHandler elemController : listOfController) {
                if (elemController.isHaveToProcessed(mainPageModel.getUserChoice())) {
                    elemController.actionPerformed(mainPageModel.getUserChoice());
                }
            }
            if (!makeChoice()) {
                break;
            }
        }
    }

    public boolean makeChoice() {
        String userChoice = "";
        ProjectMenuController projectMenuController = (ProjectMenuController) getController(ProjectMenuController.class);
        int shiftIndex = 1;
        if (mainPageModel.getUserChoice().size() == projectMenuController.LEVEL_OF_INTERCEPTION_OUTPUT - shiftIndex) {
            Map.Entry menuPosition = projectMenuController.viewProjectMenu.getProjectMenuElement(projectMenuController);
            if (menuPosition.getKey().toString().equals("INVESTMENT")) {
                investInProject(projectMenuController);
            } else if (menuPosition.getKey().toString().equals("QUESTION")) {
                askAQuestion(projectMenuController);
            }
            List<Integer> updatedList = mainPageModel.getUserChoice();
            updatedList.remove(updatedList.size() - 1);
            if (updatedList.size() == 0) {
                updatedList.add(0);
            }
            if (projectMenuController.categoryModel.isChangedProperty()){
                commitChangeInDAO(projectMenuController.categoryModel);
            }
        } else {
            deviceOut.writeln(viewMainPage.getStringSeparator());
            deviceOut.write("Choose interested position: ");
            deviceOut.show();
            userChoice = deviceIn.inputChoice();
            if (userChoice.equalsIgnoreCase("Q")) {
                return false;
            }
            if (userChoice.equals("0")) {
                List<Integer> updatedList = mainPageModel.getUserChoice();
                updatedList.remove(updatedList.size() - 1);
                if (updatedList.size() == 0) {
                    updatedList.add(0);
                }
                mainPageModel.setUserChoice(updatedList);
            } else {
                if (validateChoice(userChoice)) {
                    List<Integer> updatedList = mainPageModel.getUserChoice();
                    if (updatedList.get(0) == 0) {
                        updatedList.set(0, Integer.parseInt(userChoice));
                    } else {
                        updatedList.add(Integer.parseInt(userChoice));
                    }
                    mainPageModel.setUserChoice(updatedList);
                } else {
                    throw new RuntimeException("Incorrect choice!");
                }
            }
        }
        return true;
    }

    private void askAQuestion(ProjectMenuController projectMenuController) {
        deviceOut.write("Input your name: ");
        deviceOut.show();
        String pUser = deviceIn.inputChoice();
        deviceOut.write("Your question: ");
        deviceOut.show();
        String pDescription = deviceIn.inputChoice();
        Date pDateAdded = new Date(System.currentTimeMillis());
        projectMenuController.categoryModel.addUserQuestionAnswer(pDescription, pUser, pDateAdded);
    }

    private void investInProject(ProjectMenuController projectMenuController) {
        String userChoice;
        deviceOut.writeln(viewMainPage.getStringSeparator());
        deviceOut.write("Do you want invest in project (Y/N): ");
        deviceOut.show();
        userChoice = deviceIn.inputChoice();
        if (userChoice.equalsIgnoreCase("Y")) {
            deviceOut.write("Input your name: ");
            deviceOut.show();
            String userName = deviceIn.inputChoice();
            deviceOut.write("Input your card number: ");
            deviceOut.show();
            String userCard = deviceIn.inputChoice();
            deviceOut.write("Input your amount: ");
            deviceOut.show();
            String userAmount = deviceIn.inputChoice();
            if (validateInputedData(userAmount, "[\\d\\.]{1,15}") && projectMenuController.categoryModel.updateData("balancedAmount", projectMenuController.categoryModel.balancedAmount + Double.valueOf(userAmount))) {
                deviceOut.writeln("Thank you " + userName + " for your choice!");
                deviceOut.writeln("Payment carried out!");
                deviceOut.show();
            } else {
                deviceOut.writeln("Invalid format of amount. Try again!");
                deviceOut.show();
            }

        }
    }

    private void commitChangeInDAO(Project categoryModel) {
        if (loader.getClass() == InputFromFile.class){
            loader.saveData();
        } else if (loader.getClass() == InputFromJDBC.class){

        }
        categoryModel.commitChange();
    }

    public EventHandler getController(Class<? extends EventHandler> keyType){
        for (EventHandler elem : listOfController){
            if (elem.getClass() == keyType){
                return elem;
            }
        }
        throw new RuntimeException("Illegal parameter for class name: " + keyType.toString());
    }
    public boolean validateChoice(String userChoice){
        Pattern pattern = Pattern.compile("[^\\d^"+"]");
        Matcher matcher = pattern.matcher(userChoice);
        return !matcher.lookingAt();
    }
    public boolean validateInputedData(String data, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public Input getDeviceIn() {
        return deviceIn;
    }

    public Output getDeviceOut() {
        return deviceOut;
    }
}
