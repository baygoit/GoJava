package controller;

import model.ModelMain;
import view.ViewMain;

public class ControllerMain {

    private ModelMain modelMain;
    private ViewMain viewMain;

    public ControllerMain(ModelMain modelMain, ViewMain viewMain){
        this.modelMain = modelMain;
        this.viewMain = viewMain;
    }

   public void setModelMain(String a){
       modelMain.setA(a);
   }

    public  String getModelMain(){
        return modelMain.getA();
    }

    public void updateView(){
        viewMain.addText(modelMain.getA());
    }




}
