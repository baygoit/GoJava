package com.anmertrix;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.dao.file.CategoryDaoFile;
import com.anmertrix.dao.file.QuoteDaoFile;
import com.anmertrix.dao.memory.CategoryDaoMemory;
import com.anmertrix.dao.memory.QuoteDaoMemory;
import com.anmertrix.dao.sql.CategoryDaoSql;
import com.anmertrix.dao.sql.DaoSql;
import com.anmertrix.dao.sql.QuoteDaoSql;
import com.anmertrix.page.Page;

public class ViewPage {
	
	private static final String SQL_MODE = "SQL";
	private static final String MEMORY_MODE = "MEMORY";
	private static final String FILE_MODE = "FILE";
	private static final String HEADER = "                    ***  KICKSTARTER   ***   ";
	
	private Page page;
	private IO io;
	private QuoteDao quoteDao;
    private CategoryDao categoryDao;
	
	private boolean isExit = false;
	private int selectedMenuItemCategory;
	private int selectedMenuItemProject;
	private String mode;

	public ViewPage(IO io) {
		mode = DaoSwitch.getMode();
		if (FILE_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoFile();
			this.categoryDao = new CategoryDaoFile();
		} else if (MEMORY_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoMemory();
			this.categoryDao = new CategoryDaoMemory();
		} else if (SQL_MODE.equals(mode)) {
			this.quoteDao = new QuoteDaoSql();
			this.categoryDao = new CategoryDaoSql();
		}
		this.io = io;
	}
	
	public void setPage(Page page) {
		this.page = page;
	}
	
	public QuoteDao getQuoteDao() {
		return quoteDao;
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	
	public IO getIo() {
		return io;
	}
	
	public void initData() {
		DaoSql.initConnectionManager();
		quoteDao.initData();
		categoryDao.initData();
	}
	
	void viewPage() {
		io.println("");
		io.println(HEADER);
		io.println("");
		page.viewPage(this);
	}
	
	public int getInputNumber() {
		String text = io.readConsole();
		int result = 0;
		try {
			result = (Integer.parseInt(text));
		} catch (NumberFormatException e) {
			io.println("You can enter only numbers. \"" + text + "\" is not a number.");
		}

		return result;
	}

	public boolean isExit() {
		return isExit;
	}

	public void setExit(boolean isExit) {
		this.isExit = isExit;
	}

	public int getSelectedMenuItemCategory() {
		return selectedMenuItemCategory;
	}

	public void setSelectedMenuItemCategory(int selectedMenuItemCategory) {
		this.selectedMenuItemCategory = selectedMenuItemCategory;
	}
	
	public int getSelectedMenuItemProject() {
		return selectedMenuItemProject;
	}

	public void setSelectedMenuItemProject(int selectedMenuItemProject) {
		this.selectedMenuItemProject = selectedMenuItemProject;
	}

}
