package com.airbnb;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Игорь on 23.09.2015.
 */
public class ValidationTest {
    private String name;
    private String surName;
    private String email;

    @Before
    public void setUp(){
        name = "fgh";
        surName = "Yutr";
        email = "hgr@hjt.com";
    }

    @Test
    public void TestValidateName() throws Exception {
        User user = new Client(name, surName, email);
        String resultName = user.getName();
        assertEquals(name, resultName);
    }

    @Test
    public void TestValidateSurname() throws Exception {
        User user = new Client(name, surName, email);
        String resultSurname = user.getSurname();
        assertEquals(surName, resultSurname);
    }

    @Test
    public void TestValidateEmail() throws Exception {
        User user = new Client(name, surName, email);
        String resultEmail = user.getEmail();
        assertEquals(email, resultEmail);
    }
}
