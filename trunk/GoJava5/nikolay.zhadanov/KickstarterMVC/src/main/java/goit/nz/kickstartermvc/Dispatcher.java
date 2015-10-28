package goit.nz.kickstartermvc;

import goit.nz.kickstartermvc.input.ConsoleInputListener;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher implements ConsoleInputListener {

	private List<DispatcherListener> controllerListeners;
	private int currentListenerIndex;

	public Dispatcher() {
		controllerListeners = new ArrayList<>();
	}

	public void registerListener(DispatcherListener listener) {
		controllerListeners.add(listener);
	}

	public int onInput(String input) {
		int move = controllerListeners.get(currentListenerIndex).onInput(input);
		currentListenerIndex += move;
		if (currentListenerIndex >= 0) {
			controllerListeners.get(currentListenerIndex).onTakeControl();
		}
		return currentListenerIndex;
	}
	
	public int getControllerListenersCount() {
		return controllerListeners.size();
	}
}
