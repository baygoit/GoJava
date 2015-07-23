import controller.ControllerMain;
import model.ModelMain;
import view.ViewMain;

public class Ranner {

    public static void main(String[] args) {

        ModelMain modelMain = retrive();
        ViewMain viewMain = new ViewMain();

        ControllerMain controllerMain = new ControllerMain(modelMain, viewMain);

        controllerMain.updateView();

        controllerMain.setModelMain("Test");

        controllerMain.updateView();
    }

    private static  ModelMain retrive(){
        ModelMain modelMain = new ModelMain();
        modelMain.setA("Test 1");
        return modelMain;
    }
}
