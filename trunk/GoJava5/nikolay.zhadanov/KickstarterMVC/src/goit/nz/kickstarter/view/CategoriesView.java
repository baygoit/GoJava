package goit.nz.kickstarter.view;

import goit.nz.kickstarter.model.Model;

import java.util.Map;

public class CategoriesView extends ConsoleView {
	
	public CategoriesView(Model model) {
		super(model);
	}

	@Override
	public void createLayout() {
		Map<Integer, Map<String, String>> rawData = this.model.getData();
		this.layout.append(model.getName());
		this.layout.append("\n");
		for (Map.Entry<Integer, Map<String, String>> index : rawData.entrySet()) {
			int count = index.getKey(); 
			Map<String, String> info = index.getValue();
			for (Map.Entry<String, String> pair : info.entrySet()){
				this.layout.append("[");
				this.layout.append(String.valueOf(count));
				this.layout.append(" - ");
				this.layout.append(pair.getKey());
				this.layout.append("]");
				this.layout.append("\n");
			}
		}
	}
}
