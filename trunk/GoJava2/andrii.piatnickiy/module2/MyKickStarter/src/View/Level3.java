package View;

import com.gojava.projects.ProjectManager;

public class Level3 implements Level {
    Menu menu;
    ProjectManager manager;
    int position = 3;

    public Level3(ProjectManager manager, Menu menu) {
        this.manager = manager;
        this.menu = menu;
    }

    @Override
    public void displayMySelf(int nubberForNextLevel) {
        manager.displaySpecificProject(menu.parrentLevelPositon,
                nubberForNextLevel);
    }

    @Override
    public int getPosition() {
        return position;
    }

}
