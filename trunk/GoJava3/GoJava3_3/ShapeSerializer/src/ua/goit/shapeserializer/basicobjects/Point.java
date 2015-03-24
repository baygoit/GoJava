package ua.goit.shapeserializer.basicobjects;

public final class Point extends Shape {
  int x;
  int y;

  public Point(int x, int y) {
    super();
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public void setX(int x) {
    this.x = x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public void setY(int y) {
    this.y = y;
  }

}
