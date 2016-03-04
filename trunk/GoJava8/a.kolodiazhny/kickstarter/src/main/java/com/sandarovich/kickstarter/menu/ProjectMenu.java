package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.category.Categories;
import com.sandarovich.kickstarter.io.IO;
import com.sandarovich.kickstarter.project.Project;
import com.sandarovich.kickstarter.project.Projects;

/**
 * @author Olexamder Kolodiazhny 2016
 */


public class ProjectMenu extends AbstractMenu {

    private Projects fileredProjects;

    public ProjectMenu(IO console, Categories categories, Projects projects, Projects filteredProjects) {
        super(console, categories, projects);
        this.fileredProjects = filteredProjects;
        menuId = 3;
        headerLabel = "Projects:";
        int projectCount = fileredProjects.count();
        this.menuElements = new MenuElement[projectCount + 1];

        if (projectCount != 0) {
            for (int index = 0; index < projectCount; index++) {
                Project fp = fileredProjects.get(index);
                menuElements[index + MENU_SHIFT] = new MenuElement(fp.toString(),
                        Actions.SHOW_PROJECT,
                        fp.getId());
            }

        }
        menuElements[0] = new MenuElement("Exit", Actions.EXIT, 0);
    }

    @Override
    public void show() {
        showMenuHeader();
        showProjectsTable(fileredProjects);
        showMenuElements();
        showMenuFooter();
    }

    private void showProjectsTable(Projects projects) {
        console.writeTable(projects);
    }

    @Override
    public void performAction(int choice) {
        Actions action = getAction(choice);

        if (action != null && action == Actions.EXIT) {
            showCategoriesMenu();
        }

        if (action != null && action == Actions.SHOW_PROJECT) {
            showProjectDetailsMenu(choice);
        }

    }


}
