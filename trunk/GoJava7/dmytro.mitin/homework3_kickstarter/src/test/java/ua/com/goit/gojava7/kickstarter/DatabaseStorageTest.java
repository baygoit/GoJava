package ua.com.goit.gojava7.kickstarter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Kickstarter;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Quote;
import ua.com.goit.gojava7.kickstarter.model.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.DatabaseCategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.DatabaseQuoteStorage;
import ua.com.goit.gojava7.kickstarter.model.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.util.ConsoleMock;
import ua.com.goit.gojava7.kickstarter.view.ConsoleView;
import ua.com.goit.gojava7.kickstarter.view.View;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DatabaseStorageTest {

    private PrintStream oldOut;

    private ByteArrayOutputStream out;

    private InputStream oldIn;

    private ConsoleMock.ConfigurableInputStream in;

    private String quoteTable = "test_quotes";

    private String projectTable = "test_projects";

    private String categoryTable = "test_categories";

    private Connection connection;

    @Before
    public void setUp() {
        oldIn = System.in;

        in = new ConsoleMock.ConfigurableInputStream();

        oldOut = System.out;

        out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        String quoteTableCreateQuery = "CREATE TABLE " + quoteTable + "\n" +
                "(\n" +
                "  id integer NOT NULL DEFAULT nextval('test_quote_sequence'),\n" +
                "  text text,\n" +
                "  author text,\n" +
                "  CONSTRAINT test_quotes_pkey PRIMARY KEY (id)\n" +
                ")\n";
        String categoryTableCreateQuery = "CREATE TABLE " + categoryTable + "\n" +
                "(\n" +
                "  id integer NOT NULL DEFAULT nextval('test_category_sequence'),\n" +
                "  name text,\n" +
                "  CONSTRAINT test_categories_pkey PRIMARY KEY (id)\n" +
                ")";
        String projectTableCreateQuery = "CREATE TABLE " + projectTable + "\n" +
                "(\n" +
                "  id integer NOT NULL DEFAULT nextval('test_project_sequence'),\n" +
                "  name text,\n" +
                "  category text,\n" +
                "  \"shortDescription\" text,\n" +
                "  description text,\n" +
                "  history text,\n" +
                "  \"videoUrl\" text,\n" +
                "  \"moneyNeeded\" integer,\n" +
                "  \"moneyDonated\" integer,\n" +
                "  \"daysLeft\" integer,\n" +
                "  questions text[],\n" +
                "  benefits text[],\n" +
                "  CONSTRAINT test_projects_pkey PRIMARY KEY (id)\n" +
                ")\n";

        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/kickstarter", "postgres", "password");

            Statement statement = connection.createStatement();

            statement.executeUpdate(quoteTableCreateQuery);
            statement.executeUpdate(projectTableCreateQuery);
            statement.executeUpdate(categoryTableCreateQuery);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        in.add("h");

        QuoteStorage quoteStorage = new DatabaseQuoteStorage(quoteTable);
        Quote quote = new Quote("quote1", "author1");
        quoteStorage.add(quote);

        CategoryStorage categoryStorage = new DatabaseCategoryStorage(categoryTable, projectTable);
        Category category = new Category("category1");
        categoryStorage.add(category);
        new Project("project1", category, "short description", "long description", "history...",
                "http://wwww.youtube.com/...", 100, 10);
        Kickstarter kickstarter = new Kickstarter(categoryStorage, quoteStorage);
        Controller controller = new Controller(kickstarter);
        View view = new ConsoleView(controller);
        view.run();

        assertThat(out.toString(), is("Hello! You are at Kickstarter.\r\n" +
                "\r\n" +
                "quote1 (author1)\r\n" +
                "\r\n" +
                "Categories:\r\n" +
                "1. category1\r\n" +
                "\r\n" +
                "Please choose category number or enter \"h\" for help.\r\n" +
                "h\r\n" +
                "Help:\r\n" +
                "h - help\r\n" +
                "x or 0 - exit\r\n" +
                "c - list of categories\r\n" +
                "u - update\r\n" +
                "b - back\r\n" +
                "\r\n" +
                "Please make your choice (h/x/c/u/b).\r\n" +
                "\r\n"));
    }

    @After
    public void tearDown() {
        String quoteTableDeleteQuery = "DROP TABLE " + quoteTable;
        String projectTableDeleteQuery = "DROP TABLE " + projectTable;
        String categoryTableDeleteQuery = "DROP TABLE " + categoryTable;

        try {
            Statement statement = connection.createStatement();

            statement.executeUpdate(quoteTableDeleteQuery);
            statement.executeUpdate(projectTableDeleteQuery);
            statement.executeUpdate(categoryTableDeleteQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
