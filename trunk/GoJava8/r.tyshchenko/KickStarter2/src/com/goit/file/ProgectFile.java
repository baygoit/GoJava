package com.goit.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by roman on 14.03.16.
 */
public class ProgectFile {
//    private static final String ENTITY_SEPARATOR = "#";
//    private String projectsFileName = "src/com/goit/file/Sourses/progects.txt";
//
//
//    //public ProgectFile(String categoriesFileName) {
//        //this.projectsFileName = categoriesFileName;
//    //}
//    void addProgects() {
////        Progect progect = new Progect();
////        Categories categories = new Categories();
//        ArrayList a = new ArrayList();
//        try (BufferedReader is = new BufferedReader(new FileReader(projectsFileName))) {
//            String line;
//            while ((line = is.readLine()) != null) {
//                String[] projectParts = line.split(ENTITY_SEPARATOR);
//                a.add(projectParts);
//                System.out.println(a);
//
////                //project.setId(Integer.valueOf(projectParts[0]));
////                progect.setName(projectParts[2]);
////                progect.setDescription(projectParts[3]);
////               // project.setRequiredSum(Integer.valueOf(projectParts[4]));
////               // project.setDaysLeft(Integer.valueOf(projectParts[5]));
////                progect.setHistory(projectParts[6]);
////               // project.setVideoUrl(projectParts[7]);
////               // project.setRewardInfo(projectParts[8]);
////                for (Categories categories  : categories.categoriesWhisFileList) {
////                    if (String.valueOf(projectParts[1]).equals(categories.categoriesWhisFileList())) {
////                        categories.addProgect(progect);
////                    }
////                }
//            }
//        } catch (IOException e) {
//           // categories.clear();
//         //   throw new IllegalStateException("Cannot read projects from file");
//        }
//        //addProgects();
//    }
//}


//public class Main {
//

    public  void addProgects () {
        Progect progect = new Progect();
        BufferedReader reader = null;
        String thisLine = null;
        //List<Progect> projects = new ArrayList<>());
        List<Progect> progects = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader("src/com/goit/file/Sourses/projects1.txt"));
            while ((thisLine = reader.readLine()) != null) {
                String[] projectParts = thisLine.split("#");
                progect.setNubberProject(Integer.valueOf(projectParts[0]));
                progect.setName(projectParts[1]);
                progect.setAmount(Integer.valueOf(projectParts[2]));
                progect.setDays(Integer.valueOf(projectParts[3]));
                progect.setDescription(projectParts[4]);
                progect.setDemoVideo(projectParts[5]);
                progects.add(progect);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
           // System.out.println("test");
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
        System.out.println(progects);
    }
}
