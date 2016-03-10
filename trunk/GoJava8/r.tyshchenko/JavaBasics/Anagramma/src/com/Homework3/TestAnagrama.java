package com.Homework3;

/**
 * Created by roman on 04.03.16.
 */

import org.codehaus.groovy.vmplugin.v5.JUnit4Utils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestAnagrama {
    public void Test1() {

        Anagrama anagrama1 = new Anagrama();
        String str= anagrama1.getAnagramArray("abcd");

        Assert.assertEquals("dcba",/*Anagrama.getAnagramArray(str)*/str);

    }
        /*Anagrama str = new Anagrama();
        str.getAnagramArray("abc def");
        Assert.assertArrayEquals("cba fed", str);*/

   /* import org.junit.Assert;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.junit.runners.JUnit4;

    *//**
     * Created by roman on 03.03.16.
     *//*
    @RunWith(JUnit4.class)

    public class DTest {
        @Test
        public void TestAaa () {
            D ddd = new D();
            int res = ddd.aaa(2,5);

            Assert.assertEquals(7, res);
        }

    }
*/
}
    /*public void testAnnagrama() {
        String inputMessage = "мама мыла раму";
        Annagrama annagrama = new Annagrama();
        assertEquals("амам алым умар", annagrama.reversed(inputMessage));*/