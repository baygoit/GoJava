package View;

public interface Level {
    public void displayMySelf(int currentPosition);
    public int getPosition();
    public void setParentPosition(int parentPosition);
    public int getParentPosition();
}
