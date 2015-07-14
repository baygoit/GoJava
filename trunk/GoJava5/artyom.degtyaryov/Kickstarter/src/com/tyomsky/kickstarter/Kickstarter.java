package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.ui.Input;

public class Kickstarter {

    private Dispatcher dispatcher;
    Input input;

    public void init(Input input, Dispatcher dispatcher) {
        this.input = input;
        this.dispatcher = dispatcher;
    }

    public void run() {
        dispatcher.onApplicationStart();
        while (true) {
            input.listenInput();
        }
    }

}