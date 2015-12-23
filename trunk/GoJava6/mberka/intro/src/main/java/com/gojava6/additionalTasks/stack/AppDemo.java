package com.gojava6.additionalTasks.stack;

public class AppDemo {

    public static void main(String[] args) {

        Stack stack1 = new Stack();

        stack1.push("Mars");
        stack1.push("Uranus");
        stack1.push("Mercury");
        stack1.push("Jupiter");

        System.out.println("Peek is: " + stack1.peek());
        System.out.println("Size is: " + stack1.size());

        System.out.println("Delete : " + stack1.get());
        System.out.println("Peek is: " + stack1.peek());
        System.out.println("Size is: " + stack1.size());

        System.out.println("Stack is: " + stack1);

    }
}
