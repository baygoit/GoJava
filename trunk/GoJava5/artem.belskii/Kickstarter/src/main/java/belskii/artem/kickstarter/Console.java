package belskii.artem.kickstarter;

import java.util.ArrayList;

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
import com.googlecode.lanterna.gui.dialog.MessageBox;

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
					try {
						String selectedProject=ListSelectDialog.showDialog(getOwner(), categoryTitle, categoryTitle, projects.getProjectListFromCategory(categoryTitle)).toString();
						String projectDetails=projects.getProjectDetails(selectedProject);
						MessageBox.showMessageBox(getOwner(), selectedProject, projectDetails);
						
						
					} catch (NullPointerException e) {
						
					}
				}
			}));
		}
		//End category panel
		
		addComponent(new Button("Exit", new Action() {
			public void doAction() {
				System.exit(0);
			}
		}));
		
		gui.showWindow(console, GUIScreen.Position.NEW_CORNER_WINDOW);
		gui.getScreen().stopScreen();
		

  
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
		projects.addProject("Art","Museum of Digital Art", "Opening its doors with your help, the Museum of Digital Art will be Europe's first physical & virtual museum \ndedicated to digital arts.");
		projects.addProject("Art","The Wabash Lights - The Beta Test", "A site-specific light installation created by the public on the Wabash stretch of elevated train \ntracks (L) in Chicago’s loop.");
		projects.addProject("Art","Black Rock Observatory 2015","A mobile astronomical observatory with a giant, hand-made telescope and meteorite samples for Burning Man \n2015 and beyond.");
		projects.addProject("Technology","Vufine: a Handsfree Wearable Display","Vufine is a handsfree wearable display that allows you to enjoy the familiar functionality \nof your current technology in a new way");		
		projects.addProject("Technology","Deus Ex Aria: The Evolution Of SmartWatch Control","Add Gesture Control To Your Pebble or Android Wear Smartwatch! Deus Ex Aria \nlets you control your devices with simple finger gestures");
		projects.addProject("Technology","LT-1000 Simulator/Trainer Board", "Learn programming with this digital simulator - 8 ins (buttons) and 8 outs (LEDs) to connect \nto Arduino, Raspberry Pi, etc.");

		return projects;
	}

}
