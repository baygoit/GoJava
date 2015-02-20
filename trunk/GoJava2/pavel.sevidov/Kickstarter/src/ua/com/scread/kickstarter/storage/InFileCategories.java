package ua.com.scread.kickstarter.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.scread.kickstarter.data.Category;

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
    public Category get(int index) {
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
}
