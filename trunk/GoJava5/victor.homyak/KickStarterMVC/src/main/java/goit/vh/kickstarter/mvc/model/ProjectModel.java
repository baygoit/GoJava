package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Viktor on 14.07.2015.
 */
public class ProjectModel {

    private DataRegistry dataRegistry;
    private ArrayList<ProjectModel> listOfProjectses;

    private String projectName;
    private String shortDescription;
    private int sumToRaise;
    private int currentSum;
    private Date endDate;
    private String projectHistory;
    private String fAQ;
    private String demoURL;
    private String parentName;
    private int parentId;

    public ProjectModel() {

    }

    public ProjectModel(String name, String shortDescription, int sumToRaise, int currentSum, Date endDate,
                   String projectHistory, String fAQ, String demoURL, String parentName, int parentId) {
        this.projectName = name;
        this.shortDescription = shortDescription;
        this.sumToRaise = sumToRaise;
        this.currentSum = currentSum;
        this.endDate = endDate;
        this.projectHistory = projectHistory;
        this.fAQ = fAQ;
        this.demoURL = demoURL;
        this.parentName = parentName;
        this.parentId= parentId;
    }



    public ArrayList<ProjectModel> getListOfProjectses() {
        return listOfProjectses;
    }

 //   public Object refreshModel(int[] path)throws IndexOutOfBoundsException{
        public void refreshModel(int[] path)throws IndexOutOfBoundsException{
//        if (dataRegistry.getProject(path) == null) {
//            return null;
//        }
            try {
                dataRegistry.getProject(path);
                this.projectName = dataRegistry.getProject(path).getProjectName();
                this.shortDescription = dataRegistry.getProject(path).getShortDescription();
                this.sumToRaise = dataRegistry.getProject(path).getSumToRaise();
                this.currentSum = dataRegistry.getProject(path).getCurrentSum();
                this.endDate = dataRegistry.getProject(path).getEndDate();
                this.projectHistory = dataRegistry.getProject(path).getProjectHistory();
                this.fAQ = dataRegistry.getProject(path).getfAQ();
                this.demoURL = dataRegistry.getProject(path).getDemoURL();
            }catch (IndexOutOfBoundsException ex) {
                ex.toString();
            }
      //  return 1;
    }

    public void refreshListModel(int input) {
        this.listOfProjectses = dataRegistry.getProjectList(input);

    }

    public String getShortDescription() {
        return shortDescription;
    }

    public int getSumToRaise() {
        return sumToRaise;
    }

    public int getCurrentSum() {
        return currentSum;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getProjectHistory() {
        return projectHistory;
    }

    public String getfAQ() {
        return fAQ;
    }

    public String getDemoURL() {
        return demoURL;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getParentName() {
        return parentName;
    }

    public int getParentId() {
        return parentId;
    }


    public void setDataRegistry(DataRegistry dataRegistry) {
        this.dataRegistry = dataRegistry;
    }
}

