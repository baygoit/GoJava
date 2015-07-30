package belskii.artem.kickstarter;

import belskii.artem.kickstarter.mvc.controller.CategoryController;
import belskii.artem.kickstarter.mvc.controller.ProjectController;
import belskii.artem.kickstarter.mvc.model.CategoryModel;
import belskii.artem.kickstarter.mvc.model.ProjectModel;
import belskii.artem.kickstarter.mvc.view.CategoryView;
import belskii.artem.kickstarter.mvc.view.ProjectView;

public class DispatcherController {
	private String MOTIVATION_QUOTE="Берись и делай!";
	int currentPosition=0;
	int userInput=-1;
	int userInputTmp=-1;
	Output out = new Output();
	Input in = new Input();
	CategoryController category = new CategoryController(new CategoryModel(), new CategoryView());
	ProjectController project = new ProjectController(new ProjectModel(), new ProjectView());
	
	
	public void start(){
		this.checkInput();
		
	}
	
	public  void checkInput(){
		while (currentPosition!=-1){
			if (currentPosition == 0 && userInput == -1 ){
				showCategory();
			}
			if (userInput>=1 && currentPosition == 0 ){
				showProjectFromCategoryId(userInput);
				currentPosition+=1;
				userInputTmp=userInput;
				userInput=-2;
			}
			if (userInput>=1 && currentPosition == 1){
				showProjectDetails(userInput);
				userInputTmp=userInput;
				userInput=-2;
			}
			if (userInput == 0 ){
				if (currentPosition==1){
					showProjectFromCategoryId(userInputTmp);
				}
				if (currentPosition==0){
					showCategory();
				}
				if (currentPosition<0){
					System.exit(0);
				}
				currentPosition-=1;
			}
			userInput=in.read();
		}
	}
	
	public void showCategory(){
		out.show("The Daily Motivator:");
		out.show(MOTIVATION_QUOTE);
		out.show("====================================");
		out.showCategory(category.printCategoryList());
	}
	
	public void showProjectFromCategoryId(int id){
		out.showProjectList(project.getProjectFromCategory(id));
	}
	
	public void showProjectDetails(int id){
		out.showProjectDetails(project.printProjectDetails(userInput));		
	}
	
	
}
