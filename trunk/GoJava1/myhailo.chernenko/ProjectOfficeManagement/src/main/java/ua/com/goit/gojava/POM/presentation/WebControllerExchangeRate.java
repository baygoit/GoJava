package ua.com.goit.gojava.POM.presentation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.common.ExchangeRate;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.ExchangeRateService;
import ua.com.goit.gojava.POM.services.POMServicesException;

@WebServlet(urlPatterns = {"/ExchangeRateWebController"})
public class WebControllerExchangeRate extends HttpServlet {

	private static final long serialVersionUID = 877563483782135575L;
	private static final Logger LOG=Logger.getLogger(WebControllerExchangeRate.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		if (req.getParameter("AddNew") != null) {
			
			createExchangeRate(req);
			
		} else if (req.getParameter("DellCurrent")!=null) {
		
			deleteExchangeRate(req);
			
		} else if (req.getParameter("EditCurrent")!=null) {
			
			loadExchangeRateForEdit(req);
		
		} else if (req.getParameter("Edit")!=null) {
			
			updateExchangeRate(req);
			
		} else if (req.getParameter("UndoEdit")!=null) {
			
			req.getSession(false).setAttribute("currentRateForEdit", null);
		
		}
		
		//req.getRequestDispatcher("ExchangeRates.jsp").forward(req, resp);
		resp.sendRedirect(req.getHeader("referer"));
		
	}

	private void loadExchangeRateForEdit(HttpServletRequest req) {
		
		ExchangeRateService exchangeRateService = ApplicationContextProvider.getApplicationContext().getBean(ExchangeRateService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("EditCurrent"));
			ExchangeRate exchangeRate = exchangeRateService.retrieveById(id);
			req.getSession(false).setAttribute("currentRateForEdit", exchangeRate);
			
		} catch (POMServicesException | NumberFormatException e) {

			LOG.error("Can not load Exchange Rate for edit: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not load Exchange Rate for edit: "+e.getMessage());
			return;	
		}
		
	}

	private void deleteExchangeRate(HttpServletRequest req) {
		
		ExchangeRateService exchangeRateService = ApplicationContextProvider.getApplicationContext().getBean(ExchangeRateService.class);
		try {
			
			long id = Long.parseLong(req.getParameter("DellCurrent"));

			exchangeRateService.delete(exchangeRateService.retrieveById(id));
			
		} catch (POMServicesException | NumberFormatException e) {

			LOG.error("Can not delete Exchange Rate: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not delete Exchange Rate: "+e.getMessage());
			return;	
		}
		
	}

	private void createExchangeRate(HttpServletRequest req) {
		
		String dateString = req.getParameter("date");
		String fromCurrencyCode = req.getParameter("fromCurrency");
		String toCurrencyCode = req.getParameter("toCurrency");
		String rateString = req.getParameter("rate");
		String multiplicityString = req.getParameter("multiplicity");
		
		ExchangeRate newRate = new ExchangeRate();
		
		try {
			
			String pattern = (dateString.length() == 10) ? "yyyy-MM-dd" : "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
			newRate.setDate(dateFormatter.parse(dateString));
			
			if(!fromCurrencyCode.isEmpty()) {
				newRate.setFromCurrency(Currency.getInstance(fromCurrencyCode));
			}
			if(!toCurrencyCode.isEmpty()) {
				newRate.setToCurrency(Currency.getInstance(toCurrencyCode));
			}
			
			newRate.setRate(Long.parseLong(rateString));
			newRate.setMultiplicity(Long.parseLong(multiplicityString));
			
			
		} catch (ParseException | IllegalArgumentException e)   {

			LOG.error("Could not create new Exchange Rate: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not create new Exchange Rate: "+e.getMessage());
			return;
			
		}
		
		ExchangeRateService exchangeRateService = ApplicationContextProvider.getApplicationContext().getBean(ExchangeRateService.class);
		try {
			
			exchangeRateService.create(newRate);
			
		} catch (POMServicesException e) {

			LOG.error("Can not save new Exchange Rate: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Can not save new Exchange Rate: "+e.getMessage());
			return;	
		}
	}
	
	private void updateExchangeRate(HttpServletRequest req) {
		
		String dateString = req.getParameter("date");
		String fromCurrencyCode = req.getParameter("fromCurrency");
		String toCurrencyCode = req.getParameter("toCurrency");
		String rateString = req.getParameter("rate");
		String multiplicityString = req.getParameter("multiplicity");
		
		ExchangeRate exchangeRate = (ExchangeRate) req.getSession(false).getAttribute("currentRateForEdit");
		
		try {
			
			String pattern = (dateString.length() == 10) ? "yyyy-MM-dd" : "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
			exchangeRate.setDate(dateFormatter.parse(dateString));
			
			if(!fromCurrencyCode.isEmpty()) {
				exchangeRate.setFromCurrency(Currency.getInstance(fromCurrencyCode));
			}
			if(!toCurrencyCode.isEmpty()) {
				exchangeRate.setToCurrency(Currency.getInstance(toCurrencyCode));
			}
			
			exchangeRate.setRate(Long.parseLong(rateString));
			exchangeRate.setMultiplicity(Long.parseLong(multiplicityString));
			
			ExchangeRateService exchangeRateService = ApplicationContextProvider.getApplicationContext().getBean(ExchangeRateService.class);
			exchangeRateService.update(exchangeRate);
			
		} catch (POMServicesException | ParseException | NumberFormatException e)   {

			LOG.error("Could not update Exchange Rate: "+e.getMessage(),e);
			req.getSession(false).setAttribute("errorMessage", "Could not update Exchange Rate: "+e.getMessage());
			return;
			
		}
		
		req.getSession(false).setAttribute("currentRateForEdit", null);
		
	}

}
