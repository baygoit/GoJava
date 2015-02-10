package ua.com.goit.gojava.andriidnikitin;

import java.math.BigDecimal;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BigDecimalAdapter extends XmlAdapter<String, BigDecimal> {

	@Override
	public String marshal(BigDecimal arg0) throws Exception {
		if (arg0 == null){
			return null;
		}
		return '$' + arg0.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString();
	}

	@Override
	public BigDecimal unmarshal(String arg0) throws Exception {
		if (arg0 == null){
			return null;
		}
		return new BigDecimal(arg0.substring(1)).setScale(2, BigDecimal.ROUND_HALF_DOWN);
	}

}
