package ua.com.goit.gojava.andriidnikitin.service;

import java.util.ArrayList;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;

public class MapAdapter extends XmlAdapter<String, Map<Category, ArrayList<Good>>>  {

	@Override
	public String marshal(Map<Category, ArrayList<Good>> arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Category, ArrayList<Good>> unmarshal(String arg0)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
