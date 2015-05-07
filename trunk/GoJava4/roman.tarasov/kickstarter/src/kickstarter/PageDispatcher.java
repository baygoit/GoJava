package kickstarter;

public class PageDispatcher {
	Page adminCategoriesControl;
	Page loginPage ;
	UserInterface ui;
	//PageInterface pi;
	CategoryList list;
	//Page nextPage;
	Page page;
	Page[]pages=new Page[2];
	PageDispatcher(UserInterface ui,CategoryList list){

	    this.ui=ui;
	    this.list=list;
	}
	void cycleDispatcher(){
		while(true){
			page=page.getNextPage();
			
		}
	}
	public void startDispatcher(){
		//nextPage=loginPage.getNextPage();
		
		adminCategoriesControl=new AdminCategoriesControl(list);
		
	    loginPage =new LoginPage();
	    
	    pages[0]=loginPage;
	    pages[1]=adminCategoriesControl;
	    adminCategoriesControl.setPages(pages);
	    adminCategoriesControl.setUI(ui);
	    
	    loginPage.setPages(pages);
	    loginPage.setNextPage(loginPage);
	    loginPage.setUI(ui);
	    page=loginPage;
	    
		cycleDispatcher();
	}
	

	

}

