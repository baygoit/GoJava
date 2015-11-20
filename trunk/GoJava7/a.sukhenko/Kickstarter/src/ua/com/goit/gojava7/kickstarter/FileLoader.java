package ua.com.goit.gojava7.kickstarter;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class FileLoader{
	static File file = new File(System.getProperty("user.dir") + "//resources//categories.xml");
	public static void main(String[] args) throws NoSuchFileException {
		loadCategories();
	}
	
	public static void saveCategories(CategoryStorage categoryStorage){
		try {
			
			
				JAXBContext jaxbContext = JAXBContext.newInstance(CategoryStorage.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(categoryStorage, file);
			jaxbMarshaller.marshal(categoryStorage, System.out);

		      } catch (JAXBException e) {
			e.printStackTrace();
		      }
	}
	
	public static List<Category> loadCategories(){
		CategoryStorage categoryStorage = null;
		    try {
		        JAXBContext context = JAXBContext
		                .newInstance(CategoryStorage.class);
		        Unmarshaller um = context.createUnmarshaller();

		        categoryStorage = (CategoryStorage) um.unmarshal(file);
		      

		    } catch (Exception e) {
		        System.out.println("Shit: " + e);
		        e.printStackTrace();
		    }
			return categoryStorage.getCategories();
		
	}

}
