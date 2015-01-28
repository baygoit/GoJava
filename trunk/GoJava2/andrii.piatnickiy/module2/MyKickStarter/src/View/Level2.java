package View;

import com.gojava.projects.ProjectManager;

public class Level2 implements Level {
    Menu menu;
    ProjectManager manager;
    int position = 2;
    
    public Level2(ProjectManager manager, Menu menu) {
        this.manager = manager;
        this.menu = menu;
    }
    
    public void displayMySelf(int categoryNumber) {
        manager.displayProjects(categoryNumber);
    }


    @Override
    public int getPosition() {
        return position;
    }

}
