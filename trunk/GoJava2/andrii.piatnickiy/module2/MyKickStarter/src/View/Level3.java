package View;

import com.gojava.projects.ProjectManager;

public class Level3 implements Level {
    private Menu menu;
    private ProjectManager manager;
    private int position = 3;

    public Level3(ProjectManager manager, Menu menu) {
        this.manager = manager;
        this.menu = menu;
    }

    @Override
    public void displayMySelf(int nubberForNextLevel) {
        manager.displaySpecificProject(menu.categoryPosition,
                nubberForNextLevel);
    }

    @Override
    public int getPosition() {
        return position;
    }

}
