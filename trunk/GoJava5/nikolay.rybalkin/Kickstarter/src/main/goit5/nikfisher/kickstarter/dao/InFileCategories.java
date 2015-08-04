package goit5.nikfisher.kickstarter.dao;

import goit5.nikfisher.kickstarter.model.Category;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class InFileCategories implements Categories {

    private File file;

    public InFileCategories(String fileName) {
        file = createNewFile(fileName);
    }

    @Override
    public void add(Category category) {

//        BufferedWriter out = null;
//        try {
//            out = new BufferedWriter(new FileWriter(file, true));
//            out.append(category.getName()).append("\n");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                assert out != null;
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @Override
    public List<String> getCategories() {

        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(file));

            List<String> result = new LinkedList<>();
            String line = in.readLine();
            int index = 1;
            while (line != null) {
                result.add(index + ") " + line);
                line = in.readLine();
                index++;
            }
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert in != null;
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Category get(int index) {
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(file));

            String line = in.readLine();
            int current = 0;
            while (line != null) {
                if (current == index) {
                    break;
                }
                line = in.readLine();
                current++;
            }
            return new Category(line);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert in != null;
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int size() {

        BufferedReader in = null;

        try {

            in = new BufferedReader(new FileReader(file));

            int counter = 0;
            String line = in.readLine();
            while (line != null) {
                line = in.readLine();
                counter++;
            }
            return counter;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert in != null;
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private File createNewFile(String fileNme) {
        File file = new File(fileNme);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
