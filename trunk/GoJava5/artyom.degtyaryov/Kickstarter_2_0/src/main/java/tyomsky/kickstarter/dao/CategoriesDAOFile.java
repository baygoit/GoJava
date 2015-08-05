package tyomsky.kickstarter.dao;

import tyomsky.kickstarter.model.Category;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAOFile implements CategoriesDAO {

    File file;

    public CategoriesDAOFile(String fileName) {
        this.file = findOrCreateFile(fileName);
    }

    @Override
    public int size() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line = fileReader.readLine();
            int counter = 0;
            while (line != null) {
                counter++;
                line = fileReader.readLine();
            }
            return counter;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file!");
        } catch (IOException e) {
            throw new RuntimeException("Something wrong with reading! Can't read from file");
        }
    }

    @Override
    public Category get(int index) {
        Category result = null;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            int counter = 0;
            String line = fileReader.readLine();
            while (line != null) {
                if (counter == index) {
                    result = new Category(line);
                }
                line = fileReader.readLine();
                counter++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file!");
        } catch (IOException e) {
            throw new RuntimeException("Something wrong with reading! Can't read from file");
        }
        return result;
    }

    @Override
    public List<Category> getAll() {
        List<Category> result = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line = fileReader.readLine();
            while (line != null) {
                result.add(new Category(line));
                line = fileReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file!");
        } catch (IOException e) {
            throw new RuntimeException("Something wrong with reading! Can't read from file");
        }
        return result;
    }

    @Override
    public void add(Category category) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true))) {
            fileWriter.write(category.getName()+"\n");
        } catch (IOException e) {
            throw new RuntimeException("Can't create file!");
        }
    }

    private File findOrCreateFile(String fileName) {
        File result = new File(fileName);
        if (!result.exists()) {
            try {
                result.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}
