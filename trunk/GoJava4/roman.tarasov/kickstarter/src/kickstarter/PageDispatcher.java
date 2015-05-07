package kickstarter;

public class PageDispatcher {
	Page adminCategoriesControl;
	Page loginPage ;
	Page userCategoriesView;
	UserInterface ui;

	CategoryList list;

	Page page;
	Page[]pages=new Page[3];
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
		
		adminCategoriesControl=new PageAdminCategoriesControl(list);
		loginPage =new PageLogin();
		userCategoriesView=new PageUserCategoriesView(list);
		
		userCategoriesView.setPages(pages);
		userCategoriesView.setUI(ui);
		
	    
	    pages[0]=loginPage;
	    pages[1]=adminCategoriesControl;
	    pages[2]=userCategoriesView;
	    adminCategoriesControl.setPages(pages);
	    adminCategoriesControl.setUI(ui);
	    
	    loginPage.setPages(pages);
	    loginPage.setNextPage(loginPage);
	    loginPage.setUI(ui);
	    page=loginPage;
	    
		cycleDispatcher();
	}
	

	

}

