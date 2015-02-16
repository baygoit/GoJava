package com.gojava.projects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCategoryStorage implements CategoryStorage {
    File file;
    BufferedReader in = null;
    BufferedWriter out = null;

    public FileCategoryStorage(String fileName) {
        file = createFileIfNeed(fileName);
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

    private void initOut() {
        try {
            out = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            throw new RuntimeException("Не могу записать в файл!", e);
        }
    }

    @Override
    public String getCategoryToString() {
        String result = "";
        initIn();
        try {
            try {
                String read = "";
                while (read != null) {
                    read = in.readLine();
                    if (read == null) {
                        result += "";
                    } else {
                        result += read + "\n";
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("Не могу прочитать строку!", e);
            }
            return result;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException("Не можем закрыть файл!", e);
                }
            }
        }
    }

    @Override
    public Category getCategory(int index) {
        initIn();
        Category category = null;
        try {
            try {
                int counter = 0;
                String read = "";
                try {
                    read = in.readLine();
                } catch (NullPointerException e) {
                    throw new RuntimeException("Тут null!!!", e);
                }
                String result = "";
                while (read != null) {
                    if (counter == index) {
                        result = read;
                        String[] tmp = result.split(";");
                        int id = Integer.parseInt(tmp[0]);
                        String name = tmp[1];
                        category = new Category(name, id);
                        return category;
                    }
                    counter++;
                }
            } catch (IOException e) {
                throw new RuntimeException("Не можем прочитать файл!", e);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException("Не можем закрыть файл!", e);
                }
            }
        }
        return category;
    }

    private File createFileIfNeed(String filename) {
        File file = new File(filename);
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
            // TODO Auto-generated catch block
            try {
                file.createNewFile();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                throw new RuntimeException("Не смогли создать файл!", e);
            }
        }
    }
}
