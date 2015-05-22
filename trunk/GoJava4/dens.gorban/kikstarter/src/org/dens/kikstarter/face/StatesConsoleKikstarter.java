package org.dens.kikstarter.face;

import org.dens.kikstarter.IConsoleKikstarter;

public class StatesConsoleKikstarter implements ViewState, IConsoleKikstarter{
		
	private View view;
	
	public StatesConsoleKikstarter() {
		this.view = new CitationView();
	}
	
	@Override
	public void start(){		
		while(true){			
			view.printInfo();
			view.action(this);			
		}
	}


	@Override
	public void setView(View view) {
		this.view = view;		
	}

}
