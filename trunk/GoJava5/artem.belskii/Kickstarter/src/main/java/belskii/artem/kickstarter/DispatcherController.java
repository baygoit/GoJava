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
	Output out = new Output();
	Input in = new Input();
	CategoryController category = new CategoryController(new CategoryModel(), new CategoryView());
	ProjectController project = new ProjectController(new ProjectModel(), new ProjectView());
	
	
	public void start(){
		this.checkInput(in);
	}
	
	public  void checkInput(Input in){
		if (currentPosition == 0 ){
			out.show("The Daily Motivator:");
			out.show(MOTIVATION_QUOTE);
			out.show(category.printCategoryList());
		};
		if (currentPosition != 0) {
//			out.show(project.getProjectList());
		}
		
	}
	
	
	
}
