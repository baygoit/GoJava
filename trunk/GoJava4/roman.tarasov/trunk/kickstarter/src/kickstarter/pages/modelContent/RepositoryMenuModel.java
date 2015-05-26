package kickstarter.pages.modelContent;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import kickstarter.mvc.interfaces.iController;
import kickstarter.repository.facade.FileSystemRepository;
import kickstarter.repository.facade.Repository;

public class RepositoryMenuModel extends PageModel {
	Repository inMemoryRepository;
	Repository deserializedRepository;
	FileSystemRepository fileSystemRepository;
	iController icontroller;

	public RepositoryMenuModel(Repository inMemoryRepository,
			FileSystemRepository fileSystemRepository, iController icontroller) {

		this.inMemoryRepository = inMemoryRepository;
		this.fileSystemRepository = fileSystemRepository;
		this.icontroller = icontroller;
	}

	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("p")) {
			imodel.next(CATEGORIES);
			return;
		}
		if (message.equals("m")) {
			icontroller.setInMemoryRepository();
			imodel.getViewOptions().repositoryError = false;
			imodel.next(CATEGORIES);
			return;
		}
		if (message.equals("e")) {
			imodel.next(END_PAGE);
			return;
		}
		if (message.equals("c")) {
			RepositoryExchanger repositoryExchanger = new RepositoryExchanger();
			repositoryExchanger.memoryToFile();
			imodel.getViewOptions().repositoryError = false;
			imodel.next(CATEGORIES);
			return;
		}
		if (message.equals("f")) {
			RepositoryExchanger repositoryExchanger = new RepositoryExchanger();
			repositoryExchanger.fileToMemory();
			icontroller.setIRepository(deserializedRepository);
			imodel.getViewOptions().repositoryError = false;
			imodel.next(CATEGORIES);
			return;
		}
		imodel.goToAndBack(ERROR_PAGE, REPOSITORY_MENU_PAGE);
	}

	class RepositoryExchanger {
		private void memoryToFile() {
			try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("object.ser")))) {

				out.writeObject(inMemoryRepository);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void fileToMemory() {
			try (ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("object.ser")))) {
				deserializedRepository = (Repository) in.readObject();
			} catch (ClassNotFoundException | IOException e) {
				imodel.goToAndBack(ERROR_PAGE, CATEGORIES);
				return;
			}
		}
	}
}