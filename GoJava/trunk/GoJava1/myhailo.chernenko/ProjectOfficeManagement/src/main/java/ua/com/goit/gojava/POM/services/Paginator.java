package ua.com.goit.gojava.POM.services;

public class Paginator {
	
	private int firstResult = 1;
	private int maxResults = 10;
	private int total;
	private int pages;
	private boolean previousPage;
	private boolean nextPage;
	
	public int getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}
	public int getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
		calculatePages();
	}
	public boolean isPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(boolean previousPage) {
		this.previousPage = previousPage;
	}
	public boolean isNextPage() {
		return nextPage;
	}
	public void setNextPage(boolean nextPage) {
		this.nextPage = nextPage;
	}
	
	public int getPages() {
		return this.pages;
	}
	public void calculatePages() {
		if (total > maxResults) {
			double noOfPages = (double) total / (double) maxResults;
			pages = (int) noOfPages;
			if (noOfPages % pages > 0.0) {
				pages++;
			}
		}
	}
	public int getLastResult() {
		return Math.min(firstResult + maxResults - 1, total);
	}
	public void hextPage() {
		if((firstResult + maxResults) <= total) {
			firstResult = firstResult + maxResults;
		} 
	}
	public void previousPage() {
		if((firstResult - maxResults) > 0) {
			firstResult = firstResult - maxResults;
		} else {
			firstResult = 1;
		}
	}
	
	public void checkAction() {

		if (nextPage == true) {
			hextPage(); 
			nextPage = false;
		} else if (previousPage == true) {
			previousPage(); 
			previousPage = false;
		}
		
	}
	
}
