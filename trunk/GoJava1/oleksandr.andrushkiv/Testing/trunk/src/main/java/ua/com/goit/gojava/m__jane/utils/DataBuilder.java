package ua.com.goit.gojava.m__jane.utils;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ua.com.goit.gojava.m__jane.model.Category;
import ua.com.goit.gojava.m__jane.model.question.MultipleQuestion;
import ua.com.goit.gojava.m__jane.model.question.Question;
import ua.com.goit.gojava.m__jane.model.question.SimpleQuestion;


public class DataBuilder {

	private static DataBuilder instance;
	private static DataLoader dataLoader;
	private static File FILE = new File("src/main/resources/DataFile2.xml");
	//гдето надо чето подстроить чтоб tomcat собирал правильный путь к файлу...сейчас вот такой: 
	//D:\Java\eclipse\src\main\resources\DataFile2.xml (Системе не удается найти указанный путь)]

	private DataBuilder() {
	}

	public static synchronized DataBuilder getInstance() throws JAXBException {
		if (instance == null) {
			
			if (!FILE.exists()) FILE = new File("D:/Java/eclipse/workspace/testing/src/main/resources/DataFile2.xml");
			
			instance = new DataBuilder();
			JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] {DataLoader.class, Category.class, Question.class, SimpleQuestion.class, MultipleQuestion.class});
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			dataLoader = (DataLoader) jaxbUnmarshaller.unmarshal(FILE);			
		}
		return instance;
	}

	public DataLoader getDataLoader() {
		return dataLoader;
	}
		
}
