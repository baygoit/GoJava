package com.vladik.controller;

import com.vladik.view.ConsoleScanner;
import com.vladik.dao.memory.CategoryDaoMemoryImpl;
import com.vladik.dao.memory.FaqDaoMemoryImpl;
import com.vladik.dao.memory.PaymentDaoMemoryImpl;
import com.vladik.dao.memory.ProjectDaoMemoryImpl;
import com.vladik.dao.memory.QuoteDaoMemoryImpl;
import com.vladik.view.ConsolePrinter;

public class KickstarterMemory extends AbstractKickstarter {

    public KickstarterMemory() {
        consoleScanner = new ConsoleScanner();
        consolePrinter = new ConsolePrinter();
        categories = new CategoryDaoMemoryImpl();
        quotes = new QuoteDaoMemoryImpl();
        payments = new PaymentDaoMemoryImpl();
        projects = new ProjectDaoMemoryImpl();
        faqs = new FaqDaoMemoryImpl();
    }
}
