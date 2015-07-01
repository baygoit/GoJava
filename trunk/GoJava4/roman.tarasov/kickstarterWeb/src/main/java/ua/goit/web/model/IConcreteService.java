package ua.goit.web.model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import ua.goit.web.model.dao.IDao;
import ua.goit.web.model.dao.KickstarterException;
@Component
public interface IConcreteService {

	String getJspName();

	void setAttributesForDoGet(HttpServletRequest request)
			throws KickstarterException;

	void setAttributesForDoPost(HttpServletRequest request)
			throws KickstarterException;

	void setDao(IDao dao);

}
