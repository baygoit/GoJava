package ua.com.goit.gojava1.lslayer.hackit2;

import ua.com.goit.gojava1.lslayer.hackit2.dto.CommandResult;

public interface Action {
    public CommandResult performAction();
    public CommandResult performAction(Gear gear);
}
