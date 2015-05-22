package org.dens.kikstarter.face;

import org.dens.kikstarter.IConsoleKikstarter;

public class StatesConsoleKikstarter implements ViewState, IConsoleKikstarter{
		
	private View view;
	
	public StatesConsoleKikstarter(View view) {
		this.view = view;
	}
	@Override
	public void start(){		
		while(true){			
			doStep();		
		}
	}

	private void doStep() {
		view.printInfo();
		view.action(this);			
	}

	@Override
	public void setView(View view) {
		this.view = view;		
	}

}
