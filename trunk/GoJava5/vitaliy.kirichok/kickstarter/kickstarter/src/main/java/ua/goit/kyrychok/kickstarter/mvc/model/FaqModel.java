package ua.goit.kyrychok.kickstarter.mvc.model;

import ua.goit.kyrychok.kickstarter.model.Faq;

public class FaqModel extends BaseModel {

    private static final String INVITE_MESSAGE = "Enter your question(%s): ";

    public String getInviteMessage() {
        return INVITE_MESSAGE;
    }

    public void setQuestion(int categoryIndex, int projectIndex, String question) {
        Faq faq = new Faq();
        faq.setQuestion(question);
        getDataProvider().addFaq(categoryIndex, projectIndex, faq);
    }
}
