package ua.com.goit.gojava.andriidnikitin.service.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.Warehouse;


public class XmlDataBuilder {
        	
        private static final JAXBContext JAXB_CONTEXT;
        
        static {
        	try {
        		JAXB_CONTEXT = JAXBContext.newInstance(						
    					Category.class
    					, Good.class
    					, Warehouse.class
    					);
        	} catch (JAXBException exception){
        		throw new RuntimeException("Failed create JAXBContext. " + exception.getMessage(), exception);
        	}
        }
        	
        public static Warehouse unmarshallWarehouse(File file) throws JAXBException{
            Unmarshaller jaxbUnmarshaller = JAXB_CONTEXT.createUnmarshaller();
            Warehouse warehouse = (Warehouse) jaxbUnmarshaller.unmarshal(file); 
            return warehouse; 
        }
        
        public static void marshallWarehouse(Warehouse warehouse, File file) throws JAXBException{
            Marshaller marshaller = JAXB_CONTEXT.createMarshaller();
            marshaller.marshal(warehouse, file);
        }                
}