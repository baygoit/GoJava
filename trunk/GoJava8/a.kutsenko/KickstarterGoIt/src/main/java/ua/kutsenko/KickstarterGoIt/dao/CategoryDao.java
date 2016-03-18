package ua.kutsenko.KickstarterGoIt.dao;

import java.util.List;

import ua.kutsenko.KickstarterGoIt.domain.Category;
import ua.kutsenko.KickstarterGoIt.domain.Investment;
import ua.kutsenko.KickstarterGoIt.domain.Project;
import ua.kutsenko.KickstarterGoIt.domain.Question;

public interface CategoryDao {
public Category getByName(String name);
public List<String> getCategoryNames();	
public void addInvestment(Project project , Investment investment);
public void addQuestion (Project project , Question question);

}
