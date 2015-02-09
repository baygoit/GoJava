package ua.com.scread.kickstarter;

import java.awt.MenuItem;
import java.util.Arrays;
import java.util.List;

public class Controller {
	private Model model;
    private IO io;
    private QuoteGenerator quote;
    
//    UserStory VI
//    Как гость я хочу инвестировать в понравившийся мне проект, чтобы поддержать его
//    Сценарий: Находясь в конкретном проекте -> Вижу меню с вариантами, что могу сделать, 
//    один из пунктов - проинвестировать в проект -> Выбираю его -> Вижу вопрос от пеймент 
//    системы о вводе имени и номера карточки и суммы -> Ввожу их ->
//    Перехожу на описание проекта, где вижу что инфа о количестве пожертвований поменялась

    public Controller(Model model, IO io, QuoteGenerator quote) {
        this.model = model;
        this.io = io;
        this.quote = quote;
    }    
    
    public void start() {
        greed(quote);      
       	categoryMenu().run();
        io.print("Thanks for using my program!");
    }
    
    private Menu categoryMenu() {
        return new Menu(io) {
            
            @Override
            Menu nextMenu(Object selected) {
                Category category = (Category)selected;             
                showCategory(category);
                return projectsMenu(category); 
            }
            
            @Override
            Object choose(int menuItem) {
                Categories categories = model.getCategories();
                return categories.getCategory(menuItem - 1);
            }
            
            @Override
            void ask() {
                showCategoies();                 
            }
        };
    }
    
    private Menu projectsMenu(final Category category) {
        return new Menu(io) {
            List<Project> projects = model.getProjects(category);
            
            @Override
            Menu nextMenu(Object selected) {
                Project project = (Project)selected;
                return projectMenu(project);
            }
            
            @Override
            Object choose(int menuItem) {
                return projects.get(menuItem - 1);
            }
            
            @Override
            void ask() {
                showProjects(projects);            
            }
        };
    }

    private Menu projectMenu(final Project project) {
        return new Menu(io) {
            
            @Override
            Menu nextMenu(Object selected) {
                Integer menuItem = (Integer)selected;
                if (menuItem == 1) {
                    return paymentMenu(project);                     
                } else {
                    return null;                    
                }
            }
            
            @Override
            Object choose(int menuItem) {
                return menuItem;
            }
            
            @Override
            void ask() {
                showFullProject(project);                 
            }
        };        
    }
    
    private Menu paymentMenu(final Project project) {
        return new Menu(io) {
            
            @Override
            Menu nextMenu(Object selected) {
                Integer amount = (Integer)selected;
                project.addMoney(amount);
                showThanks();
                return null;
            }
            
            @Override
            Object choose(int menuItem) {
                return menuItem;
            }
            
            @Override
            void ask() {
                io.print("Enter donate amount: ");
            }
        };
    }

    private void showPayment() {
        io.print("[1 - Donate]");
        showExit();
    }
    
    private void showThanks() {
        println("Thank you for your donation!");
    }

    private void println() {
    	io.print("\n");
	}
    
	public void println(String message) {
		io.print(message + "\n");
	}
	
	public void greed(QuoteGenerator quote) {
		println(quote.getQuote());
	}

	public void showCategoies() {
		io.print("\nChoose category: ");
		io.print(Arrays.toString(model.getCategories().getStringCategories()));
		showExit();
	}

	public void showCategory(Category category) {
		println("You choosed: " + category.getName());
	}
	
	public void showProjects(List<Project> projects) {
		
        for (Project project : projects) {
        	showProject(project);  
        	showLine();
        }
        println("\nChoose project: ");
        for (int i = 0; i < projects.size(); i++) {
        	io.print(String.valueOf(i+1) + " - " + projects.get(i).getName() + "; ");
        }
        showExit();
        println();
	}
	
	private void showLine() {
		println("--------------------------------------");
	}

	private void showProject(Project project) {
		println(project.getName());
        println(project.getDescription()); 
        println("Already collected " + project.getCollected() + " UAH for " + project.getDays() + " days"); 
        println("Need collect " + project.getAmount() + " UAH");	
	}

	private void showExit() {
		println(" or [0 - back]");
	}
	
	public void showFullProject(Project project) {
		showLine();
		showProject(project);
		Details details = project.getDetails();
		FAQ faq = details.getFAQ();
		println("History: " + details.getHistory());
		println("Video link: " + details.getVideo());
		println("\nFrequently Asked Questions: ");
		println(faq.getQuestion());
		println("\n" + faq.getAnswer());
		showLine();
		showPayment();
	}
	

}
