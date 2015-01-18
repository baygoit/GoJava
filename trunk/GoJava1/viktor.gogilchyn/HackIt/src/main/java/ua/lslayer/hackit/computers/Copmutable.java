package ua.lslayer.hackit.computers;

import ua.lslayer.hackit.Action;
import ua.lslayer.hackit.computers.hardware.Hardware;

public interface Copmutable {
	public void execute(Action action);
	public void placeHardware(Hardware item);
}
