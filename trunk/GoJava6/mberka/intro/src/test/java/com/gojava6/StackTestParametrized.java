package com.gojava6;

import com.gojava6.additionalTasks.stack.Stack;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StackTestParametrized {
    private Stack stack;

    private int count;
    private String inputStack;
    private String expectedResult;

    @Parameterized.Parameters
    public static Collection testStack() {
        return Arrays.asList(new Object[][]{
                {"Neptune, Pluto", 2, "Pluto"},
                {"Earth, Jupiter, Venus", 3, "Venus"},
                {"Mars, Uranus", 2, "Uranus"},
                {"Saturn", 1, "Saturn"},
                {"Mercury, Jupiter, Earth", 3, "Earth"}
        });
    }

    public StackTestParametrized(String inputStack, int count, String expectedResult) {
        this.inputStack = inputStack;
        this.count = count;
        this.expectedResult = expectedResult;
    }

    @Test
    public void stackTestParametrized() {
        stack = new Stack();
        for (int i = 0; i < count; i++) {
            stack.push(inputStack);
        }
        System.out.println("Parametrized String is : " + inputStack);
        Assert.assertEquals(expectedResult, stack.peek());
    }
}