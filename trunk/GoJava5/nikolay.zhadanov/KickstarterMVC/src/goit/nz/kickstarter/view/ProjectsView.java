package goit.nz.kickstarter.view;

import goit.nz.kickstarter.model.Model;

import java.util.Map;

public class ProjectsView extends ConsoleView {
	
	public ProjectsView(Model model) {
		super(model);
	}

	@Override
	public void createLayout() {
		Map<Integer, Map<String, String>> rawData = this.model.getData();
		this.layout.append(model.getName());
		this.layout.append("\n");
		for (Map.Entry<Integer, Map<String, String>> index : rawData.entrySet()) {
			int count = index.getKey(); 
			this.layout.append(String.valueOf(count));
			this.layout.append(" - ");
			Map<String, String> info = index.getValue();
			boolean firstRow = true;
			for (Map.Entry<String, String> pair : info.entrySet()){
				if (firstRow) {
					this.layout.append(pair.getValue());
					this.layout.append("\n");
					firstRow = !firstRow;
				} else {
					this.layout.append(pair.getKey());
					this.layout.append(pair.getValue());
					this.layout.append("\n");
				}
			}
		}
	}

}
