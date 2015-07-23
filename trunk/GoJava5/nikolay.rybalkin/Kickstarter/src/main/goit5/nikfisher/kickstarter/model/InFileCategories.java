package goit5.nikfisher.kickstarter.model;


import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class InFileCategories implements Categories {

    private File file;

    public InFileCategories(String fileNme) {
        file = createNewFile(fileNme);
    }

    @Override
    public void add(Category category) {
        BufferedWriter out = null;

        try {
            out = new BufferedWriter(new FileWriter(file, true));
            out.append(category.getName() + "\n");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String[] getCategories() {

        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(file));

            List<String> result = new LinkedList<>();
            String line = in.readLine();
            int index = 1;
            while (line != null){
                result.add(index + ") " + line);
                line = in.readLine();
                index++;
            }
            return result.toArray(new String[0]);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new String[0];
    }

    @Override
    public Category get(int index) {
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(file));

            String line = in.readLine();
            int current = 0;
            while (line != null){
                if (current == index){
                    break;
                }
                line = in.readLine();
                current++;
            }
            return new Category(line);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
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
            String line;
            do{
                counter++;
                line = in.readLine();
            } while (line != null);
            return counter;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private File createNewFile(String fileNme) {
        File file = new File(fileNme);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
