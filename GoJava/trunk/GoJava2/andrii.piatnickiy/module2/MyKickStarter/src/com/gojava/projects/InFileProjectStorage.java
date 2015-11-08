package com.gojava.projects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InFileProjectStorage implements ProjectStorage {
    File file;
    private BufferedReader in = null;
    private BufferedWriter out = null;
    private ArrayList<Project> projectList = new ArrayList<Project>();

    public InFileProjectStorage(String fileName) {
        file = new File(fileName);
        if (file.length() != 0) {
            file.delete();

        }
        file = createFileIfNeed(fileName);


        getProjectsFromFileToList();

    }

    public ArrayList<Project> getProjectsFromFileToList() {
        initIn();
        Project project;
        try {
            try {
                String read;
                read = in.readLine();
                while (read != null) {
                    project = parseLineToProject(read);
                    projectList.add(project);
                    read = in.readLine();
                }

            } catch (IOException e) {
                throw new RuntimeException("Не могу прочитать строку!", e);
            }

        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException("Не можем закрыть файл!", e);
                }
            }
        }
        return projectList;
    }

    private Project parseLineToProject(String read) {
        Project project;
        String result;
        result = read;
        String[] tmp = result.split(";");

        for (int i = 0; i < tmp.length; i++) {
        }
        String name = tmp[0];
        String description = tmp[1];
        int needSum = Integer.parseInt(tmp[2]);
        int currentSum = Integer.parseInt(tmp[3]);
        int daysLeft = Integer.parseInt(tmp[4]);
        String projectHistory = tmp[5];
        String linkOnvideo = tmp[6];
        String questionsAndAnswers = tmp[7];
        int categoryId = Integer.parseInt(tmp[8]);

        project = new Project(name, description, needSum, currentSum, daysLeft,
                projectHistory, linkOnvideo, questionsAndAnswers, categoryId);
        return project;
    }

    private void initIn() {
        try {
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            try {
                file.createNewFile();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                throw new RuntimeException("Не смогли создать файл!", e);
            }
        }
    }

    private void initOut() {
        try {
            out = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            throw new RuntimeException("Не могу записать в файл!", e);
        }
    }

    private File createFileIfNeed(String filename) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Не смогли создать файл контейнер!",
                        e);
            }
        }
        return file;
    }

    @Override
    public void add(String name, String description, int needSum,
            int currentSum, int daysLeft, String projectHistory,
            String linkOnvideo, String questionsAndAnswers, int categoryId) {
        try {
            initOut();
            try {
                out.append(name + ";" + description + ";"
                        + String.valueOf(needSum) + ";"
                        + String.valueOf(currentSum) + ";"
                        + String.valueOf(daysLeft) + ";" + projectHistory + ";"
                        + linkOnvideo + ";" + questionsAndAnswers + ";"
                        + String.valueOf(categoryId) + "\n");
            } catch (IOException e) {
                throw new RuntimeException("Не могу записать строку!", e);
            }

        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException("Не можем закрыть файл!", e);
                }
            }
        }

    }

    @Override
    public Project getProject(int index) {
        return projectList.get(index);
    }

    @Override
    public Project getSpecificProject(int categoryNumber, int projectNumber) {
        int i = 1;
        for (Project project : projectList) {
            if (project.getCategoryId() == categoryNumber) {
                if (i == projectNumber) {
                    return project;
                }
                i++;
            }
        }
        return null;
    }

    @Override
    public String getAllToString(int categoryNumber) {
        StringBuffer sb = new StringBuffer();
        int i = 1;
        for (Project project : projectList) {
            if (project.getCategoryId() == categoryNumber) {
                sb.append(i).append(") ");
                sb.append(getprojectPreviewToString(project)).append("\n");
                i++;
            }
        }
        return sb.toString();
    }

    @Override
    public String getSpecificProjectToString(int categoryNumber,
            int projectNumber) {
        StringBuffer sb = new StringBuffer();
        int i = 1;
        for (Project project : projectList) {
            if (project.getCategoryId() == categoryNumber) {
                if (i == projectNumber) {
                    sb.append(allProjectFields(project)).append("\n");
                }
                i++;
            }
        }
        return sb.toString();
    }

    private String allProjectFields(Project project) {
        return getprojectPreviewToString(project)
                + getAdditionalProjectFields(project);
    }

    @Override
    public String getprojectPreviewToString(Project project) {
        StringBuffer sb = new StringBuffer();
        sb.append("Project Name: ").append(project.getName()).append("\n");
        sb.append("Description: ").append(project.getDescription())
                .append("\n");
        sb.append("Need Sum: ").append(project.getNeedSum()).append("\n");
        sb.append("Current Sum: ").append(project.getCurrentSum()).append("\n");
        sb.append("Days Left: ").append(project.getDaysLeft()).append("\n");
        return sb.toString();
    }

    @Override
    public String getAdditionalProjectFields(Project project) {
        StringBuffer sb = new StringBuffer();
        sb.append("ProjectHistory: ").append(project.getProjectHistory())
                .append("\n");
        sb.append("LinkOnvideo: ").append(project.getLinkOnvideo())
                .append("\n");
        sb.append("Questions and answers: ")
                .append(project.getQuestionsAndAnswers()).append("\n");
        return sb.toString();
    }

    @Override
    public ArrayList<Project> getList() {
        return projectList;
    }

}
