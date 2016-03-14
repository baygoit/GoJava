package com.goit.file;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by roman on 13.03.16.
 */
public class Categories {
    public  ArrayList<String> categoriesWhisFileList = new ArrayList<String>();
    public void getCategories  () {

        BufferedReader reader = null;
        String thisLine = null;

        try {
            reader = new BufferedReader(new FileReader("src/com/goit/file/Sourses/Categories.txt"));
            while ((thisLine = reader.readLine()) != null) {
                categoriesWhisFileList.add(thisLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(categoriesWhisFileList);

    }
    public String getChoosCategori (int a) {
        return categoriesWhisFileList.get(a);

    }





}
