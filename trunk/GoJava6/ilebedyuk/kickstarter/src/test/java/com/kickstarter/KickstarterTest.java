package com.kickstarter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Игорь on 22.02.2016.
 */
public class KickstarterTest {
   @Test
    public void should_when (){
       Categories categories = new Categories();
       Projects projects = new Projects();

       IO io = new IO() {
            public int read() {
                return 0;
            }

            public void print(String message) {

            }
        };

        Kickstarter kickstarter = new Kickstarter(categories, projects, io);
        kickstarter.run();
    }
}