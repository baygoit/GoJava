package ua.com.goit.gojava7.kickstarter.controller.console;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;

public abstract class AbstractPageController <T> {
    
    protected ConsolePrinter printer;
    
    protected StorageFactory storageFactory;
    protected BufferedReader inputReader;    
    protected T request;
    protected static final int OPTION_EXIT = 0;
    
    public void setRequest(T request) {
        this.request = request;
    }

    public void setStorageFactory(StorageFactory factory) {
        this.storageFactory = factory;
    }

    public void setInputReader(BufferedReader inputReader) {
        this.inputReader = inputReader;
    }
    
    public void setView(ConsolePrinter page) {
        this.printer = page;
    }

    public final void dispatch(){
        do{
            printer.showDivider();
            handle();
        }
        while (!isDone());
    }
    
    public final <U> void dispatchNext(U nextRequest, AbstractPageController<U> nextPage){
        nextPage.setRequest(nextRequest);
        nextPage.setStorageFactory(storageFactory);
        nextPage.setInputReader(inputReader);
        nextPage.setView(printer);
        nextPage.dispatch();
    }
    
    protected abstract void handle();
    
    protected abstract boolean isDone();

    protected int getMenuOptionFromUser(int limit) {
        int option = -1;
        do {
            try {
                String readLine = inputReader.readLine();
                option = Integer.parseInt(readLine);
            } catch (IOException e) {
                throw new IllegalStateException("Input reader not ready");
            }

            if (option > limit || option < 0) {
                printer.showMessage("Use positive numeric index not higher than " + limit);
            }
        } while (option > limit || option < 0);

        return option;
    }

}
