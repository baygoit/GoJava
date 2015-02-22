package ua.home.kickstarter.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import ua.home.kickstarter.content.Project;
import ua.home.kickstarter.factory.DaoFactory;

import ua.home.kickstarter.model.ProjectsDao;

public class ProjectsController {
	private DaoFactory daoFactory;

	public ProjectsController() {
		daoFactory = new DaoFactory();
	}

	public int getSpecificCategorySize(int categoryId) {
		int size = -1;
		try (Connection con = daoFactory.getConnection()) {
			ProjectsDao projectsDao = daoFactory.getProjectsDao(con);
			size = (int) projectsDao.projectSizeByCategoryId(categoryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return size;
	}

	public List<Project> getProjectsFromDB(int categoryId) {
		List<Project> list = null;
		try (Connection con = daoFactory.getConnection()) {
			ProjectsDao projectsDao = daoFactory.getProjectsDao(con);
			list = projectsDao.getProjectsByCategoryId(categoryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Project getSpecificProjectFromDB(int categoryId, int projectIndex) {
		Project project = null;
		try (Connection con = daoFactory.getConnection()) {
			ProjectsDao projectsDao = daoFactory.getProjectsDao(con);
			project = projectsDao.getProjectsByIdAndCategoryId(categoryId, projectIndex);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}

	public void updateProject(int projectId, String columnName, int amount) {
		try (Connection con = daoFactory.getConnection()) {
			ProjectsDao projectsDao = daoFactory.getProjectsDao(con);
			projectsDao.updateProject(projectId, columnName, amount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getContent(int categoryId) {
		StringBuilder projectsContent = new StringBuilder();
		int temporaryCounter = 1;
		for (Project project : getProjectsFromDB(categoryId)) {
			projectsContent.append(temporaryCounter).append(getShortInfo(project));
			temporaryCounter++;
		}
		return projectsContent.toString();
	}

	public String getSpecificProject(int categoryId, int projectIndex) {
		StringBuilder projectsContent = new StringBuilder();
		projectsContent.append(getFullInfo(getSpecificProjectFromDB(categoryId, projectIndex)));
		return projectsContent.toString();
	}

	public String getShortInfo(Project project) {
		StringBuilder shortInfo = new StringBuilder();
		shortInfo.append(" - ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓").append("\nНазвание проекта: ")
				.append(project.getName()).append("\nОписание проекта: ").append(project.getDescription())
				.append("\nНеобходимая сумма: ").append(project.getGoal()).append("$").append("\nУже собрали: ")
				.append(project.getPledged()).append("$").append("\nДо окончания сбора средств: ")
				.append(project.getDaysLeft()).append(" дней\n");
		return shortInfo.toString();
	}

	public String getFullInfo(Project project) {
		StringBuilder fullInfo = new StringBuilder();
		fullInfo.append(getShortInfo(project)).append("История проекта: ").append(project.getHistory())
				.append("\nЛинки на видео с демо: ").append(project.getLinksToVideo()).append("\nВопросы/ответы: ")
				.append(project.getQuestionAnswers());
		return fullInfo.toString();
	}
}
