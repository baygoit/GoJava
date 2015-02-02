package com.gojava.input;

import com.gojava.projects.Category;
import com.gojava.projects.Project;

public class Out {
    public String output(String in) {
        return in;
    }
    
    public String output(String string, String string2) {
        return string + string2;
    }
    
    public String output(String string, int i) {
        return string + i;
    }
    
//    public Category output(Category category) {
//        return category;
//    }
    
    public String output(int i, String string) {
        return i + string;
    }
    
    
    public void print(String  string ){
        System.out.println(string);
    }
    
    public void printProjectPreview(Project project)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("Project Name: ").append(project.getName()).append("\n");
        sb.append("Description: ").append(project.getDescription()).append("\n");
        // out.print(out.output("Need Sum: ", project.getNeedSum()));
        // out.print(out.output("Current Sum: ", project.getCurrentSum()));
        // out.print(out.output("Days Left: ", project.getDaysLeft()));
        System.out.println(sb.toString());
        
    }
}
