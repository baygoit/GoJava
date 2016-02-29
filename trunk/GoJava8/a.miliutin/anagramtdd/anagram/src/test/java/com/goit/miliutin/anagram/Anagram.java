package com.goit.miliutin.anagram;

import org.junit.*;

public class Anagram {
    @Test
    public void Anagram(){
        //given
        String normal = "blablabla 67 df";
        //when
        String actual = MyStringUtils.anagram(normal);
        //then
        String expected = "fd 76 albalbalb";
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void AnagramEmpty(){
        //given
        String normal = "";
        //when
        String actual = MyStringUtils.anagram(normal);
        //then
        String expected = "";
        Assert.assertEquals(expected, actual);
    }
    
    @Test(expected=NullPointerException.class)
    public void AnagramNull(){
        //given
        String normal = null;
        //when
        String actual = MyStringUtils.anagram(normal);        
    }
    
}

