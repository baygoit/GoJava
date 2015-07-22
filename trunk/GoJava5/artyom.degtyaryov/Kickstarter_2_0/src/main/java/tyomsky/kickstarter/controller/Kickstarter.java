package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.dao.CategoriesDAO;
import tyomsky.kickstarter.dao.Projects;
import tyomsky.kickstarter.model.Category;
import tyomsky.kickstarter.model.Project;
import tyomsky.kickstarter.model.QuoteGenerator;
import tyomsky.kickstarter.ui.IO;

import java.util.ArrayList;
import java.util.List;

public class Kickstarter {

    private IO io;
    private CategoriesDAO categories;
    private Projects projects;
    private QuoteGenerator quoteGenerator;

    public Kickstarter(CategoriesDAO categories, Projects projects, IO io, QuoteGenerator quoteGenerator) {
        this.categories = categories;
        this.projects = projects;
        this.io = io;
        this.quoteGenerator = quoteGenerator;
    }

    public void run() {
        String quote = quoteGenerator.getQuote();
        io.println(quote);
        new CategoriesMenu(categories, projects, io).run();
    }

}
