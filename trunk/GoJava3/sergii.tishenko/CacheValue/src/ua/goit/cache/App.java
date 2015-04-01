package ua.goit.cache;

import static org.junit.Assert.assertEquals;

public class App {

  public static void main(String[] args) {

    NodeTable nodeTable = new NodeTable(3);
    nodeTable.put(1, 10);
    nodeTable.put(2, 20);
    nodeTable.put(1, 30);
    nodeTable.put(2, 40);
    nodeTable.put(5, 50);
    nodeTable.put(1, 30);

    System.out.println(nodeTable.getCapacity());
    
    
    int actual = nodeTable.get(1);
    int expected = 30;
    
    System.out.println("actual - expected" + actual + "- " + expected);

    nodeTable.put(2, 10);
    nodeTable.put(5, 10);
    nodeTable.put(6, 10);

    expected = -1;
    actual = nodeTable.get(1);
    
    System.out.println("actual - expected" + actual + "- " + expected);

  }

}
