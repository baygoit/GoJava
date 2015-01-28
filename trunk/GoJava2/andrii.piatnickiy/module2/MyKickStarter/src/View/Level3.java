package View;

import com.gojava.projects.ProjectManager;

public class Level3 implements Level {
    Menu menu;
    ProjectManager manager;
    int position = 3;
    public int parentPosition;
    public void setParentPosition(int parentPosition) {
        this.parentPosition = parentPosition;
    }

    

    public Level3(ProjectManager manager, Menu menu) {
        this.manager = manager;
        this.menu = menu;
    }


    public int initPosition(int currentPosition) {
        return currentPosition = position;
    }

    @Override
    public void displayMySelf(int projectNumber) {
        manager.displaySpecificProject(this.parentPosition, projectNumber);

    }

    @Override
    public int getPosition() {
        return position;
    }
    
    public int getParentPosition() {
        return parentPosition;
    }
}
