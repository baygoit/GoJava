package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.beans.Faq;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;

public class QuestionState extends State {

    private Project project = DaoFactory.getProjectDao(getCurrentDataType()).getProject(State.getIdProject());

    public QuestionState() {
        menu = "Enter Question:";
        setCommandExit(false);
        setCommandZero(false);
    }

    @Override
    public void outputContentState() {
        System.out.println("--------------------------------------------------");
        System.out.println(menu);
    }

    @Override
    public boolean validate(String data) {
        return true;
    }

    @Override
    public void changeState(Console context) {
        String inData = getInData();
        DaoFactory.getFaqDao(getCurrentDataType()).saveFaq(new Faq(State.getIdProject(), inData));
        context.setCurrentState(new ProjectState());
    }

}
