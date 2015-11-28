package ua.com.goit.gojava7.salivon.dao;

public enum PathFile {

    QUOTE("resource/quote.csv"),
    CATEGORY("resource/category.csv"),
    PROJECT("resource/project.csv"),
    FAQ("resource/faq.csv"),
    PAYMENT("resource/payment.csv");

    private final String path;

    private PathFile(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
