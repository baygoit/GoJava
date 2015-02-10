package ua.com.goit.gojava.andriidnikitin;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class XmlDataBuilderOld {
        	
        private static final JAXBContext JAXB_CONTEXT;
        
        static {
        	try {
        		JAXB_CONTEXT = JAXBContext.newInstance(						
    					Category.class
    					, Good.class
    					, WarehouseOld.class
    					);
        	} catch (JAXBException exception){
        		throw new RuntimeException("Failed create JAXBContext. " + exception.getMessage(), exception);
        	}
        }
        	
        public static WarehouseOld unmarshallWarehouse(File file) throws JAXBException{
            Unmarshaller jaxbUnmarshaller = JAXB_CONTEXT.createUnmarshaller();
            WarehouseOld warehouseOld = (WarehouseOld) jaxbUnmarshaller.unmarshal(file); 
            return warehouseOld; 
        }
        
        public static void marshallWarehouse(WarehouseOld warehouseOld, File file) throws JAXBException{
            Marshaller marshaller = JAXB_CONTEXT.createMarshaller();
            marshaller.marshal(warehouseOld, file);
        }                
}