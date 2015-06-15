package kickstarter.model.factory;

import static kickstarter.control.State.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.control.State;
import kickstarter.model.CategoriesModel;
import kickstarter.model.Model;
import kickstarter.model.ProjectModel;
import kickstarter.model.ProjectsModel;
import kickstarter.model.QuoteModel;
import kickstarter.model.dao.ConnectionPoolImpl;
import kickstarter.model.dao.DAO;
import kickstarter.model.dao.DAOImpl;

public class ModelFactory implements AbstractModelFactory {
	private static volatile AbstractModelFactory instance;

	private static final Map<State, Model> states = new HashMap<>();

	private DAO dao;

	static {
		states.put(QUOTE, new QuoteModel());
		states.put(CATEGORIES, new CategoriesModel());
		states.put(PROJECTS, new ProjectsModel());
		states.put(PROJECT, new ProjectModel());
	}

	public static AbstractModelFactory getInstance() {
		if (instance == null) {
			synchronized (ModelFactory.class) {
				if (instance == null) {
					instance = new ModelFactory();
				}
			}
		}
		return instance;
	}

	private ModelFactory() {
		try {
			this.dao = new DAOImpl(ConnectionPoolImpl.getInstance());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Model getModel(State state) {
		Model model = states.get(state);
		model.init(dao);
		return model;
	}
}
