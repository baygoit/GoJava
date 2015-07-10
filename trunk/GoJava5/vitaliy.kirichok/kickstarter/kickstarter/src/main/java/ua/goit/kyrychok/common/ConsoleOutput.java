package ua.goit.kyrychok.common;

public class ConsoleOutput implements Output {
    @Override
    public void show(String data) {
        System.out.println(data);
    }
}
