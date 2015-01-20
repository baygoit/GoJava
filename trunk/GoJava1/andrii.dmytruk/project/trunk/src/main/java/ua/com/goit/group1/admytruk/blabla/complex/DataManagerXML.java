package ua.com.goit.group1.admytruk.blabla.complex;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

public class DataManagerXML extends DataManagerAbstract {

	private static final JAXBContext JAXB_CONTEXT;
	
	private final List<Category> categoryList = new ArrayList<Category>();
	
	private List<Product> productList = new ArrayList<Product>();
	
	// Для упрощения я сохраняю имя источника как константу!!!
	// на практике так не делается.
	private static final String SOURCE_FILE_NAME = "data.xml";
	
	static {
		try {
				// такую структуру нужно использовать осторожно,
			    // так как в случае возникновения ошибки - "завалится" все приложение
				// я ее реализовал для упрощения,
				// В многопоточном приложении JAXB_CONTEXT лучше держать в единственном екземпляре!
				JAXB_CONTEXT = JAXBContext.newInstance(						
						Category.class
						, Product.class
						, Warehouse.class);
		} catch (Exception e) {
			throw new RuntimeException("Failed create JAXBContext. " + e.getMessage(), e);
		}
	}
	
	public DataManagerXML() {	 
	}
		
	@Override
	public List<Category> getCategoryList() {
		return this.categoryList;
	}
	
	@Override
	protected List<Product> getProductList() {
		return this.productList;
	}

	protected void init() {
		try {
			 	final Unmarshaller unmarshaller = JAXB_CONTEXT.createUnmarshaller();
			 	final InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(SOURCE_FILE_NAME);
			 	Warehouse warehouse = unmarshaller.unmarshal(new StreamSource(is), Warehouse.class).getValue();			 	
			 	this.categoryList.addAll(warehouse.getCategoryList());
			 	this.productList.addAll(warehouse.getProductList());
		} catch (Exception e) {
			throw new RuntimeException(
						"Failed init " + DataManagerXML.class.getSimpleName()
						+ ". " + e.getMessage(), e);
		}
	}

}
