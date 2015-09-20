package gojava.InFile;

import gojava.InputCheck;
import gojava.MenuTemplate;
import gojava.Payment;
import gojava.Interface.Categories;
import gojava.Interface.IO;
import gojava.Interface.Menu;

public class InFileMenu implements Menu {
	private Categories categories;
	private IO io;
	private InputCheck check;
	
	public InFileMenu(Categories categories, IO io, InputCheck check){
		this.categories=categories;
		this.io=io;
		this.check=check;
	}
	
	@Override
	public void categoriesMenu() {
		MenuTemplate menu = new MenuTemplate(check){
			
			@Override
			public Object getObject(int choice) {
				return categories.getCategory(choice - 1);
			}
			
			@Override
			public void nextSubmenu(Object object, int choice) {
				categoryMenu(new InFileCategory(object.toString()));
			}

			@Override
			public void showPositions()  {
				io.out("Choose a category:\n" + categories.showCategories());
			}
		};
		menu.run(categories.getLength());
	}

	@Override
	public void categoryMenu(Object object) {
		MenuTemplate menu = new MenuTemplate(check){
			
			@Override
			public Object getObject(int choice) {
				return ((InFileCategory)object).getProject(choice-1);
			}
			
			@Override
			public void nextSubmenu(Object object, int choice) {
				projectMenu(new InFileProject(object.toString()));
			}

			@Override
			public void showPositions() {
				io.out(((InFileCategory)object).showProjects());
			}
		};
		menu.run(((InFileCategory)object).getLength());
	}

	@Override
	public void projectMenu(Object object) {
		MenuTemplate menu = new MenuTemplate(check){
			
			@Override
			public Object getObject(int choice) {
				return (InFileProject)object;
			}

			@Override
			public void nextSubmenu(Object object, int choice) {
				inProjectMenu((InFileProject)object, choice);
			}

			@Override
			public void showPositions() {
				io.out(((InFileProject)object).showProject());
			}
		};
		menu.run(((InFileProject)object).getPositionsLength());
	}

	@Override
	public void inProjectMenu(Object object, int choice) {
		while(true){
			switch(choice){
			case 1:
				io.out("Type your question:\n0 - Go back");
				String question = check.stringInputCheck();
				if(question=="0")
					break;
				else
					((InFileProject)object).addQuestion(question);
				
				break;
			case 2:
				InFilePayments temp = new InFilePayments(object.toString());
				io.out("You'll get next rewards:\n" + temp.showRewards());
				choice = check.menuInputCheck(((InFileProject)object).getRewardsLength()+1);
				if(choice==0)
					break;
				
				int amount=0;
				if(choice<=temp.getRewardsLength()){
					amount=((InFileProject)object).getRewardPrice(choice-1);
				}
				
				io.out("Type your name:");
				String name = check.stringInputCheck();
				if(name=="0")
					break;
				
				io.out("Type your card number:");
				String card = check.stringInputCheck();
				if(card=="0")
					break;
				
				if(choice==(((InFileProject)object).getRewardsLength()+1)){
					io.out("Type amount:");
					amount = io.input();
				}
				if(amount==0)
					break;
				
				Payment p = new Payment(name, card, amount);
				((InFileProject)object).makePayment(p, amount);
				break;
			}
			break;
		}
	}

}