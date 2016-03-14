package com.goit.file;

import java.util.Scanner;

public class Main {
    Progect progect = new Progect();
    Categories categories = new Categories();

    public static void main(String[] args) {



        while (true) {
            GetQuots quots = new GetQuots();
            quots.quotesWhisFile();
            System.out.println();
            System.out.println("Chouse one of kategori  ");
            System.out.println();
            Categories categories = new Categories();
            categories.getCategories();
            int menuIndex = getMenuIndex();
            System.out.println("you chose category - " +categories.getChoosCategori(menuIndex-1));
        }


    }

    public static int getMenuIndex() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
