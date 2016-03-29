package com.vladik.controller;

import com.vladik.dao.file.CategoryDaoFileImpl;
import com.vladik.dao.file.FaqDaoFileImpl;
import com.vladik.dao.file.PaymentDaoFileImpl;
import com.vladik.dao.file.ProjectDaoFileImpl;
import com.vladik.dao.file.QuoteDaoFileImpl;
import com.vladik.view.ConsolePrinter;
import com.vladik.view.ConsoleScanner;

public class KickstarterFile extends AbstractKickstarter {

    public KickstarterFile() {
        consoleScanner = new ConsoleScanner();
        consolePrinter = new ConsolePrinter();
        categories = new CategoryDaoFileImpl();
        quotes = new QuoteDaoFileImpl();
        payments = new PaymentDaoFileImpl();
        projects = new ProjectDaoFileImpl();
        faqs = new FaqDaoFileImpl();
    }
}