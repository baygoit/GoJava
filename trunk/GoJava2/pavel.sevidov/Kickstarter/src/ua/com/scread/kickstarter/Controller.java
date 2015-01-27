package ua.com.scread.kickstarter;

import java.util.ArrayList;

public class Controller {
	private Model model;
    private View view;
    private Scan scan;

    public Controller(Model model, View view, Scan scan) {
        this.model = model;
        this.view = view;
        this.scan = scan;
    }
    
//    UserStory III
//    Как гость я хочу изучить список проектов определенной категории, чтобы понять во что я 
//    хочу инвестировать
//    Сценарий: захожу в приложение -> выбираю любую категорию (например, 1 - спорт) -> вижу 
//    список проектов, каждый из которых содержит: название, краткое описание, сумму необходиму 
//    для сбора, сколько собрали уже, сколько дней осталось

    public void start() {
        model.init();
        view.greed();

        Categories categories = model.getCategories();
        view.showCategoies(categories);	
        
        int answer = scan.getAnswer()-1;
        Category category = categories.getCategory(answer);
        view.showCategory(category);
        
        ArrayList<Project> foundProjects = model.getProjects(category);
        view.showProjects(foundProjects);
    }

}
