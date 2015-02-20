package ua.com.scread.kickstarter.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.scread.kickstarter.data.Category;
import ua.com.scread.kickstarter.data.FAQ;
import ua.com.scread.kickstarter.data.Project;

public class InFileProjects implements Projects {
    BufferedWriter out;
    private String fileName;
    
    public InFileProjects(String fileName) {
        this.fileName = fileName;
        try {
            
            out = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> getProjects() {
        int counter = 0;
        BufferedReader in = null;
        String line = "";
        List<Project> result = new ArrayList<Project>();
        try {
            in = new BufferedReader(new FileReader(fileName));
            do {
                line = in.readLine();
                if (line != null) {
                    String[] splitted = line.split(";:");
                    String[] faqString = splitted[2].split(";");
                    FAQs faqs = new FAQs();
                    for(int i = 0; i < faqString.length; i += 2) {
                        faqs.add(new FAQ(faqString[i], faqString[i + 1]));
                    }
                    //result.add(new Project(line));                    
                }
                counter++;
            } while(line != null);
                
        } catch (IOException e) {
            // TODO не смог найти файл или прочитать строку
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                    // TODO не закрыли стрим
                }
            }
        }
        return result;
    }

    @Override
    public List<Project> getProjects(Category category) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(Project project) {
        try {
            out.write(project.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e1) {
                    // TODO не закрыли стрим
                }
            }
        }
    }

    @Override
    public int size() {
        int counter = -1;
        BufferedReader in = null;
        String line = "";
        try {
            in = new BufferedReader(new FileReader(fileName));
            do {
                counter++;
                line = in.readLine();
            } while(line != null);
                
        } catch (IOException e) {
            // TODO не смог найти файл или прочитать строку
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                    // TODO не закрыли стрим
                }
            }
        }
        return counter;
    }

}
