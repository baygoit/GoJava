package beans;

import static view.eViews.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.ViewDispatcher;
import view.ViewStrategy;
import dao.pool.KickstarterException;

public class Invest implements iBean{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		ViewDispatcher selectedView = ViewStrategy.getInstance().selectView(INVEST_V);
		selectedView.forward(request, response);
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		// TODO Auto-generated method stub
		
	}

}
