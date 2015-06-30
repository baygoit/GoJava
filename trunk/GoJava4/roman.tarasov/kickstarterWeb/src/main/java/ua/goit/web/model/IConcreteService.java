package ua.goit.web.model;

import javax.servlet.http.HttpServletRequest;
import ua.goit.web.model.dao.KickstarterException;

public interface IConcreteService {

	String getJspName();

	void setAttributesForDoGet(HttpServletRequest request)
			throws KickstarterException;

	void setAttributesForDoPost(HttpServletRequest request)
			throws KickstarterException;

}
