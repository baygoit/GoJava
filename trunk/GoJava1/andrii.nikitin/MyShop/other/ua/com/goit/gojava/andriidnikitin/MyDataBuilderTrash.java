package ua.com.goit.gojava.andriidnikitin;

/*package ua.com.goit.gojava.andriidnikitin.service;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class DataBuilder {

        private static DataBuilder instance;
        private static Storable storable;
        private static Navigable navigable;
        private static final File FILE = new File("src/main/resources/DataFile.xml");
        
        private DataBuilder() {
        }

        public static synchronized DataBuilder getInstance() throws JAXBException {
                if (instance == null) {
                        instance = new DataBuilder();
                        JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] {StorageImpl.class});
                        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                        storable = (StorageImpl) jaxbUnmarshaller.unmarshal(FILE);   
                        navigable = (StorageImpl) jaxbUnmarshaller.unmarshal(FILE); 
                }
                return instance;
        }

        public Storable getStorage() {
                return storable;
        }
        
        public Navigable getNavigation() {
            return navigable;
    }
                
}*/


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
 






import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.Warehouse;
import ua.com.goit.gojava.andriidnikitin.service.StorageXML;
 
public class MyDataBuilderTrash {
	private Warehouse warehouse;
	public Warehouse createJavaObjectExample1() {
		if (warehouse== null){
			warehouse = new Warehouse();
		/*try {
			store.init();
		} catch (ParseException exception) {
			Logger.getLogger(DataBuilder.class.getName()).
			log(Level.ALL, "ParseException was thrown during creating JavaObjectExample1", exception);
		}
		return store;
		}*/
		}
		return warehouse;
	}
		
 
 	public void marshallExample() {
 		try {
 		   JAXBContext context = JAXBContext.newInstance(Warehouse.class);
 		   Marshaller marshaller = context.createMarshaller();
 		   marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 		   marshaller.marshal(createJavaObjectExample1(), System.out);
 		  } catch (JAXBException exception) {
 		   Logger.getLogger(MyDataBuilderTrash.class.getName()).
 		      log(Level.SEVERE, "marshallExample threw JAXBException", exception);
 		  }
	}

	public void unmarshallExample() {
	    try {
	        JAXBContext context = 
	           JAXBContext.newInstance(Warehouse.class);
	        Marshaller marshaller = 
	           context.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, 
		           Boolean.TRUE);
		 
		        //write XML to an array of bytes
		        ByteArrayOutputStream baos = 
		            new ByteArrayOutputStream();
		        marshaller.marshal(createJavaObjectExample1(), baos);
		 
		        //read XML from array of bytes
		        InputStream bais = 
		           new ByteArrayInputStream(baos.toByteArray());
		        Unmarshaller unmarshaller = 
		           context.createUnmarshaller();
		        Object o = unmarshaller.unmarshal(bais);
		 
		        //prove the Group is recreated
		        StorageXML storeCopy = (StorageXML) o;
		        System.out.println("Objects created from XML:\n");
		        for (Good good : storeCopy.getGoodList()) {
		            System.out.println(good.printInfo());
		        }
		        for (Category category : storeCopy.getCategoryList()) {
		        	System.out.println(category.printInfo());
		        }
		    } catch (JAXBException exception) {
		        Logger.getLogger(MyDataBuilderTrash.class.getName()).
		          log(Level.SEVERE, "marshallExample threw JAXBException", exception);
		    }
		}
}