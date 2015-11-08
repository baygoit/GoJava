package kickstarter.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.entity.Category;
import kickstarter.entity.Project;



import org.junit.Ignore;
import org.junit.Test;

public class test_example_jaxb {
	/*
	IRepository<IDcontent> categories;
	IRepository<IDcontent> projects;

	// @Ignore
	@Test
	public void copyRepositoryToFiles() {
		Repository<Category> categoriesRepository = new Repository<Category>();
		Repository<Project> projectsRepository = new Repository<Project>();
		projects = projectsRepository;
		categories = categoriesRepository;
		Category category = new Category();
		category.setName("category");
		category.setID(20);
		categories.addEntity(category);

		Project project = new Project();
		project.setID(8);
		project.setName("project");
		projects.addEntity(project);

		String path = "icategories/test";
		String fileName = "/categoryID.";

		try {
			creatorFilesFromList(categories, path, fileName);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		path = "iprojects/test";
		fileName = "/projectID.";

		try {
			creatorFilesFromList(projects, path, fileName);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	<T> void creatorFilesFromList(IRepository<IDcontent> irepository,
			String path, String fileName) throws ServiceException {
		try {
			if (Files.notExists(Paths.get(path))) {
				Files.createDirectory(Paths.get(path));
			}
		} catch (IOException e) {
			throw new ServiceException("Error directory creation");
		}
		ArrayListExtendedByID<IDcontent> entityList = irepository.getList();
		for (IDcontent entity : entityList) {
			try {
				File file = new File(path + fileName
						+ Integer.toString(entity.getID()) + ".xml");

				JAXBContext jaxbContext = JAXBContext.newInstance(entity
						.getClass());
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				jaxbMarshaller.marshal(entity, file);

			} catch (JAXBException e) {
				throw new ServiceException(" marshalling error");
			}
		}
	}
*/
}
