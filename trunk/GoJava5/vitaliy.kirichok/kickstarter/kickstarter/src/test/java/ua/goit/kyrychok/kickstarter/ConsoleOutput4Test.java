package ua.goit.kyrychok.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class ConsoleOutput4Test implements Output {
    private List<String> result = new ArrayList<>();

    public List<String> getResult() {
        return result;
    }

    @Override
    public void writeLine(String string) {
        result.add(string);
    }

}
