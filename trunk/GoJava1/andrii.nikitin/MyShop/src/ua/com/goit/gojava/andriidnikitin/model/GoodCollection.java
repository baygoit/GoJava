package ua.com.goit.gojava.andriidnikitin.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GoodCollection {
	private List<Good> list;
	
	@XmlElementWrapper(name = "goodMap")
	@XmlElement(name = "category")
	public List<Good> getList() {
		if (list == null){
			return new ArrayList<Good>();
		}
		return list;
	}

	public void setList(List<Good> list) {
		this.list = list;
	}
}
