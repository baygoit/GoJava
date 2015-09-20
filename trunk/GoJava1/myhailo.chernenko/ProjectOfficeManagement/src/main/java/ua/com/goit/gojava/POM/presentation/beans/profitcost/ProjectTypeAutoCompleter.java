package ua.com.goit.gojava.POM.presentation.beans.profitcost;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

//import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectType;


@RequestScoped
@ManagedBean
public class ProjectTypeAutoCompleter implements Serializable{

	private static final long serialVersionUID = 1L;
	//private static final Logger LOG = Logger.getLogger(CostItemTypeAutoCompleter.class);

	public List<ProjectType> completeText(String query) {

		List<ProjectType> result = new ArrayList<>();
		result.add(ProjectType.INNER);
		result.add(ProjectType.OUTER);
		result.add(0, null);
		return result;
    }
}
