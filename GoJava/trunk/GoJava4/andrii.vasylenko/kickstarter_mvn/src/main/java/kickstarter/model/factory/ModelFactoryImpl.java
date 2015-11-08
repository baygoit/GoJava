package kickstarter.model.factory;

import static kickstarter.control.state.State.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import kickstarter.control.state.State;
import kickstarter.exception.IncorrectInputException;
import kickstarter.model.CategoriesModel;
import kickstarter.model.Model;
import kickstarter.model.ProjectModel;
import kickstarter.model.ProjectsModel;
import kickstarter.model.QuoteModel;
import kickstarter.model.dao.DAO;
import kickstarter.model.dao.DAOImpl;
import kickstarter.model.dao.connection.ConnectionPoolImpl;

public class ModelFactoryImpl implements ModelFactory {
	private static volatile ModelFactory instance;

	private static final Map<State, Model> states = new HashMap<>();

	private DAO dao;

	static {
		states.put(QUOTE, new QuoteModel());
		states.put(CATEGORIES, new CategoriesModel());
		states.put(PROJECTS, new ProjectsModel());
		states.put(PROJECT, new ProjectModel());
	}

	public static ModelFactory getInstance() {
		if (instance == null) {
			synchronized (ModelFactoryImpl.class) {
				if (instance == null) {
					instance = new ModelFactoryImpl();
				}
			}
		}
		return instance;
	}

	private ModelFactoryImpl() {
		try {
			this.dao = new DAOImpl(ConnectionPoolImpl.getInstance());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Model getModel(State state) throws IncorrectInputException {
		if (state == null) {
			throw new IncorrectInputException("state is null");
		}

		Model model = states.get(state);
		model.init(dao);
		return model;
	}
}
