package gojava.InMemory;

import gojava.InputCheck;
import gojava.MenuTemplate;
import gojava.Payment;
import gojava.Interface.Categories;
import gojava.Interface.Category;
import gojava.Interface.IO;
import gojava.Interface.Menu;
import gojava.Interface.Payments;
import gojava.Interface.Project;

public class InMemoryMenu implements Menu {
	private Categories categories;
	private IO io;
	private InputCheck check;
	
	public InMemoryMenu(Categories categories, IO io, InputCheck check){
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
				categoryMenu((Category) object);
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
				return ((Category)object).getProject(choice-1);
			}
			
			@Override
			public void nextSubmenu(Object object, int choice) {
				projectMenu((Project) object);
			}

			@Override
			public void showPositions() {
				io.out(((Category)object).showProjects());
			}
		};
		menu.run(((Category)object).getLength());
	}

	@Override
	public void projectMenu(Object object) {
		MenuTemplate menu = new MenuTemplate(check){
			
			@Override
			public Object getObject(int choice) {
				return (Project)object;
			}

			@Override
			public void nextSubmenu(Object object, int choice) {
				inProjectMenu((Project)object, choice);
			}

			@Override
			public void showPositions() {
				io.out(((Project)object).showProject());
			}
		};
		menu.run(((Project)object).getPositionsLength());
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
					((Project)object).addQuestion(question);
				
				break;
			case 2:
				Payments temp = ((Project)object).getPayments();
				io.out("You'll get next rewards:\n" + temp.showRewards());
				choice = check.menuInputCheck(((Project)object).getRewardsLength()+1);
				if(choice==0)
					break;
				
				int amount=0;
				if(choice<=((Project)object).getRewardsLength()){
					amount=((Project)object).getRewardPrice(choice-1);
				}
				
				io.out("Type your name:");
				String name = check.stringInputCheck();
				if(name=="0")
					break;
				
				io.out("Type your card number:");
				String card = check.stringInputCheck();
				if(card=="0")
					break;
				
				if(choice==(((Project)object).getRewardsLength()+1)){
					io.out("Type amount:");
					amount = io.input();
				}
				if(amount==0)
					break;
				
				Payment p = new Payment(name, card, amount);
				((Project)object).makePayment(p, amount);
				break;
			}
			break;
		}
	}

}
