package com.goit.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ProgectFile {

    private List<List<Progect>> categoriSListFile = new ArrayList<>();

    public void addProgects() {
        String filePath1 = "src/com/goit/file/Sourses/projects1.txt";
        String filePath2 = "src/com/goit/file/Sourses/projects2.txt";
        String filePath3 = "src/com/goit/file/Sourses/projects3.txt";
        categoriSListFile.add(getCategoryList1(filePath1));
        categoriSListFile.add(getCategoryList1(filePath2));
        categoriSListFile.add(getCategoryList1(filePath3));
    }

    public List<List<Progect>> getCategoriSListFile() {
        return categoriSListFile;
    }

    public List<Progect> getCategoryList1(String filePath) {
        BufferedReader reader = null;
        String thisLine;
        List<Progect> categoriList1 = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(filePath));

            while ((thisLine = reader.readLine()) != null) {
                Progect progect = new Progect();
                String[] projectParts = thisLine.split("#");
                progect.setNubberProject(Integer.valueOf(projectParts[0]));
                progect.setName(projectParts[1]);
                progect.setAmount(Integer.valueOf(projectParts[2]));
                progect.setDays(Integer.valueOf(projectParts[3]));
                progect.setDescription(projectParts[4]);
                progect.setGatheredBudget(Double.valueOf(projectParts[5]));
                progect.setHistory(projectParts[6]);
                progect.setDemoVideo(projectParts[7]);
                progect.setQuestionAnswers(projectParts[8]);

                categoriList1.add(progect);
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
        return categoriList1;
    }
}
