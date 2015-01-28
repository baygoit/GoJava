package View;

import com.gojava.projects.ProjectManager;

public class Level1 implements Level {
    ProjectManager manager;
    Menu menu;
    int position = 1;

    public Level1(ProjectManager manager, Menu menu) {
        this.manager = manager;
        this.menu = menu;
    }

    public void displayMySelf(int currentPosition) {
        manager.displayCategories();
    }

    @Override
    public int getPosition() {
        return position;
    }

}
