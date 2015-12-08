package ua.com.goit.gojava7.salivon.beans;

public class Payment {

    private int idProject;
    private String namePayer;
    private long numberCard;
    private int total;

    public Payment(int idProject) {
        this.idProject = idProject;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getNamePayer() {
        return namePayer;
    }

    public void setNamePayer(String namePayer) {
        this.namePayer = namePayer;
    }

    public long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(long numberCard) {
        this.numberCard = numberCard;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
