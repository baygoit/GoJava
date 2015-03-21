package ua.goit.shramko.serializator.reserved;

public abstract class HavingID {
 
  private int id;
  private static int idCounter;
  
  protected void setID() {
    id = ++idCounter;
  }
  
  public int getID() {
    return id;
  }
  
  public HavingID() {
    setID();
  }
  
}
