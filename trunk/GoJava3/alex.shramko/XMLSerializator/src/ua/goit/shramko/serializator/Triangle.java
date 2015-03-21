package ua.goit.shramko.serializator;

public class Triangle extends HavingID implements Groupable {

  private int a;
  private int b;
  private int c;

  public int getA() {
    return a;
  }

  public void setA(int a) {
    this.a = a;
  }

  public int getB() {
    return b;
  }

  public void setB(int b) {
    this.b = b;
  }

  public int getC() {
    return c;
  }

  public void setC(int c) {
    this.c = c;
  }

  public Triangle() {
    super();
  }
  
  public Triangle(int a, int b, int c) {
    super();
    this.a = a;
    this.b = b;
    this.c = c;
  }

}
