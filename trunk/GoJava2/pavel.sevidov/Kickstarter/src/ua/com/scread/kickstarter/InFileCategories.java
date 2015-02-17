package ua.com.scread.kickstarter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InFileCategories implements Categories {
    BufferedWriter out;
    private String fileName;
    
    public InFileCategories(String fileName) {
        this.fileName = fileName;
        try {
            
            out = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public void add(Category category) {
        try {
            out.write(category.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e1) {
                    // TODO не закрыли стрим
                }
            }
        }
    }

    @Override
    public int size() {
        int counter = -1;
        BufferedReader in = null;
        String line = "";
        try {
            in = new BufferedReader(new FileReader(fileName));
            do {
                counter++;
                line = in.readLine();
            } while(line != null);
                
        } catch (IOException e) {
            // TODO не смог найти файл или прочитать строку
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                    // TODO не закрыли стрим
                }
            }
        }
        return counter;
    }

    @Override
    public List<Category> getCategories() {
        int counter = 0;
        BufferedReader in = null;
        String line = "";
        List<Category> result = new ArrayList<Category>();
        try {
            in = new BufferedReader(new FileReader(fileName));
            do {
                line = in.readLine();
                if (line != null) {
                    result.add(new Category(line));                    
                }
                counter++;
            } while(line != null);
                
        } catch (IOException e) {
            // TODO не смог найти файл или прочитать строку
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                    // TODO не закрыли стрим
                }
            }
        }
        return result;
    }

    @Override
    public Category getCategory(int index) {
        int counter = 0;
        BufferedReader in = null;
        String line = "";
        Category result = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            do {
                line = in.readLine();
                if (counter == index) {
                    result = new Category(line);
                }
                counter++;
            } while(line != null);
                
        } catch (IOException e) {
            // TODO не смог найти файл или прочитать строку
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                    // TODO не закрыли стрим
                }
            }
        }
        return result;
    }

    @Override
    public String[] getStringCategories() {
        List<Category> categories = new ArrayList<Category>();
        categories.addAll(getCategories());
        String[] result = new String[categories.size()];
        for (int i = 0; i < categories.size(); i++) {
            result[i] = String.valueOf(i+1) + " - " + categories.get(i).getName();
        }
        return result;
    }

}
