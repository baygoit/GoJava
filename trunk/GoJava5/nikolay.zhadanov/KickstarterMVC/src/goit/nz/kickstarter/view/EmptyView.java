package goit.nz.kickstarter.view;

import goit.nz.kickstarter.model.Model;

public class EmptyView extends ConsoleView {

	public EmptyView(Model model){
		super(model);
	}
	
	@Override
	public void createLayout() {
		this.layout.append("Nothing to show...");
	}
}
