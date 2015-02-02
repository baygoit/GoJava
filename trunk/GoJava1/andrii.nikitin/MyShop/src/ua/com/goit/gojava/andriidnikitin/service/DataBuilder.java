package ua.com.goit.gojava.andriidnikitin.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.Warehouse;


public class DataBuilder {

        private static DataBuilder instance;
        //private static final File FILE = new File("resources/DataFile.xml");
        DataBuilder() {
        }

       /* public static synchronized DataBuilder getInstance() throws JAXBException {
                if (instance == null) {
                        instance = new DataBuilder();
                        JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] {Warehouse.class});
                        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                        warehouse= (Warehouse) jaxbUnmarshaller.unmarshal(FILE);                     
                }
                return instance;
        }
        */
        public static Warehouse unmarshall(File file) throws JAXBException{
        	file = new File("resources/DataFile.xml");
        	instance = new DataBuilder();
            JAXBContext jaxbContext = JAXBContext.newInstance(						
					Category.class
					, Good.class
					, Warehouse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Warehouse warehouse = (Warehouse) jaxbUnmarshaller.unmarshal(file); 
            return warehouse; 
        }
        
        public static void marshall(Warehouse warehouse, File file) throws JAXBException{
        	file = new File("resources/DataFile.xml");
        	instance = new DataBuilder();
            JAXBContext jaxbContext = JAXBContext.newInstance(						
					Category.class
					, Good.class
					, Warehouse.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(warehouse, file);
        }                
}