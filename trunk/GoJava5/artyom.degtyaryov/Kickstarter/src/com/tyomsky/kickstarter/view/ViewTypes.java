package com.tyomsky.kickstarter.view;

public enum ViewTypes {
    Main,
    Category,
    Project,
    Exit;

    private static ViewTypes[] values = values();

    public ViewTypes next() {
        return values[(this.ordinal() + 1) % values.length];
    }
}
