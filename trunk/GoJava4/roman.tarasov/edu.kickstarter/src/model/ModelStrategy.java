package model;

public class ModelStrategy {
	private volatile static ModelStrategy uniqueInstance;
	private static MainDao mainDao;
	private static DetailedProjectDao detailedProjectDao;
	private static ProjectsDao projectsDao;
	private static LoginDao loginDao;

	private ModelStrategy() {
	}

	public static ModelStrategy getInstance() {
		if (uniqueInstance == null) {
			synchronized (ModelStrategy.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new ModelStrategy();
					mainDao = new MainDao();
					detailedProjectDao = new DetailedProjectDao();
					projectsDao=new ProjectsDao();
					loginDao=new LoginDao();
				}
			}
		}
		return uniqueInstance;
	}

	public iModel getModel(eModels selectedModel) {
		iModel imodel = null;
		switch (selectedModel) {
		case MAIN_M:
			imodel = mainDao;
			break;
		case PROJECT_M:
			imodel = detailedProjectDao;
			break;
		case PROJECTS_M:
			imodel = projectsDao;
			break;
		case LOGIN_M:
			imodel = loginDao;
			break;
		default:
			break;
		}
		return imodel;
	}
}
