package ua.com.goit.gojava7.kickstarter.dao.file;

import ua.com.goit.gojava7.kickstarter.beans.Question;
import ua.com.goit.gojava7.kickstarter.dao.QuestionsStorage;

public class QuestionsFileDAO extends FileDAO<Question> implements QuestionsStorage {

    public QuestionsFileDAO() {
        super(Question.class);
    }

    public QuestionsFileDAO(String pathToFile) {
        super(Question.class, pathToFile);
    }

}
