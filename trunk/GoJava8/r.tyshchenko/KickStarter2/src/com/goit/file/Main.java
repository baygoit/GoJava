package com.goit.file;

import com.goit.file.SQL.CategoriesSQL;
import com.goit.file.SQL.QuotsSQL;

import java.util.Scanner;

public class Main {
    //Progect progect = new Progect();
    Categories categories = new Categories();

    public static void main(String[] args) {



        while (true) {
//           GetQuots quots = new GetQuots();
//            quots.quotesWhisFile();
//            ProgectFile progectFile = new ProgectFile();
//            progectFile.addProgects();
            QuotsSQL quotsSQL =new QuotsSQL();
            quotsSQL.getQuotsSQL();
            CategoriesSQL categoriesSQL = new CategoriesSQL();
            categoriesSQL.getCAtegoriesSQL();
            System.out.println();
            System.out.println("Chouse one of kategori  ");
            System.out.println();
            Categories categories = new Categories();
//            categories.getCategories();
            int menuIndex = getMenuIndex();
            System.out.println("you chose category - " +categories.getChoosCategori(menuIndex-1));
        }


    }

    public static int getMenuIndex() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
