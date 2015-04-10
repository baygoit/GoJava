package ua.com.goit.gojava.POM.presentation.beans.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//import org.apache.log4j.Logger;

@SessionScoped
@ManagedBean
public class CurrencyAutoCompleter implements Serializable{

	private static final long serialVersionUID = 1L;
	//private static final Logger LOG = Logger.getLogger(CurrencyAutoCompleter.class);

	public List<Currency> completeText(String query) {

		List<Currency> result = new ArrayList<Currency>();
		result.addAll(Currency.getAvailableCurrencies());
		if(!query.isEmpty()){
			for(int i = result.size() - 1 ; i >= 0 ; i--){
				Currency currency = result.get(i);
				if(!currency.getCurrencyCode().startsWith(query)){
					result.remove(i);
				}
			}
		}
		return result;
    }
}
