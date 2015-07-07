package belskii.artem.kickstarter;

import belskii.artem.kickstarter.Projects.ProjectInfo;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.ListSelectDialog;

public class Console extends Window{
    public Console(String title) {
		super(title);

	}
    
    
    
    
	public void start(Console console) {
		GUIScreen gui = TerminalFacade.createGUIScreen();
		gui.getScreen().startScreen();
		// start motivation panel
		Panel motivation = new Panel(new Border.Standard(), Panel.Orientation.HORISONTAL);
		Motivation motivationText = initializeMotivationFromDatabase();
		motivation.addComponent(new TextBox(motivationText.getMotivation()));
		addComponent(motivation);
		// end motivation panel

		// Show category panel
		Category categoryModel = initializeCategoryFromDatabase();
		CategoryView categoryView = new CategoryView();
		CategoryController category = new CategoryController(categoryModel, categoryView);
		
		for (int i = 0; i < category.getCategoryList().size(); i++) {
			final String categoryTitle=category.getCategoryList().get(i);
			addComponent(new Button(categoryTitle, new Action() {
				public void doAction() {
					Projects projectModel = retriveProjectFromDatabase(); 
					ProjectsView projectsView = new ProjectsView();
					ProjectsController projects = new ProjectsController(projectModel, projectsView);
					projects.getProjectListFromCategory(categoryTitle);
										 
					//System.out.println(projects.getProjectListFromCategory(categoryTitle).size());
					try {
						System.out.println(ListSelectDialog.showDialog(getOwner(), categoryTitle, categoryTitle, projects.getProjectListFromCategory(categoryTitle)));
					} catch (Exception NullPointerException) {
						
					}
					
					
					
				}
			}));

		}
		//End category panel
		
		
		this.addExitButton();
		gui.showWindow(console, GUIScreen.Position.NEW_CORNER_WINDOW);
		gui.getScreen().stopScreen();

	}

	public void addExitButton() {
		addComponent(new Button("Exit", new Action() {
			public void doAction() {
				System.exit(0);
			}
		}));
	}    
	
    //prepare demo data
    private static Motivation initializeMotivationFromDatabase() {
		Motivation motivation = new Motivation();
		motivation.addMotivation("Рекорды существуют для того, чтобы их бить.");
		motivation.addMotivation("Знаний не достаточно, ты должен применять их. Желания не достаточно, ты должен делать.");
		motivation.addMotivation("Если вы хотите заставить человека смеяться вашим шуткам, скажите ему, что у него есть чувство юмора");
		motivation.addMotivation("Ночь не может длиться вечно.");
		motivation.addMotivation("Пессимист видит трудность в любой возможности; оптимист – видит возможность в любой трудности.");
		return motivation;

	}
    
	private static Category initializeCategoryFromDatabase() {
		Category category = new Category();
		category.addCategory("Art");
		category.addCategory("Comics");
		category.addCategory("Crafts");
		category.addCategory("Dance");
		category.addCategory("Design");
		category.addCategory("Fashion");
		category.addCategory("Film & Video");
		category.addCategory("Food");
		category.addCategory("Games");
		category.addCategory("Journalism");
		category.addCategory("Music");
		category.addCategory("Photography");
		category.addCategory("Publishing");
		category.addCategory("Technology");
		category.addCategory("Theater");
		
		return category;
	}
	
	private static Projects retriveProjectFromDatabase() {
		Projects projects = new Projects();
		projects.addProject("Art", "Museum of Digital Art", "Opening its doors with your help, the Museum of Digital Art will be Europe's first physical & virtual museum dedicated to digital arts.");
		projects.addProject("Art", "The Wabash Lights - The Beta Test", " A site-specific light installation created by the public on the Wabash stretch of elevated train tracks (L) in Chicago’s loop.");
		return projects;
	}

}
