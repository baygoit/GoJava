package kickstarter.pages.modelContent;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import kickstarter.mvc.interfaces.IndexOfPage;
import kickstarter.mvc.interfaces.iController;
import kickstarter.repository.facade.MemoryRepository;

public class RepositoryMenuModel extends PageModel {

	private MemoryRepository deserializedRepository;
	private iController icontroller;

	public RepositoryMenuModel(iController icontroller) {

		this.icontroller = icontroller;
	}

	@Override
	public void updateStateOfPageModel(String message) {
		if (message.equals("p")) {
			getImodel().next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		if (message.equals("d")) {
			icontroller.setInMemoryRepository();
			getIview().getViewValues().setRepositoryError(false);
			getImodel().next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		if (message.equals("e")) {
			getImodel().next(IndexOfPage.END_PAGE.ordinal());
			return;
		}
		if (message.equals("c")) {
			try (ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("object.ser")))) {
				;
				out.writeObject(icontroller.getCurrentRepository());
				
			} catch (IOException e) {
				getImodel().goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
						IndexOfPage.REPOSITORY_MENU_PAGE.ordinal());
				return;
			}
			getIview().getViewValues().setRepositoryError(false);
			getImodel().next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		if (message.equals("i")) {

			try (ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("object.ser")))) {
				
				deserializedRepository = (MemoryRepository) in.readObject();
			} catch (ClassNotFoundException | IOException e) {
				getImodel().goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
						IndexOfPage.REPOSITORY_MENU_PAGE.ordinal());
				return;
			}

			icontroller.setIRepository(deserializedRepository);
			getIview().getViewValues().setRepositoryError(false);
			getImodel().next(IndexOfPage.CATEGORIES.ordinal());
			return;
		}
		getImodel().goToAndBack(IndexOfPage.ERROR_PAGE.ordinal(),
				IndexOfPage.REPOSITORY_MENU_PAGE.ordinal());
	}

}