package ua.com.goit.gojava1.lslayer.hackit2;

import ua.com.goit.gojava1.lslayer.hackit2.dto.CommandResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.Skill;

public interface Actor {
    public CommandResult act(Action action);
    public CommandResult act(Action action, Gear equipment);
}
