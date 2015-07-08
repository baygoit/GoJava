package goit.nz.kickstarter.model;

import goit.nz.kickstarter.dao.Project;
import goit.nz.kickstarter.dao.ProjectList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProjectsModel extends Model {
	private ProjectList projects;

	public ProjectsModel(String type, ProjectList projects, String name) {
		super(type, name);
		this.projects = projects;
	}

	@Override
	public int size() {
		return projects.size();
	}

	@Override
	public Map<Integer, Map<String, String>> getData() {
		Map<Integer, Map<String, String>> result = new HashMap<Integer, Map<String, String>>();
		for (int index = 0; index < size(); index++) {
			Map<String, String> info = new LinkedHashMap<String, String>();
			Project current = projects.getProject(index);
			ArrayList<String> fields = projects.getFields();
			int fieldCount = 0;
			info.put(fields.get(fieldCount++), current.getName());
			info.put(fields.get(fieldCount++), current.getDescription());
			info.put(fields.get(fieldCount++), String.valueOf(current.getRequiredAmount()));
			info.put(fields.get(fieldCount++), String.valueOf(current.getCollectedAmount()));
			info.put(fields.get(fieldCount++), String.valueOf(current.getDaysLeft()));
			result.put(index + 1, info);
		}
		return result;
	}
}
