package ua.com.goit.gojava.POM.presentation.beans.profitcost;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

//import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.ProfitLostsType;


@RequestScoped
@ManagedBean
public class CostItemTypeAutoCompleter implements Serializable{

	private static final long serialVersionUID = 1L;
	//private static final Logger LOG = Logger.getLogger(CostItemTypeAutoCompleter.class);

	public List<ProfitLostsType> completeText(String query) {

		List<ProfitLostsType> result = new ArrayList<>();
		result.add(ProfitLostsType.LOSTS);
		result.add(ProfitLostsType.PROFIT);
		result.add(0, null);
		return result;
    }
}
