package ua.com.goit.gojava.POM.dataModel.profitcost;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
//import ua.com.goit.gojava.POM.persistence.DataManager;









import ua.com.goit.gojava.POM.dataModel.temporaryUnusedClases.FinancialProjectPlan;

public class Project {//implements DataObject, Serializable {
	
	private static final long serialVersionUID = 3538434347597125924L;
	private long id = 0;
	private String name = "";
	private String description = "";
	private ProjectType type = ProjectType.OUTER;
	private boolean active = true;
	private String pm = "";
	private List<ProjectStage> stages = new ArrayList<ProjectStage>();
	private List<FinancialProjectPlan> projectsPlans = new ArrayList<FinancialProjectPlan>();
	
	public long getId() {
		
		return id;
		
	}
	
	public void setId(long id) {
		
		this.id = id;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public String getDescription() {
		
		return description;
		
	}
	
	public void setDescription(String description) {
		
		this.description = description;
		
	}
	
	public ProjectType getType() {
		
		return type;
		
	}
	
	public void setType(ProjectType type) {
		
		this.type = type;
		
	}
	
	public boolean isActive() {
		
		return active;
		
	}
	
	public void setActive(boolean active) {
		
		this.active = active;
		
	}
	
	public String getPm() {
		
		return pm;
		
	}
	
	public void setPm(String pm) {
		
		this.pm = pm;
		
	}
	
	public List<ProjectStage> getStages() {
		
		return stages;
		
	}
	
	public ProjectStage createStage() {
		
		ProjectStage newStage = new ProjectStage();
		stages.add(newStage);
		
		return newStage;
		
	}
	
	public ProjectFinResultTransaction addTransaction(ProjectStage currentStage) {
		
		return currentStage.addTransaction();
		
	}
	
	public FinancialProjectPlan createProjectPlan() {
		
		FinancialProjectPlan newProjectPlan = new FinancialProjectPlan();
		projectsPlans.add(newProjectPlan);
		
		return newProjectPlan;
		
	}
	
	public List<FinancialProjectPlan> getProjectsPlans() {
		
		return projectsPlans;
		
	}

	public long getProfit() {

		long result = 0;
		for (ProjectStage stage:getStages()) {
			
			result += stage.getProfit();
			
		}
		
		return result;
	}

	public long getPlanFactDifference() {

		long result = 0;
		for (ProjectStage stage:getStages()) {
			
			result += stage.getProfit();
			
		}
		
		for (FinancialProjectPlan projectPlan:getProjectsPlans()) {
			
			if(projectPlan.isActive()) {
				
				result -= projectPlan.getPlannedProfit();
				
			}
			
		}
		
		return result;
	}
}