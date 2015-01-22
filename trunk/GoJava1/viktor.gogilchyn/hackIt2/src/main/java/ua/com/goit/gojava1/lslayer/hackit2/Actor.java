package ua.com.goit.gojava1.lslayer.hackit2;

import ua.com.goit.gojava1.lslayer.hackit2.dto.CommandResult;

public interface Actor {
    public CommandResult act(Action action, Gear equipment);
}
