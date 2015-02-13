package ua.com.scread.kickstarter;

import java.util.Arrays;
import java.util.List;

public class Controller {
	private Model model;
    private IO io;
    private QuoteGenerator quote;
    
//    UserStory VIII
//    Как гость я хочу понимать, что я получу за свои инвестиции от проекта
//    Сценарий: На страничке пеймента я вижу варианты оплаты (1 - 1,2-10, 3 - 40)
//    с описанием что я получу за это, я могу выбрать один из них или как раньше перечислить 
//    любую сумму, какую хочу. Автор проекта сам задает эту дополнительную информацию.
//    Не забываем про меню "0 - назад". В любом месте системы я могу вернуться на предыдущий скрин. 

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
                    return faqMenu(project);
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
    
    protected Menu faqMenu(final Project project) {
        return new Menu(io) {  // TODO придумать как изменить эту конструкцию
            
            @Override
            Menu nextMenu(Object selected) {
                return null;
            }
            
            @Override
            Object choose(int menuItem) {
                return null;
            }
            
            @Override
            void ask() {   
            }
            
            @Override
            public void run() {
                io.print("Enter your question: ");
                io.readString(); // почему?
                String question = io.readString();;
                FAQ faq = new FAQ(question, "");
                project.addFAQ(faq);
            }
        };
        
    }

    private Menu paymentMenu(final Project project) {
        return new Menu(io) {
            
            @Override
            Menu nextMenu(Object selected) {
                if (selected.toString() != "") { // TODO придумать лучшее решение
                    Bonus bonus = (Bonus)selected;
                    donateWithBonus(project, bonus);
                }
                return null;
            }
            
            @Override
            Object choose(int menuItem) {
                if(menuItem <= project.getBonuses().size()){
                    return project.getBonus(menuItem - 1);                    
                } else {
                    return donateWithoutBonus(project);
                }
            }
            
            @Override
            void ask() {
                showBonuses(project);
            }
        };
        
    }
    
    private Object donateWithBonus(Project project, Bonus bonus) {            
        pymentCardInfo();
        project.addMoney(bonus.getAmount());
        showThanks();
        return null;
    }
    
    private String donateWithoutBonus(Project project) {
        pymentCardInfo();
        io.print("Enter donate amount: ");
        int amount = io.read();
        project.addMoney(amount);
        showThanks();
        return "";
    }

    private void pymentCardInfo() {
        io.print("Enter name: ");
        io.readString();  // почему?
        @SuppressWarnings("unused")
        String name = io.readString();
        io.print("Enter card number: ");
        @SuppressWarnings("unused")
        long cardNumber = io.readLong();
    }
    

    
    protected void showBonuses(Project project) {
        Bonuses bonuses = project.getBonuses();
        for(int index = 0; index < bonuses.size(); index++) {
            Bonus bonus = bonuses.getBonus(index);
            println((index + 1) + " - " + bonus.getAmount() + ": " + bonus.getDescription());
        }
        println(bonuses.size() + 1 + " - " + "Other amount");
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
		AdditionalInfo details = project.getDetails();
		FAQs faqs = details.getFAQs();
		println("History: " + details.getHistory());
		println("Video link: " + details.getVideo());
		println("\nFrequently Asked Questions: ");
		for (FAQ faq: faqs.getFAQs()) {
		    println(faq.getQuestion());
	        println("\n" + faq.getAnswer());
		}
		showLine();
		showMenu();
	}
	
	private void showMenu() {
	    io.print("[1 - Donate] or [2 - Ask question]");
	    showExit();
	}

}
