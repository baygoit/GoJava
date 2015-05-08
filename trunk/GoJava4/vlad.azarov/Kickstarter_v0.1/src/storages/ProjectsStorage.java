package storages;
import entities.Project;

public class ProjectsStorage extends Project {
	
	
	
	
	
	
	
	public void create() {
		name = "Car";
		brief = "Some brief text";
		projectID = (0000001);
	}

	
	public void showProject() {
		System.out.println("PROJECT: ");
		System.out.println();
		System.out.printf("\tName:         %s\n", name);
		System.out.printf("\tBrief:        %s\n", brief);
		System.out.printf("\tPledged:      %s\n", pledged);
		System.out.printf("\tDays to go:   %s\n", daysToGo);
		System.out.printf("\tDescription:  %s\n", description);
		System.out.printf("\tLink:         %s\n", link);
		System.out.printf("\tFAQ:          %s\n", FAQ);
		System.out.printf("\tID:           %s\n", projectID);
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
	}	
	
}

