package kickstarter.mvc;

import kickstarter.mvc.interfaces.iController;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.repository.facade.FileSystemRepository;
import kickstarter.repository.facade.Repository;
import kickstarter.repository.facade.iRepository;

public class Controller implements iController {

	private iView iview;
	private iModel imodel;
	private FileSystemRepository fileSystemRepository;
	private Repository inMemoryRepository;

	public Controller(iView iview, iModel imodel,
			FileSystemRepository fileSystemRepository,
			Repository inMemoryRepository) {
		this.iview = iview;
		this.imodel = imodel;
		this.fileSystemRepository = fileSystemRepository;
		this.inMemoryRepository = inMemoryRepository;
	}

	public void showPage() {
		iview.showPage();
	}

	public void updateStateOfModel(String message) {
		imodel.updateStateOfModel(message);
	}

	public void setPage(int currentPage) {
		imodel.setPage(currentPage);
	}

	public void setRepository(iRepository setRepository) {
		imodel.setRepository(setRepository);
		iview.setRepository(setRepository);
	}

	public void setModel(iModel setModel) {
		iview.setModel(setModel);
		imodel.setModel(setModel);
	}

	@Override
	public void setFileSystemRepository() {
		setRepository(fileSystemRepository);
	}

	@Override
	public void setInMemoryRepository() {
		setRepository(inMemoryRepository);
	}

	@Override
	public void setFileNameOfRepository(String fileName) {
		fileSystemRepository.setFileName(fileName);
	}

	@Override
	public String getFileNameOfRepository() {
		return fileSystemRepository.getFileNameOfRepository();
	}

	@Override
	public void setIRepository(iRepository setRepository) {
		setRepository(setRepository);
	}
}
