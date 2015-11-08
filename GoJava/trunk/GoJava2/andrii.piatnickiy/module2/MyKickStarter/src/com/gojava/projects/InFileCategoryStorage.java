package com.gojava.projects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InFileCategoryStorage implements CategoryStorage {
    File file;
    private BufferedReader in = null;
    private BufferedWriter out = null;
    private ArrayList<Category> categoriesList = new ArrayList<Category>();

    public InFileCategoryStorage(String fileName) {
        file = new File(fileName);
        if (file.length() != 0) {
            file.delete();

        }
        file = createFileIfNeed(fileName);

        getCategoriesFromFileToList();
    }

    @Override
    public void add(String name, int categoryId) {
        try {
            initOut();
            try {
                out.append(String.valueOf(categoryId) + ";" + name + "\n");
            } catch (IOException e) {
                throw new RuntimeException("Не могу записать строку!", e);
            }

        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException("Не можем закрыть файл!", e);
                }
            }
        }
    }

    @Override
    public String getCategoryToString() {
        StringBuffer sb = new StringBuffer();
        for (Category category : categoriesList) {
            sb.append(category.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Category getCategory(int index) {
        return categoriesList.get(index);
    }

    // TODO избавится от кеширования. сделать напрямую чтение из файла.
    public ArrayList<Category> getCategoriesFromFileToList() {
        initIn();
        Category category;
        try {
            try {
                String read;
                read = in.readLine();
                // TODO Null!!! Why??
                while (read != null) {
                    category = parseLineToCategory(read);
                    categoriesList.add(category);
                    read = in.readLine();
                }
            } catch (IOException e) {
                throw new RuntimeException("Не могу прочитать строку!", e);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException("Не можем закрыть файл!", e);
                }
            }
        }
        return categoriesList;
    }

    private Category parseLineToCategory(String read) {
        String result = read;
        String[] tmp = result.split(";");
        int id = Integer.parseInt(tmp[0]);
        String name = tmp[1];
        Category category = new Category(name, id);
        return category;
    }

    private void initOut() {
        try {
            out = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            throw new RuntimeException("Не могу записать в файл!", e);
        }
    }

    private File createFileIfNeed(String fileName) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Не смогли создать файл контейнер!",
                        e);
            }
        }
        return file;
    }

    private void initIn() {
        try {
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                throw new RuntimeException("Не смогли создать файл!", e);
            }
        }
    }

    @Override
    public ArrayList<Category> getList() {
        return categoriesList;
    }
}
