package View;

import com.gojava.projects.ProjectManager;

public class Level2 implements Level {
    Menu menu;
    ProjectManager manager;
    int position = 2;
    int parentPosition;
    
    public Level2(ProjectManager manager, Menu menu) {
        this.manager = manager;
        this.menu = menu;
    }

    public void displayMySelf(int categoryNumber) {
        manager.displayProjects(categoryNumber);
    }
    
    public int initPosition(int currentPosition) {
        return currentPosition = position;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setParentPosition(int parentPosition) {
        this.parentPosition = parentPosition;
    }
    
    public int getParentPosition() {
        return parentPosition;
    }
}
