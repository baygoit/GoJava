package goit.nz.kickstarter.view;

import goit.nz.kickstarter.model.Model;

import java.util.Map;

public class QuoteView extends ConsoleView {

	public QuoteView(Model model) {
		super(model);
	}

	@Override
	public void createLayout() {
		Map<Integer, Map<String, String>> rawData = this.model.getData();
		Map<String, String> info = rawData.get(rawData.size());
		for (Map.Entry<String, String> pair : info.entrySet()){
			this.layout.append(pair.getKey());
			this.layout.append("\n");
			this.layout.append("(c) ");
			this.layout.append(pair.getValue());
			this.layout.append("\n");
		}
	}
}
