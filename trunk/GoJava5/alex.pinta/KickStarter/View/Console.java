package Lessons1.KickStarter.View;

import Lessons1.KickStarter.Model.LoaderData;
import Lessons1.KickStarter.Model.Node;
import Lessons1.KickStarter.Model.ProjectElements.ProjectDescription;
import Lessons1.KickStarter.Model.ProjectElements.ProjectHistory;
import Lessons1.KickStarter.Model.ProjectElements.ProjectLink;
import Lessons1.KickStarter.Model.ProjectElements.ProjectQuestionAnswer;

import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 4:45
 * @version: 1.0
 */
public class Console {
    private Scanner locScanner;
    private HashMap<String, Integer> stdLayoutProjectDescription    = new ProjectDescription("", 0 ,0 ,0).getLayoutPattern();
    private HashMap<String, Integer> stdLayoutProjectHistory        = new ProjectHistory("", "", Date.valueOf("")).getLayoutPattern();
    private HashMap<String, Integer> stdLayoutProjectLink           = new ProjectLink("", "").getLayoutPattern();
    private HashMap<String, Integer> stdLayoutProjectQuestionAnswer = new ProjectQuestionAnswer("", "", Date.valueOf("")).getLayoutPattern();


    public Console(InputStream pInputStream) {
        locScanner = new Scanner(pInputStream);
    }

    public String read(){
        String inputType = "";
        while (inputType.equals("")) {
            inputType = locScanner.nextLine();
        }
        return inputType;
    }

    public void write(String prompt){
        System.out.println(prompt);
    }

    public void drawTable(){
        int counter = 0;
        Node mainNode = new LoaderData().loadDataWebSite();
        drawStructureElement(mainNode, ++counter);
    }

    private void drawStructureElement(Node pNode, int pCounter){
        //System.out.format()
    }

}
