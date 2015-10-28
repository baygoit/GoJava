package kickstarter.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import kickstarter.entity.Category;

import org.junit.Test;

public class test_jaxb {


	
	
	//@Ignore
	@Test
	public void test() {
		Category categoryToMarshall = new Category();
		categoryToMarshall.setName("test");
		categoryToMarshall.setID(20);

		try {
			try {
				if (Files.notExists(Paths.get("icategories"))) {
					Files.createDirectory(Paths.get("icategories"));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File file = new File("./icategories/file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Category.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(categoryToMarshall, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		Category categoryFromUnmarshall = null;
		try {

			File file = new File("./icategories/file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Category.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			categoryFromUnmarshall = (Category) jaxbUnmarshaller
					.unmarshal(file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		assertEquals("test", categoryFromUnmarshall.getName());
		assertEquals(20, categoryFromUnmarshall.getID());

	}


}
