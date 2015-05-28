package com.morkva.ui.controllers;

import com.morkva.ui.ViewType;

/**
 * Created by vladyslav on 22.05.15.
 */
public interface IController {
    void showView();
    ViewType readInput();
}
