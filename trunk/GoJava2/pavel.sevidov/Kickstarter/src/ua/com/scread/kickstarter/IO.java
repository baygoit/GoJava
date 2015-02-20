package ua.com.scread.kickstarter.io;

public interface IO {

    int read();
    
    String readString();
    
    long readLong();

    void print(String message);

}