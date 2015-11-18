package ua.com.goit.gojava7.kickstarter.controller;

import java.io.BufferedReader;
import java.io.IOException;

import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.view.MainPage;

public abstract class PageController <T> {
    
    protected MainPage page;
    
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
    
    public void setMainPage(MainPage page) {
        this.page = page;
    }

    public final void dispatch(){
        do{
            page.showDivider();
            handle();
        }
        while (!isDone());
    }
    
    public final <U> void dispatchNext(U nextRequest, PageController<U> nextPage){
        nextPage.setRequest(nextRequest);
        nextPage.setStorageFactory(storageFactory);
        nextPage.setInputReader(inputReader);
        nextPage.setMainPage(page);
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
                page.showMessage("Use positive numeric index not higher than " + limit);
            }
        } while (option > limit || option < 0);

        return option;
    }

}
