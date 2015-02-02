package ua.com.goit.gojava.andriidnikitin.service;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.transform.stream.StreamSource;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.Warehouse;

public class StorageXML extends StorageAbstract {

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Good> getGoodList() {
		// TODO Auto-generated method stub
		return null;
	}
}