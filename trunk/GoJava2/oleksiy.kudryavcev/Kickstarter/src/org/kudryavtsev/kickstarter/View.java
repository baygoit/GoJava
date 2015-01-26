package org.kudryavtsev.kickstarter;

import java.util.List;

public class View {
    private String greeting;

    public View() {
        greeting = "Лучший способ предвидеть будущее - это самим создать его.";
    }

    public void showGreeting() {
        System.out.println(greeting);
    }

    public void showCategories(List<Project> list) {
        System.out
                .println("Categories (type the number to select one, 0 - exit): ");
        for (int i = 0; i < list.size(); i++) {
            System.out
                    .println("(" + (i + 1) + ") " + list.get(i).getCategory());
        }
    }

    public void showCategories(int i, List<Project> list) {
        System.out.println("(" + (i + 1) + ") " + list.get(i).getCategory());
    }

    public void showProjectsInCategory(List<Project> list, String category) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals((String) category)) {
                System.out.println("(" + (i + 1) + ") " + list.get(i));
            }
        }
    }
}
