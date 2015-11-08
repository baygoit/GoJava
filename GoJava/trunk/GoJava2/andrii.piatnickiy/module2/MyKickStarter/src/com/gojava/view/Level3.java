package com.gojava.view;

import com.gojava.projects.ProjectStorage;

public class Level3 implements Level {
    private Menu menu;
    private int position = 3;
    private ProjectStorage projectStorage;

    public Level3(ProjectStorage projectStorage) {
        this.projectStorage = projectStorage;
    }

    @Override
    public String displayMySelf(int nubberForNextLevel) {
        String result = "";
        String specificProject = projectStorage.getSpecificProjectToString(
                menu.getCategoryPosition(), nubberForNextLevel);
        if (!specificProject.equals("")) {
            result = specificProject;
            for (int i = 0; i < menu.clientInteraction.interactions.size(); i++) {
                result += i
                        + 1
                        + ") "
                        + menu.clientInteraction.interactions.get(i)
                                .description() + "\n";
            }
        } else {
        }
        return result;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int getPosition() {
        return position;
    }

}
