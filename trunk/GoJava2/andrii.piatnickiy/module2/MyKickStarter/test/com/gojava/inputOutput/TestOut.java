package com.gojava.inputOutput;
import static org.junit.Assert.*;

import org.junit.Test;

import com.gojava.inputOutput.Out;
import com.gojava.projects.CategoryStub;
import com.gojava.projects.ProjectStub;

public class TestOut {
    Out out = new Out();

    @Test
    public void shoultReturnString_WhenInputString() {
        String actual = out.output("aaa");
        assertTrue(actual == "aaa");
    }

    @Test
    public void shoultReturnString_WhenInput2Strings() {
        String actual = out.output("aaa", "bbb");
        assertTrue(actual.equals("aaabbb"));
    }

    @Test
    public void shoultReturnString_WhenInputStringAndInt() {
        String actual = out.output("aaa", 1);
        assertTrue(actual.equals("aaa1"));
    }

    @Test
    public void shoultReturnString_WhenInputIntAndString() {
        String actual = out.output(1, "aaa");
        assertTrue(actual.equals("1aaa"));
    }

    @Test
    public void shoultReturnString_WhenCallProjectPreview(){
        String actual = out.printProjectPreview(new ProjectStub());
        assertTrue(actual.equals("Project Name: stubName" + "\n" + "Description: stubDescription" + "\n" + "Need Sum: 1" + "\n" + "Current Sum: 2" + "\n" + "Days Left: 3" + "\n"));
    }
    
    @Test
    public void shoultReturnString_WhenCallProjectFields(){
        String actual = out.printAdditionalProjectFields(new ProjectStub());
        assertTrue(actual.equals("ProjectHistory: stubProjectHistory" + "\n" + "LinkOnvideo: stublinkOnvideo" + "\n" + "Questions and answers: stubQuestionsAndAnswers" + "\n"));
    }
    
    @Test
    public void shoultReturnString_WhenCallPrintCategory(){
        String actual = out.printCategory(new CategoryStub());
        assertEquals("0) stubName", actual);
    }
    
}
