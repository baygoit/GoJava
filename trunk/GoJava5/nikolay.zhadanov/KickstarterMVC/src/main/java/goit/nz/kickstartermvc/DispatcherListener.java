package goit.nz.kickstartermvc;

import goit.nz.kickstartermvc.input.ConsoleInputListener;

public interface DispatcherListener extends ConsoleInputListener {

	void onTakeControl();
}
