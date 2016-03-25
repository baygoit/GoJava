package com.vladik.controller;

import com.vladik.view.ConsolePrinter;
import com.vladik.view.ConsoleScanner;
import com.vladik.dao.database.CategoryDaoMysqlImpl;
import com.vladik.dao.database.FaqDaoMysqlImpl;
import com.vladik.dao.database.PaymentDaoMysqlImpl;
import com.vladik.dao.database.ProjectDaoMysqlImpl;
import com.vladik.dao.database.QuoteDaoMysqlImpl;

public class KickstarterDatabase extends AbstractKickstarter {

    public KickstarterDatabase() {
        consoleScanner = new ConsoleScanner();
        consolePrinter = new ConsolePrinter();
        categories = new CategoryDaoMysqlImpl();
        quotes = new QuoteDaoMysqlImpl();
        payments = new PaymentDaoMysqlImpl();
        projects = new ProjectDaoMysqlImpl();
        faqs = new FaqDaoMysqlImpl();
    }
}
