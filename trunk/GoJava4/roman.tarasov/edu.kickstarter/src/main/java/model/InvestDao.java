package model;

import static view.eViews.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.ViewStrategy;
import view.iView;
import dao.pool.KickstarterException;

public class InvestDao implements iModel{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		iView view = ViewStrategy.getInstance().selectView(INVEST_V);
		view.forward(request, response);
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		// TODO Auto-generated method stub
		
	}

}
