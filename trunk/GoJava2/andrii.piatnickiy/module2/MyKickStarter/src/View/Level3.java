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
    
//    public void displaySpecificProject(int categoryNumber, int projectNumber) {
//        projectStorage.displaySpecificProject(categoryNumber, projectNumber);
//    }
//  nubberForNextLevel == project
    @Override
    public void displayMySelf(int nubberForNextLevel) {
        System.out.println("menu.parrentLevelPositon = " + menu.parrentLevelPositon);
        System.out.println();
        manager.displaySpecificProject(menu.parrentLevelPositon, nubberForNextLevel);
//        manager.displaySpecificProject(1, 2);

    }

    @Override
    public int getPosition() {
        return position;
    }

}
