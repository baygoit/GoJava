package com.Homework3;

import java.io.FileNotFoundException;

/**
 * Created by roman on 07.03.16.
 */
public class KickStarterRunner {



    public static void main(String[] args) throws FileNotFoundException {


        while (true) {
        Category category1 = new Category("IT");
        Category category2 = new Category("Cars");
        Category category3 = new Category("Electricity");

        Categories categories = new Categories();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        Progect progect1 = new Progect("IT/ Start UP 1 -", 10000, 40, "Описание Sart UP 1", "http://youtobe/ksdfgh");
        Progect progect2 = new Progect("IT/ Start UP 2 -", 20000, 30, "Описание Sart UP 2", "http://youtobe/ksdfgh");
        Progect progect3 = new Progect("IT/ Start UP 3 -", 30000, 20, "Описание Sart UP 3", "http://youtobe/ksdfgh");
        Progect progect4 = new Progect("IT/ Start UP 4 -", 40000, 10, "Описание Sart UP 4", "http://youtobe/ksdfgh");

        progect1.setCategory(category1);
        progect2.setCategory(category1);
        progect3.setCategory(category1);
        progect4.setCategory(category1);


        Progects progects = new Progects();
        progects.add(progect1);
        progects.add(progect2);
        progects.add(progect3);
        progects.add(progect4);

        KickStarter aplication = new KickStarter(categories, progects);

        progect1.setHistory("история проекта №1");
        progect2.setHistory("история проекта №2");
        progect3.setHistory("история проекта №3");
        progect4.setHistory("история проекта №4");

        progect1.setQuestionAnswers("Q: Вопрос к проекту №1\n"
                                    + "A: Ответ на вопрос к проекту №1 ");
        progect2.setQuestionAnswers("Q: Вопрос к проекту №2\n"
                + "A: Ответ на вопрос к проекту №2 ");
        progect3.setQuestionAnswers("Q: Вопрос к проекту №3\n"
                + "A: Ответ на вопрос к проекту №3 ");
        progect4.setQuestionAnswers("Q: Вопрос к проекту №4\n"
                + "A: Ответ на вопрос к проекту №4 ");

        aplication.run();
        }
    }
}
