package ua.com.goit.gojava7.kickstarter.handlers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validator {

	public void validateUserName(String userName, HttpServletRequest request, HttpServletResponse response) {
		if (userName.isEmpty()) {
			request.setAttribute("errors", true);
			request.setAttribute("nameError", true);
		}
	}

	public void validateCreditCardNumber(String creditCardNumber, HttpServletRequest request, HttpServletResponse response) {
		String regex = "\\d{13,16}";
		Pattern pattern = Pattern.compile(regex);

		if (creditCardNumber.isEmpty()) {
			request.setAttribute("errors", true);
			request.setAttribute("creditCardError", true);

		} else {
			try {
				Long.parseLong(creditCardNumber);
			} catch (NumberFormatException e) {
				request.setAttribute("errors", true);
				request.setAttribute("creditCardError", true);
			}

			Matcher matcher = pattern.matcher(creditCardNumber);
			if (matcher.matches() == false) {
				request.setAttribute("errors", true);
				request.setAttribute("creditCardError", true);
			}
		}
	}

	public void validateDonatingSum(String pledge, HttpServletRequest request, HttpServletResponse response) {
		if (pledge.isEmpty()) {
			request.setAttribute("errors", true);
			request.setAttribute("donatingSumError", true);

		} else {
			try {
				Integer.parseInt(pledge);
			} catch (NumberFormatException e) {
				request.setAttribute("errors", true);
				request.setAttribute("donatingSumError", true);
			}
		}
	}
}
