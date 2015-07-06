package belskii.artem.kickstarter;

import javax.swing.border.EmptyBorder;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.MessageBox;

public class Console extends Window{
    public Console(String title) {
		super(title);

	}
    
    
    
    
    public void start(Console console){
		GUIScreen gui = TerminalFacade.createGUIScreen();
    	gui.getScreen().startScreen();
    	Panel motivation = new Panel(new Border.Standard(), Panel.Orientation.HORISONTAL);
    	Motivation motivationText = initializeMotivationFromDatabase();
    	motivation.addComponent(new TextBox(motivationText.getMotivation()));
    	addComponent(motivation);
    	
    	this.addButton();
    	
    	gui.showWindow(console, GUIScreen.Position.NEW_CORNER_WINDOW);
    	gui.getScreen().stopScreen();

    }
    
    public void addButton(){
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
}
