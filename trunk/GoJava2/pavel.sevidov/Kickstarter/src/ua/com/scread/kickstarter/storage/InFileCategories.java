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
    private String fileName;
    
    public InFileCategories(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public void add(Category category) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName))){
            out.write(category.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        int counter = -1;
        String line = "";
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))){
            do {
                counter++;
                line = in.readLine();
            } while(line != null);
                
        } catch (IOException e) {
            // TODO не смог найти файл или прочитать строку
        }
        return counter;
    }

    @Override
    public List<Category> getCategories() {
        String line = "";
        List<Category> result = new ArrayList<Category>();
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))){
            do {
                line = in.readLine();
                if (line != null) {
                    result.add(new Category(line));                    
                }
            } while(line != null);
                
        } catch (IOException e) {
            // TODO не смог найти файл или прочитать строку
        }
        return result;
    }

    @Override
    public Category get(int index) {
        int counter = 0;
        String line = "";
        Category result = null;
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            do {
                line = in.readLine();
                if (counter == index) {
                    result = new Category(line);
                }
                counter++;
            } while(line != null);
                
        } catch (IOException e) {
            // TODO не смог найти файл или прочитать строку
        }
        return result;
    }
}
