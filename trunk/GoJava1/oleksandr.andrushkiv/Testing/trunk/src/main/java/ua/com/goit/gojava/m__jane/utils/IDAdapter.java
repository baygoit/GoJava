package ua.com.goit.gojava.m__jane.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IDAdapter extends XmlAdapter<String, Integer> {

	@Override
	public Integer unmarshal(String v) throws Exception {
		if (v == null) {
			return null;
		}
		return Integer.parseInt(v);
	}

	@Override
	public String marshal(Integer v) throws Exception {
		if (v == null) {
			return null;
		}
		return v.toString();
	}

}
