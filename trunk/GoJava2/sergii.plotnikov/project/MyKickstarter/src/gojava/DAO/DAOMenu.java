package gojava.DAO;

import gojava.InputCheck;
import gojava.MenuTemplate;
import gojava.Payment;
import gojava.Interface.Categories;
import gojava.Interface.IO;
import gojava.Interface.Menu;

public class DAOMenu implements Menu {
	private Categories categories;
	private IO io;
	private InputCheck check;
	
	public DAOMenu(Categories categories, IO io, InputCheck check){
		this.categories=categories;
		this.io=io;
		this.check=check;
	}
	
	@Override
	public void categoriesMenu() {
		MenuTemplate menu = new MenuTemplate(check){
			
			@Override
			public Object getObject(int choice) {
				return null;
			}
			
			@Override
			public void nextSubmenu(Object object, int choice) {
				categoryMenu(new DAOCategory(choice));
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
				return (DAOCategory)object;
			}
			
			@Override
			public void nextSubmenu(Object object, int choice) {
				projectMenu(new DAOProject(choice, (String)((DAOCategory)object).getTitle())); //, ((int)((DAOCategory)object).getTitle()))
			}

			@Override
			public void showPositions() {
				io.out(((DAOCategory)object).showProjects());
			}
		};
		menu.run(((DAOCategory)object).getLength());
	}

	@Override
	public void projectMenu(Object object) {
		MenuTemplate menu = new MenuTemplate(check){
			
			@Override
			public Object getObject(int choice) {
				return (DAOProject)object;
			}

			@Override
			public void nextSubmenu(Object object, int choice) {
				inProjectMenu((DAOProject)object, choice);
			}

			@Override
			public void showPositions() {
				io.out(((DAOProject)object).showProject());
			}
		};
		menu.run(((DAOProject)object).getPositionsLength());
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
					((DAOProject)object).addQuestion(question);
				
				break;
			case 2:
				DAOPayments temp = new DAOPayments(choice);
				io.out("You'll get next rewards:\n" + temp.showRewards());
				choice = check.menuInputCheck(((DAOProject)object).getRewardsLength()+1);
				if(choice==0)
					break;
				
				int amount=0;
				if(choice<=temp.getRewardsLength()){
					amount=((DAOProject)object).getRewardPrice(choice-1);
				}
				
				io.out("Type your name:");
				String name = check.stringInputCheck();
				if(name=="0")
					break;
				
				io.out("Type your card number:");
				String card = check.stringInputCheck();
				if(card=="0")
					break;
				
				if(choice==(((DAOProject)object).getRewardsLength()+1)){
					io.out("Type amount:");
					amount = io.input();
				}
				if(amount==0)
					break;
				
				Payment p = new Payment(name, card, amount);
				((DAOProject)object).makePayment(p, amount);
				break;
			}
			break;
		}
	}

}