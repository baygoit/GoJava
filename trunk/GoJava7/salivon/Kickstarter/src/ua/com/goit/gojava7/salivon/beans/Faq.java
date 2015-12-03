package ua.com.goit.gojava7.salivon.beans;

public class Faq {

    private int idProject;
    private String context;

    public Faq(int idProject, String context) {
        this.idProject = idProject;
        this.context = context;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

}
