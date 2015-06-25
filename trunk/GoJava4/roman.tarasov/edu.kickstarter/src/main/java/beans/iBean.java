package beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.pool.KickstarterException;

public interface iBean {

	void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException;

	void doPost(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException;
}
