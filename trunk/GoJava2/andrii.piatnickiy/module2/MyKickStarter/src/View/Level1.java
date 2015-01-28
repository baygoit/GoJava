package View;

import com.gojava.projects.ProjectManager;

public class Level1 implements Level {
    ProjectManager manager;
    Menu menu;
    int position = 1;
    int parentPosition;

    public int getParentPosition() {
        return parentPosition;
    }

    public Level1(ProjectManager manager, Menu menu) {
        this.manager = manager;
        this.menu = menu;
    }

    public void displayMySelf(int currentPosition) {
        manager.displayCategories();
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
}
