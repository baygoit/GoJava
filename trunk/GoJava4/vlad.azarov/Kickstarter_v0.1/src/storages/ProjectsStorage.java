package storages;
import entities.Project;

public class ProjectsStorage {
	
	private Project[] projects;

}




/*

--
- projects : Project[1..*]

--
+ addProject(newProject : Project)
+ removeProject(e:Project)
+ setName(newName:String)
+ getName() : String
+ getProjectID() : int
+ setBrief(newBrief : String)
+ getBrief() : String
+ setPledged(newPledged : int)
+ getPledged() : int
+ setDaysToGo()
+ getDaysToGo()
+ setDescription()
+ getDescription()
+ setLink()
+ getLink()
+ getFAQ()
*/