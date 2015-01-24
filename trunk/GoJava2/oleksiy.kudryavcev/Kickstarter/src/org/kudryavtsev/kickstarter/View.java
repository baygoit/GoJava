package org.kudryavtsev.kickstarter;

import java.util.List;

public class View {
    private String greeting;

    public View() {
        greeting = "Лучший способ предвидеть будущее - это самим создать его.";
    }

    public void show() {
        System.out.println(greeting);
    }

    public void showCategories(List<String> list) {
        System.out.println("Categories (type the number to select one, 0 - exit): ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + list.get(i));
        }
    }

    public void showCategories(int i, List<String> list) {
        System.out.println("(" + (i + 1) + ") " + list.get(i));
    }
}
