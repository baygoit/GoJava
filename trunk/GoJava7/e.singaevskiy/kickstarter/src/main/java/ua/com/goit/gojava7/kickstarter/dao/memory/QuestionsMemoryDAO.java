package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Question;
import ua.com.goit.gojava7.kickstarter.dao.QuestionsStorage;

public class QuestionsMemoryDAO extends MemoryDAO<Question> implements QuestionsStorage{

    public QuestionsMemoryDAO(List<Question> dataSource) {
        super(dataSource);
    }

}
