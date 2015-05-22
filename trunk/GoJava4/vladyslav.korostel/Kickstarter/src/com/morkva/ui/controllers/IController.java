package com.morkva.ui.controllers;

import com.morkva.ui.CommandType;

/**
 * Created by vladyslav on 22.05.15.
 */
public interface IController {
    void showView();
    CommandType readInput();
}
