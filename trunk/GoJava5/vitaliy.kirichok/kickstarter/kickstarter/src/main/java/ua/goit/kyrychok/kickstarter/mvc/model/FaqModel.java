package ua.goit.kyrychok.kickstarter.mvc.model;

import ua.goit.kyrychok.kickstarter.model.Faq;

public class FaqModel extends BaseModel {

    public String getInviteMessage() {
        return "Enter your question(%s): ";
    }

    public void setQuestion(int categoryIndex, int projectIndex, String question) {
        Faq faq = new Faq();
        faq.setQuestion(question);
        getDataProvider().addFaq(categoryIndex, projectIndex, faq);
    }
}
