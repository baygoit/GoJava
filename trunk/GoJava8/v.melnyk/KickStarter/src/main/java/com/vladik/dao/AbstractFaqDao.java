package com.vladik.dao;

import java.util.List;

import com.vladik.model.Faq;
import com.vladik.model.Project;

public abstract class AbstractFaqDao {

    public final String SEMICOLON_DELIMITER = ";";
    public final String NEW_LINE_SEPARATOR = "\n";

    public abstract void add(Faq element);

    public abstract void remove(Faq element);

    public abstract List<Faq> getAll();

    public abstract int getSize();

    public abstract String getProjectFaqs(Project project);


}
