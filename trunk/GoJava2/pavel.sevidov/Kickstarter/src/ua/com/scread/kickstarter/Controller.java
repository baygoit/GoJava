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
                } else if(menuItem == 2) {
                    return faqMenu(project);                    
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
    
    protected Menu faqMenu(final Project project) {
        return new Menu(io) {
            
            @Override
            Menu nextMenu(Object selected) {
                String question = (String)selected;
                FAQ faq = new FAQ(question, "");
                project.addFAQ(faq);
                return null;
            }
            
            @Override
            Object choose(int menuItem) {
                return menuItem;
            }
            
            Object choose(String menuItem) {
                return menuItem;
            }
            
            @Override
            void ask() {
                io.print("Enter your question: ");
            }
            
            @Override
            public void run() {
                while (true) {
                    ask(); 
                    
                    String menuItem = io.readString();
                    if (menuItem == "0")
                        break;
                    
                    Object selected = choose(menuItem);
                    if (selected == null)
                        continue;
                    
                    Menu subMenu = nextMenu(selected);
                    if ( subMenu != null) {
                        subMenu.run();                
                    } else {
                        break;
                    }
                }
            }
        };
    }

    private Menu paymentMenu(final Project project) {
        return new Menu(io) {
            
            @Override
            Menu nextMenu(Object selected) {
                return null;
            }
            
            @Override
            Object choose(int menuItem) {
                return menuItem;
            }
            
            @Override
            void ask() {
            }

            @Override
            public void run() {
                io.print("Enter name: ");
                String name = io.readString();
                io.print("Enter card number");
                int cardNumber = io.read();
                io.print("Enter donate amount: ");
                int amount = io.read();
                project.addMoney(amount);
                showThanks();
            }
        };
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
