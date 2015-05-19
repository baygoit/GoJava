package com.morkva;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.entities.Quote;
import com.morkva.logic.*;
import com.morkva.model.impl.CategoryRepository;
import com.morkva.model.impl.QuoteRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vladyslav on 07.05.15.
 */
public class Main {

    static List<Category> defaultCategories = new ArrayList<>(Arrays.asList(
            new Category(1, "Software"),
            new Category(2, "Video"),
            new Category(3, "Games")
    ));

    static List<Project> softwareCategoryProjects = new ArrayList<>(Arrays.asList(
            new Project(1, "Instant Messenger Qip", "A very tiny instant messenger for all Platforms and IE6", 50000, 37000, 5, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(2, "Kickstarter", "One more kickstarter", 100, 5, 31, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(3, "Global IT forum", "IT forum for all planet and our solar system", 5, 2, 100, "History of the project", "http://youtube.com/kdjh1231")
    ));

    static List<Project> videoCategoryProjects = new ArrayList<>(Arrays.asList(
            new Project(4, "Avengers 16", "New avengers from IT developers", 500, 0, 128, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(5, "Avatar 32", "New blue people from blue planet with blue scenario, not gay", 59999000, 49999000, 256, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(6, "Batmen 64", "Need anoter one actor for batman, not gay", 699, 3, 512, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(7, "Superman 1024", "History of a developer from Crypton", 600000, 4500, 1024, "History of the project", "http://youtube.com/kdjh1231")
    ));

    static List<Project> gamesCategoryProjects = new ArrayList<>(Arrays.asList(
            new Project(8, "256-bit mario", "New mario for Oculus Rift", 3000, 0, 60, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(9, "Quake 2.5", "Doom is too boring", 10000, 500, 31, "History of the project", "http://youtube.com/kdjh1231"),
            new Project(10, "CS 3.14", "New counter strike from ukrainian developers (need money for beer)", 100, 0, 3, "History of the project", "http://youtube.com/kdjh1231")

    ));

    static List<Quote> defaultQuotes = new ArrayList<>(Arrays.asList(
            new Quote(1, "Test Quote", "Test author"),
            new Quote(2, "«Пользователь» — слово, используемое компьютерщиками-профессионалами вместо слова «идиот».", "Дейв Барри"),
            new Quote(3, "Каждый дурак может написать программу, которую может понять компьютер. Хороший программист пишет программу, которую может понять человек.", "Мартин Фаулер"),
            new Quote(4, "Написание первых 90% программы занимает 90% времени. Оставшиеся 10% также требуют 90% времени, а окончательная шлифовка — еще 90% времени.", "Нейл Рубенкинг"),
            new Quote(5, "Программирование — это гонка между компьютерщиками, которые создают программы, все лучше защищенные от дурака, и природой, которая создает все лучших дураков. Пока что природа выигрывает.", "Рич Кук")

    ));

    public static void main(String[] args) throws IOException {

        defaultCategories.get(0).setProjects(softwareCategoryProjects);
        defaultCategories.get(1).setProjects(videoCategoryProjects);
        defaultCategories.get(2).setProjects(gamesCategoryProjects);

        Printer printer = new ConsolePrinter();
        Reader reader = new ConsoleReader();
        KickstarterApp app = new KickstarterApp(printer, reader);
        app.setQuoteRepository(new QuoteRepository(defaultQuotes));
        app.setCategoryRepository(new CategoryRepository(defaultCategories));
        app.run();
    }
}
