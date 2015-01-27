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
    
//    UserStory IV
//    Как гость я хочу изучить конкретный проект, чтобы понять хочу ли я в него инвестировать
//    Сценарий: Находясь в списке проектов -> вижу запрос на выбор проекта -> Выбираю, например 
//    (12 - разработка нового эргономичного мяча для футбола) -> вижу подробное описание проекта, 
//    среди которых: все то же что в списке + история проекта + линк на видео с демо + вопросы/ответы
    
    public void start() {
        model.init();
        view.greed();

        Categories categories = model.getCategories();
        view.showCategoies(categories);	
        
        int answer = scan.getAnswer()-1;
        Category category = categories.getCategory(answer);
        view.showCategory(category);
        
        ArrayList<Project> projects = model.getProjects(category);
        view.showProjects(projects);
        
        answer = scan.getAnswer()-1;
        Project project = projects.get(answer);
        view.showFullProject(project);
    }

}
