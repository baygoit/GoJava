package com.go_java4.alex_mirn.logic;

import java.io.IOException;

import com.go_java4.alex_mirn.dao.Dao;
import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.logic.Logic;
import com.go_java4.alex_mirn.input_output.pages.OneProjectPage;


public class OneProjectLogic implements Logic {
	private Dao repository;

	public OneProjectLogic(Dao repository) {
		this.repository = repository;
	}
}
