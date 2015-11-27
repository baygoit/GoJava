package ua.com.goit.gojava7.salivon.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.dao.CategoryDao;
import ua.com.goit.gojava7.salivon.dao.PathFile;

public class CategoryDaoFileImp implements CategoryDao {

    @Override
    public List<Category> getAllCategories() {

        List<Category> categories = new ArrayList<>();
        File file = new File(PathFile.CATEGORY.getPath());
        String category = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((category = br.readLine()) != null) {
                String[] arr = category.split("[|]");
                int id = Integer.parseInt(arr[0].trim());
                String name = arr[1].trim();
                categories.add(new Category(name, id));
            }

        } catch (IOException ex) {
            Logger.getLogger(CategoryDaoFileImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    @Override
    public Category getCategory(int idCategory) {
        Category requestedCategory = null;
        File file = new File(PathFile.CATEGORY.getPath());
        String category = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((category = br.readLine()) != null) {
                String[] arr = category.split("[|]");
                int id = Integer.parseInt(arr[0].trim());
                String name = arr[1].trim();
                if (id == idCategory) {
                    requestedCategory = new Category(name, id);
                    break;
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(CategoryDaoFileImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requestedCategory;
    }

}
