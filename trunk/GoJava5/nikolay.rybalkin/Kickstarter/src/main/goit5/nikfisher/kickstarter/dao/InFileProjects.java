package goit5.nikfisher.kickstarter.dao;

import goit5.nikfisher.kickstarter.model.Category;
import goit5.nikfisher.kickstarter.model.Project;

import java.io.*;
import java.util.List;

public class InFileProjects implements Projects {

    private File file;

    public InFileProjects(String fileName) {
        file = createNewFile(fileName);
    }

    @Override
    public void add(Project project) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file, true));
            out.append(project.getName()).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Project> getProjects(Category category) {
//
//        BufferedReader in = null;
//
//
//        try {
//            in = new BufferedReader(new FileReader(file));
//
//
//
//            int found = 0;
//
//            for (int i = 0; i < index; i++) {
//                Project project = PROJECTS.get(i);
//
//                if (project.getCategory().equals(category)) {
//                    result.add(found, project);
//                    found++;
//                }
//            }
//
//            return result;
//
//
//
//
//            List<Project> result = new ArrayList<>();
//            String line = in.readLine();
//            int found = 0;
//
//            while (line != null){
//                Project project = line.get(1);
//
//                project.getCategory();
//
//                result.add(index, project);
//                if (project.getCategory().equals(category)){
//                    result.add(index, project);
//                    index++;
//                }
//            }

//            return result;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                assert in != null;
//                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        return null;
    }

    @Override
    public Project get(int index) {
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
            return new Project(line);

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
