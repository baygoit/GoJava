package ua.com.goit.gojava7.kickstarter;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectManager;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class FileLoader {
	static File categoriesFile = new File(System.getProperty("user.dir") + "//resources//categories.xml");
	static File quotesFile = new File(System.getProperty("user.dir") + "//resources//quotes.xml");
	static File projectsFile = new File(System.getProperty("user.dir") + "//resources//projects.xml");
	static File projects2File = new File(System.getProperty("user.dir") + "//resources//projects2.xml");

	public static void saveCategories(CategoryStorage categoryStorage) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(CategoryStorage.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(categoryStorage, categoriesFile);
			jaxbMarshaller.marshal(categoryStorage, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void saveProjects(ProjectManager projectManager) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ProjectManager.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(projectManager, projectsFile);
			jaxbMarshaller.marshal(projectManager, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static List<Category> loadCategories() {
		CategoryStorage categoryStorage = null;
		try {
			JAXBContext context = JAXBContext.newInstance(CategoryStorage.class);
			Unmarshaller um = context.createUnmarshaller();
			categoryStorage = (CategoryStorage) um.unmarshal(categoriesFile);
		} catch (Exception e) {
			System.out.println("Shit: " + e);
			e.printStackTrace();
		}
		return categoryStorage.getCategories();

	}

	public static void saveQuotes(QuoteStorage quoteStorage) {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(QuoteStorage.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(quoteStorage, quotesFile);
			jaxbMarshaller.marshal(quoteStorage, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
