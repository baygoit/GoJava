package goit.streams;

public abstract class Stream {
    public abstract String getNext();

    public abstract boolean hasNext();

    public abstract void showResult(String message);

    public abstract void showError(String message);

}
