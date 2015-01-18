package ua.lslayer.hackit.computers;

import ua.lslayer.hackit.Action;
import ua.lslayer.hackit.computers.hardware.Hardware;

public interface Computable {
	public void execute(Action action);
	public void placeHardware(Hardware item);
}
