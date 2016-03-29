
package com.vladik.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.vladik.model.Category;
import com.vladik.dao.AbstractCategoryDao;

public class CategoryDaoFileImpl extends AbstractCategoryDao {
    private static final File STORAGE_FILE = new File("./src/main/resources/categories.csv");
    private static final int CATEGORY_ID = 0;
    private static final int CATEGORY_NAME = 1;

    @Override
    public void add(Category element) {
        try (FileWriter fileWriter = new FileWriter(STORAGE_FILE, true)) {

            fileWriter.append(String.valueOf(element.getUniqueID()));
            fileWriter.append(SEMICOLON_DELIMITER);
            fileWriter.append(element.getName());
            fileWriter.append(NEW_LINE_SEPARATOR);

            fileWriter.flush();

        } catch (IOException e) {
            System.err.println("Error in CSVFileReader...");
        }
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        String line = "";

        try (BufferedReader fileReader = new BufferedReader(new FileReader(STORAGE_FILE))) {

            // read header
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(SEMICOLON_DELIMITER);

                if (tokens.length > 0) {
                    Category category = new Category();
                    category.setName(tokens[CATEGORY_NAME]);
                    category.setUniqueID(Integer.parseInt(tokens[CATEGORY_ID]));

                    categories.add(category);
                }
            }
        } catch (IOException e) {
            System.err.println("Error in CSVFileReader...");
        }
        return categories;
    }

    @Override
    public int getSize() {
        return getAll().size();
    }

    @Override
    public void remove(Category element) {
        // TODO Auto-generated method stub
    }
}
