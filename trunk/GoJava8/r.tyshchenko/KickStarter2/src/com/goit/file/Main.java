package com.goit.file;

import com.goit.file.SQL.CategoriesSQL;
import com.goit.file.SQL.QuotsSQL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Progect progect = new Progect();
    //Categories categories = new Categories();

    public static void main(String[] args) {


        while (true) {
//           GetQuots quots = new GetQuots();
//            quots.quotesWhisFile();
//            Categories categories = new Categories();
//            categories.getCategories();

            QuotsSQL quotsSQL = new QuotsSQL();
            quotsSQL.getQuotsSQL();
            System.out.println();
            CategoriesSQL categoriesSQL = new CategoriesSQL();
            categoriesSQL.getCAtegoriesSQL();
            System.out.println();
            System.out.println("Chouse one of kategori  ");
            System.out.println();
            int menuIndex = getMenuIndex();
            System.out.println("You chose category - " + categoriesSQL.getChoosCatSQL(menuIndex - 1));
            System.out.println();


            ProgectFile progectFile = new ProgectFile();
            progectFile.addProgects();
            List<Progect> progects = progectFile.getCategoriSListFile().get(menuIndex - 1);
            while (true) {
                System.out.println(progects);
                //while (true) {
                System.out.println();
                System.out.println("Chouse one of projects or enter 0 to EXIT");
                System.out.println();
                int menuProjectIndex = getMenuIndex();
                if (menuProjectIndex == 0) {
                    break;
                }
                while (true) {
                    Progect progect = new Progect();
                    progect = progects.get(menuProjectIndex - 1);
                    System.out.println("You chose project - " + progect.getName());
                    System.out.println(progect.toString() + "demo video- " + progect.getDemoVideo() + "History - " + progect.getHistory() + "Questions Ansqer " + progect.getQuestionAnswers());
                    System.out.println("1 - INVEST \n2 - Ask a questions \n0 - exit");
                    int menuDetalsProjectIndex = getMenuIndex();
                    if (menuDetalsProjectIndex == 0) {
                        break;
                    }
                    Scanner scanner = new Scanner(System.in);
                    if (menuDetalsProjectIndex == 1) {
                        System.out.println("input card holder name");
                        //Scanner scanner = new Scanner(System.in);
                        String cardHolderName = scanner.nextLine();
                        System.out.println("input card number");
                        String cardNumber = scanner.nextLine();
                        // System.out.println(cardHolderName+ " "+ cardNumber);
                        System.out.println("input amount");
                        progect.setGatheredBudget(progect.getGatheredBudget() + scanner.nextDouble());
                    }
                    if (menuDetalsProjectIndex == 2) {
                        System.out.println("Ask your questions");
                        progect.setQuestionAnswers(scanner.nextLine());

                    }
                    }

                }
            }
        }

    public static int getMenuIndex() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
