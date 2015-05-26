package kickstarter.pages.modelContent;


import kickstarter.repository.facade.FileSystemRepository;
import kickstarter.repository.facade.Repository;


public class FileErrorModel extends PageModel {
	Repository inMemoryRepository; FileSystemRepository fileSystemRepository;
	public FileErrorModel(Repository inMemoryRepository, FileSystemRepository fileSystemRepository) {
		
		this.inMemoryRepository=inMemoryRepository;
		this.fileSystemRepository=fileSystemRepository;
	}

	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("w")) {
			//imodel.next(imodel.getSavedPage());
			//iRepository inMemory=inMemoryRepository;
			
			
			return;
		}
	}
}