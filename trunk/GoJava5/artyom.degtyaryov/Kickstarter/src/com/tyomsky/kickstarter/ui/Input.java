package com.tyomsky.kickstarter.ui;

import com.tyomsky.kickstarter.mvc.controller.InputListener;

public interface Input {

	void listenInput();

    void setInputListener(InputListener inputListener);

}
