package com.epic.app.controllers;

import com.epic.app.service.QuestionService;
import org.springframework.context.annotation.Scope;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * for output employees level
 */
@Named
@Scope("session")
public class PackMB {

    @Inject
    private QuestionService questionService;

    private String name = "Старший продавець";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
