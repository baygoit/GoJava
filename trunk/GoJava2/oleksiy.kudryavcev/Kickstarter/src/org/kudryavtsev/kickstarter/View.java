package org.kudryavtsev.kickstarter;

import java.util.ArrayList;
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

        List<String> categoryList = new ArrayList<String>();
        String insert = "";
        for (int i = 0; i < list.size(); i++) {
            insert = list.get(i).getCategory();
            if (!categoryList.contains(insert)) {
                categoryList.add(insert);
            }
        }
        for (int i = 0; i < categoryList.size(); i++) {
            System.out
                    .println("(" + (i + 1) + ") " + categoryList.get(i));
        }
    }

    public void showCategories(int i, List<Project> list) {
        System.out.println("(" + (i + 1) + ") " + list.get(i).getCategory());
    }

    public void showProjectsInCategory(List<Project> list, String category) {
        int counter = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCategory().equals(category)) {
                counter++;
                System.out.println("(" + counter + ") " + list.get(i));
            }
        }
    }
}
