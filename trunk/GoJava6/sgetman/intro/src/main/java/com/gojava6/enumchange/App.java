package com.gojava6.enumchange;

/**
 * Created by sergiigetman on 10/5/15.
 */
public class App {
    public static void main(String[] args) {
        EnumHelper color = Color.RED;
        EnumHelper fruit = Fruits.APPLE;
        System.out.println(color.getName());
        System.out.println(fruit.getName());
    }
}
