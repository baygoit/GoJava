package kickstarter.logic;

import kickstarter.repos.CategoriesRepo;
import kickstarter.repos.QuotesRepo;
import kickstarter.repos.Repository;

public class CategoriesLogic implements ILogic {
	
	private Repository repository;
    
    private CategoriesRepo categoriesRepo;
    private QuotesRepo quotesRepo;
    
    public CategoriesLogic(Repository repository) {
    	this.repository = repository;
    }

    public int getSize() {
	return repository.categories.size();
    }

    public String getIndex(int index1) {
		String index = getCategories().get(index1).toString();
		return index;
    }
    
    public String getQuote() {
    	return quotesRepo.showRandomQuote();
    }
    
    public CategoriesRepo getCategories() {
    	return repository.categories;
    }
    
}
