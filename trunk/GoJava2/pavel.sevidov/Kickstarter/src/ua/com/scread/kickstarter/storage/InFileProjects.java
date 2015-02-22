package ua.com.scread.kickstarter.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.scread.kickstarter.data.AdditionalInfo;
import ua.com.scread.kickstarter.data.Bonus;
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
        BufferedReader in = null;
        String line = "";
        List<Project> result = new ArrayList<Project>();
        try {
            in = new BufferedReader(new FileReader(fileName));
            do {
                line = in.readLine();
                if (line != null) {
                    String[] splitted = line.split(";:");
                    String[] faqLine = splitted[2].split(";");
                    FAQs faqs = new FAQs();
                    for(int i = 0; i < faqLine.length - 1; i += 2) {
                        faqs.add(new FAQ(faqLine[i], faqLine[i + 1]));
                    }
                    String[] bonusesLine = splitted[1].split(";");
                    Bonuses bonuses = new Bonuses();
                    for(int i = 0; i < bonusesLine.length - 1; i += 2) {
                    	bonuses.add(new Bonus(Double.parseDouble(bonusesLine[i]), bonusesLine[i + 1]));
                    }
                    String[] progectLine = splitted[0].split(";");
                    String name = progectLine[0];
                    String description = progectLine[1];
                    Double collected = Double.parseDouble(progectLine[2]);
                    Double amount = Double.parseDouble(progectLine[3]);
                    Integer days = Integer.parseInt(progectLine[4]);
                    String history = progectLine[6];
                    String video = progectLine[7];
                    Project project = new Project(name, description, collected, amount, days, new AdditionalInfo(history, video, bonuses, faqs));
                    if (progectLine[5] != "NO_CATEGORY") {
                    	project.setCategory(new Category(progectLine[5]));                    	
                    } else {
                    	// do nothing
                    }
                    result.add(project);                    
                }
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
    	List<Project> projects = getProjects();
    	List<Project> result = new ArrayList<Project>();
        for (int index = 0; index < projects.size(); index ++) {
                Project project = projects.get(index);
                if (project.getCategory().equals(category)) {
                        result.add(project);
                }
        }
        return result;
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
