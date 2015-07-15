package goit.nz.kickstartermvc;

import goit.nz.kickstartermvc.input.InputListener;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher implements InputListener {

	private List<DispatcherListener> controllerListeners;
	private int currentListener;

	public Dispatcher() {
		controllerListeners = new ArrayList<>();
	}

	public void registerListener(DispatcherListener listener) {
		controllerListeners.add(listener);
	}

	public int onInput(String input) {
		int move = controllerListeners.get(currentListener).onInput(input);
		currentListener += move;
		if (currentListener >= 0) {
			controllerListeners.get(currentListener).onTakeControl(move);
		}
		return currentListener;
	}
}
