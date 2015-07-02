package Lessons1.KickStarter.Model.ProjectElements;

import Lessons1.KickStarter.Model.ProjectElement;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 5:57
 * @version: 1.0
 */
public class ProjectDescription implements ProjectElement {
    public String description;
    public double requirementAmount;
    public double balancedAmount;
    public int daysLeft;
    private HashMap<String, Integer> layout;

    public ProjectDescription(String pDescription, double pRequirementAmount, double pBalancedAmount, int pDaysLeft) {
        description = pDescription;
        requirementAmount = pRequirementAmount;
        balancedAmount = pBalancedAmount;
        daysLeft = pDaysLeft;
    }

    @Override
    public HashMap<String, Integer> getLayoutPattern() {
        HashMap<String, Integer> temp = new HashMap<String, Integer>();
        temp.put("description",         0);
        temp.put("requirementAmount",   0);
        temp.put("balancedAmount",      0);
        temp.put("daysLeft",            0);

        return temp;
    }

    @Override
    public HashMap<String, Integer> getLayout() throws InstantiationException{
        if (layout.isEmpty()) {
            new InstantiationException("Element don't have layout parameters");
            return null;
        } else {
            return layout;
        }
    }

    @Override
    public void setLayout(HashMap<String, Integer> layout) {
        this.layout = layout;
    }

}
