package model;

import java.util.HashMap;
import model.eModels;

public class ModelStrategy {
	private volatile static ModelStrategy uniqueInstance;
	private static HashMap<eModels, iModel> models;

	private ModelStrategy() {
	}

	public static ModelStrategy getInstance() {
		if (uniqueInstance == null) {
			synchronized (ModelStrategy.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new ModelStrategy();
					models = new HashMap<eModels, iModel>();

					models.put(eModels.MAIN_M, new MainDao());
					models.put(eModels.PROJECT_M, new DetailedProjectDao());
					models.put(eModels.PROJECTS_M, new ProjectsDao());
					models.put(eModels.LOGIN_M, new LoginDao());
					models.put(eModels.DONATE_M, new DonateDao());
					models.put(eModels.INVEST_M, new InvestDao());
					models.put(eModels.COMMENT_M, new CommentDao());
					models.put(eModels.COMMENT_FORM_M, new CommentFormDao());
				}
			}
		}
		return uniqueInstance;
	}

	public synchronized iModel getModel(eModels selectedModel) {
		return models.get(selectedModel);
	}
}
