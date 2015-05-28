package kickstarter.mvc.interfaces;

import kickstarter.repository.facade.iRepository;

public interface iController {
	void setFileSystemRepository();

	void setInMemoryRepository();

	void setFileNameOfRepository(String fileName);

	String getFileNameOfRepository();

	void setIRepository(iRepository setRepository);
}
