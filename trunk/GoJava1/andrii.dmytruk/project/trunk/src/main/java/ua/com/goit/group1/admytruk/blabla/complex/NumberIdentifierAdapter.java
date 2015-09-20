package ua.com.goit.group1.admytruk.blabla.complex;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class NumberIdentifierAdapter extends XmlAdapter<String, Integer> {

	@Override
	public Integer unmarshal(String arg0) throws Exception {
		if (arg0 == null) {
			return null;
		}
		return Integer.parseInt(arg0.substring(3));
	}

	@Override
	public String marshal(Integer arg0) throws Exception {
		if (arg0 == null) {
			return null;
		}
		return "id=" + arg0.toString();
	}

}
