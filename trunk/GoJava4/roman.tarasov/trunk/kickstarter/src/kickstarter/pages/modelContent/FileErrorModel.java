package kickstarter.pages.modelContent;

import kickstarter.mvc.interfaces.iController;
import kickstarter.repository.facade.FileSystemRepository;
import kickstarter.repository.facade.Repository;

public class FileErrorModel extends PageModel {
	Repository inMemoryRepository;
	FileSystemRepository fileSystemRepository;
	iController icontroller;

	public FileErrorModel(Repository inMemoryRepository,
			FileSystemRepository fileSystemRepository,iController icontroller) {

		this.inMemoryRepository = inMemoryRepository;
		this.fileSystemRepository = fileSystemRepository;
		this.icontroller=icontroller;
	}

	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("i")) {
			icontroller.setInMemoryRepository();
			imodel.getViewOptions().viewError=false;
			imodel.next(CATEGORIES);
			return;
		}
		if (message.equals("e")) {
			imodel.next(END_PAGE);
			return;
		}
	}
}