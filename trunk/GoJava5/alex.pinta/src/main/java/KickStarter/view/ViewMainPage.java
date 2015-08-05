package KickStarter.view;


import KickStarter.controller.MainPageController;
import KickStarter.model.Category;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 12.07.15
 * Time: 15:37
 * @version: 1.0
 */
public class ViewMainPage {
    public static final int HORIZONTAL_SIZE = 150;
    public static final String SYMBOL = "-";

    public String stringSeparator;
    public int horizontalSizeOfRenderWorkPlace;
    private int currentOutputPosition;

    //public ViewMainPage() {
//        this.deviceOut = deviceOut;
//        this.model = model;
    //}
    public void setPropertiesForRendering(int horizontalSizeOfRenderWorkPlace, String separatorSymbol){
        this.horizontalSizeOfRenderWorkPlace = horizontalSizeOfRenderWorkPlace;
        createStringSeparator(separatorSymbol);
    }
    private void createStringSeparator(String character){
        stringSeparator = "";
        for (int i = 0; i < horizontalSizeOfRenderWorkPlace; i++) {
            stringSeparator += character;
        }
    }

    public String getStringSeparator(){
        return stringSeparator;
    }

    public void render(MainPageController controller){

        int counter = 0;
        currentOutputPosition = 0;
        controller.deviceOut.writeln("Success doesn't come to you…you go to it.");
        controller.deviceOut.writeln("");
        //for (Category elemCategory : model.getCatalogCategory()){
        for (int index = 0; index < controller.mainPageModel.getCatalogCategory().size(); index++) {
            Category elemCategory = controller.mainPageModel.getCatalogCategory().get(index);
            controller.deviceOut.writeln(getStringSeparator());
//            structureCounter = String.valueOf(elemCategory.getId());

            horizontalSizeOfRenderWorkPlace = getStringSeparator().length() - 2;
            controller.deviceOut.writeln("|" + String.format(" %1$-" + horizontalSizeOfRenderWorkPlace + "s",getTabIndent(counter) + "-" + ((index== 0) ? "" : String.valueOf(index) + " ") + elemCategory.name) + "|");
             if (controller.isHaveToExpand(index)){
                 controller.deviceOut.write("#category#");
                 currentOutputPosition = index;
//                break;
            }
            if (counter == 0 && index == 0) {
                counter = controller.LEVEL_OF_INTERCEPTION_OUTPUT;
            }
        }
    }

    public String getTabIndent(int counter){
        String temp = "";
        for (int i = 0; i < counter; i++) {
            temp += "  ";
        }
        return temp;
    }
    public int getHorizontalSizeOfRenderWorkPlace() {
        return horizontalSizeOfRenderWorkPlace;
    }

    public int getCurrentOutputPosition() {
        return currentOutputPosition;
    }
}
