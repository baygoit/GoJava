package goit.calculator.streams;

public interface Stream {

    String getNext();

    boolean hasNext();

    void showResult(String message);

    void showError(String message);

}
