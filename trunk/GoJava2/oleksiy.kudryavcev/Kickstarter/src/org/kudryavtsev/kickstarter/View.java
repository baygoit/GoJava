package org.kudryavtsev.kickstarter;

import java.util.List;

public class View {
    private String greeting;

    public View() {
        // System.out.println("View created");
        greeting = "Лучший способ предвидеть будущее - это самим создать его.";
    }

    public void show() {
        System.out.println(greeting);
    }

    public void showCategories(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + list.get(i));
        }
    }

}
