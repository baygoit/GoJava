package ua.com.goit.gojava.andriidnikitin;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class XmlDataBuilderNew {
        	
        private static final JAXBContext JAXB_CONTEXT;
        
        static {
        	try {
        		JAXB_CONTEXT = JAXBContext.newInstance(						
    					Category.class
    					, Good.class
    					, WarehouseNew.class
    					);
        	} catch (JAXBException exception){
        		throw new RuntimeException("Failed create JAXBContext. " + exception.getMessage(), exception);
        	}
        }
        	
        public static WarehouseNew unmarshallWarehouse(File file) throws JAXBException{
            Unmarshaller jaxbUnmarshaller = JAXB_CONTEXT.createUnmarshaller();
            WarehouseNew warehouse = (WarehouseNew) jaxbUnmarshaller.unmarshal(file); 
            return warehouse; 
        }
        
        public static void marshallWarehouse(WarehouseNew warehouse, File file) throws JAXBException{
            Marshaller marshaller = JAXB_CONTEXT.createMarshaller();
            marshaller.marshal(warehouse, file);
        }                
}