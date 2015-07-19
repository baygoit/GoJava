package goit.nz.kickstartermvc;

import goit.nz.kickstartermvc.input.InputListener;

public interface DispatcherListener extends InputListener {

	void onTakeControl();
}
