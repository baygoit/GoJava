package ua.goit.kyrychok.kickstarter.mvc.model;

import ua.goit.kyrychok.kickstarter.DataProvider;
import ua.goit.kyrychok.kickstarter.model.Faq;

public class FaqModel {
    private DataProvider dataProvider;

    public FaqModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public String getInviteMessage() {
        return "Enter your question";
    }

    public void setQuestion(int categoryIndex, int projectIndex, String question) {
        Faq faq = new Faq();
        faq.setQuestion(question);
        dataProvider.addFaq(categoryIndex, projectIndex, faq);
    }
}
