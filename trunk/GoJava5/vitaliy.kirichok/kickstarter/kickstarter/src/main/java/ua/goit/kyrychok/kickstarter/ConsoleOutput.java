package ua.goit.kyrychok.kickstarter;

public class ConsoleOutput implements Output {
    @Override
    public void writeLine(String string) {
        System.out.println(string);
    }
}
