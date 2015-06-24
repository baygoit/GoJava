package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pool.KickstarterException;

public interface iModel {

	void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException;

	void doPost(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException;
}
