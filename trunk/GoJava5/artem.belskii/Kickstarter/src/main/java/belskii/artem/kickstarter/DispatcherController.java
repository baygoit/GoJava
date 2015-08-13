package belskii.artem.kickstarter;

import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.mvc.controller.CategoryController;
import belskii.artem.kickstarter.mvc.controller.ProjectController;
import belskii.artem.kickstarter.mvc.controller.QuoteController;
import belskii.artem.kickstarter.mvc.model.CategoryModel;
import belskii.artem.kickstarter.mvc.model.ProjectModel;
import belskii.artem.kickstarter.mvc.model.QuoteModel;
import belskii.artem.kickstarter.mvc.view.CategoryView;
import belskii.artem.kickstarter.mvc.view.ProjectView;

public class DispatcherController {
	private int currentPosition=0;
	private int userInput=-1;
	private int userInputTmp=-1;
	private int CLEAN_VALUE=-2;
	private Long currentProjectId;
	private int currentCategoryId;	
	private Output out = new Output();
	private Input in = new Input();
	private CategoryController category = new CategoryController(new CategoryModel(), new CategoryView());
	private ProjectController project = new ProjectController(new ProjectModel(), new ProjectView());
	private QuoteController quote = new QuoteController(new QuoteModel());
	private Project projectForCanges;
	
	public void start(){
		this.checkInput();
		
	}
	
	private  void checkInput(){
		while (currentPosition!=-1){
			if (currentPosition == 0 && userInput == -1 ){
				showCategory();
			}
			if (userInput>=1 && currentPosition == 0 ){
				showProjectFromCategoryId(userInput);
				currentCategoryId=userInput;
				currentPosition+=1;
				userInputTmp=userInput;
				userInput=CLEAN_VALUE;
			}
			if (userInput>=1 && currentPosition == 1){
				showProjectDetails(currentCategoryId, userInput);
				currentPosition+=1;
				userInputTmp=userInput;
				userInput=CLEAN_VALUE;
			}
			if (userInput==1 && currentPosition == 2){
				out.show("Put cardholder name:");
				String cardholderName=in.nextLine();
				out.show("Put card nmumber:");
				String cardNumber=in.nextLine();
				out.show("Put payment variant:");
				out.showPaymentVariants(project.getProjectById(currentProjectId).getPaymetVariants());
				Object[] rawPaymentAmount= project.getProjectById(currentProjectId).getPaymetVariants().get(in.nextLong()-1).keySet().toArray();
				Long paymentAmount = (Long) rawPaymentAmount[0]; 
				project.getProjectById(currentProjectId).updateBalance(paymentAmount);
				out.show("Thanks, "+cardholderName+"! New balance on this project: "+project.getProjectById(currentProjectId).getBalance());
				out.show("Put 0 for return to project details.");
				userInputTmp=userInput;
				userInput=-2;
			}
			
			if (userInput==2 && currentPosition == 2){
				out.show("Put cardholder name:");
				String cardholderName=in.nextLine();
				out.show("Put card nmumber:");
				String cardNumber=in.nextLine();
				out.show("Put payment amount:");
				projectForCanges=project.getProjectById(currentProjectId);
				projectForCanges.updateBalance(in.nextLong());
				project.save(projectForCanges);
				out.show("Thanks, "+cardholderName+"! New balance on this project: "+project.getProjectById(currentProjectId).getBalance());
				out.show("Put 0 for return to project details.");
				userInputTmp=userInput;
				userInput=-2;
			}
			if (userInput==3 && currentPosition == 2){
				out.show("Put your questin on next line:");
				String question=in.nextLine();
				projectForCanges=project.getProjectById(currentProjectId);
				projectForCanges.asqAQuestion(question);
				project.save(projectForCanges);
				showProjectDetails(currentCategoryId, userInputTmp);
			}
			if (userInput == 0 ){
				if(currentPosition==2){
					out.showProjectDetails(project.getProjectById(currentProjectId));
				}
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
	
	private void showCategory(){
		out.show("The Daily Motivator:");
		out.show(quote.getRandomQuote());
		out.show("====================================");
		out.showCategory(category.printCategoryList());
	}
	
	private void showProjectFromCategoryId(int id){
		out.showProjectList(project.getProjectFromCategory(id));
	}
	
	private void showProjectDetails(int categoryId, int selectedProject){
		selectedProject=selectedProject-1;
		out.showProjectDetails(project.getProjectFromCategory(categoryId).get(new Long(selectedProject)));
		currentProjectId=project.getProjectFromCategory(categoryId).get(new Long(selectedProject)).getProjectId();
		out.show("put 1 to make default payment");
		out.show("put 2 to make qustom payment");
		out.show("put 3 to asq a question");
		out.show("put 0 to back to project list");
	}
}
