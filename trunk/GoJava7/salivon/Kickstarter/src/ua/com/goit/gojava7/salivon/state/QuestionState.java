package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.beans.Faq;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStateQuestion;

public class QuestionState extends State {

    private Project project = getManagerData().getProject(State.getIndexProject());

    public QuestionState() {
        handler = new ErrorHandlerStateQuestion();
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
    public void changeState(Console context) {
        String inData = getInData();
        getManagerData().saveFaq(new Faq(State.getIndexProject(), inData));
        context.setCurrentState(new ProjectState());
    }

}
