package view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pool.KickstarterException;

public interface iView {

		void forward(HttpServletRequest request, HttpServletResponse response) throws KickstarterException;
}
