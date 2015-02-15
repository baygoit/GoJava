package com.gojava.projects;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileCategoryStorage implements CategoryStorage {

    @Override
    public void add(String name, int categoryId) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCategoryToString() {
        File file = new File("categories.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Не смогли создать файл контейнер!");
            }
        }
        
        BufferedReader in = null;
        String result = "";
        try {
            in = new BufferedReader(new FileReader(file));
            try {
                String firsrRead = "";
                while(firsrRead != null){
                    firsrRead = in.readLine();
                    if(firsrRead == null){
                        result += "";
                    }else{
                        result += firsrRead + "\n";
                    }
                }
            } catch (IOException e) {
                System.out.println("Не могу прочитать строку!");
            }
            return result;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            try {
                file.createNewFile();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                System.out.println("Не нашли файл!");
                ;
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("Не можем закрыть файл!");
                }
            }
        }
        return result;


    }

    @Override
    public Category getCategory(int index) {
        // TODO Auto-generated method stub
        return null;
    }

}
