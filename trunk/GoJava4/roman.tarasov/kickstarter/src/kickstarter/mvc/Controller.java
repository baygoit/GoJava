package kickstarter.mvc;

import kickstarter.mvc.interfaces.iController;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.repository.facade.FileRepositoryDriver;
import kickstarter.repository.facade.MemoryRepository;
import kickstarter.repository.facade.iRepository;

public class Controller implements iController {

	private iView iview;
	private iModel imodel;
	private FileRepositoryDriver fileRepositoryDriver;
	private MemoryRepository inMemoryRepository;
	private iRepository currentRepository;

	public void showPage() {
		iview.showPage();
	}

	public void updateStateOfModel(String message) {
		imodel.updateStateOfModel(message);
	}

	public void setPage(int currentPage) {
		imodel.setPage(currentPage);
	}

	public void setCurrentRepository(iRepository setRepository) {
		this.currentRepository=setRepository;
		imodel.setRepository(setRepository);
		iview.setRepository(setRepository);
	}

	public void initModel(iModel setModel) {
		iview.setModel(setModel);
		imodel.setModel(setModel);
	}
	public void initView(iView setView) {
		iview.setView(setView);
		imodel.setView(setView);
	}

	@Override
	public void setFileSystemRepository() {
		setCurrentRepository(fileRepositoryDriver);
	}

	@Override
	public void setInMemoryRepository() {
		setCurrentRepository(inMemoryRepository);
	}

	@Override
	public void setFileNameOfRepository(String fileName) {
		fileRepositoryDriver.setFileName(fileName);
	}

	@Override
	public String getFileNameOfRepository() {
		return fileRepositoryDriver.getFileNameOfRepository();
	}

	@Override
	public void setIRepository(iRepository setRepository) {
		setCurrentRepository(setRepository);
	}

	@Override
	public void setInterfaces(iView iview, iModel imodel) {
		this.iview=iview;
		this.imodel=imodel;
	}

	public void setRepositories(FileRepositoryDriver fileRepositoryDriver,
			MemoryRepository inMemoryRepository) {
		this.fileRepositoryDriver=fileRepositoryDriver;
		this.inMemoryRepository=inMemoryRepository;
	}

	@Override
	public iRepository getCurrentRepository() {
		return currentRepository;
	}
}
