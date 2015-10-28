import org.junit.Test;
import org.junit.Before;
import static junit.framework.Assert.assertEquals;

/**
 * Created by Ыўср on 28.09.2015.
 */
public class ValidatorTests {

            private String name;
            private String surName;
            private String email;

            @Before
            public void setUp(){
                name = "Igor";
                surName = "Fine";
                email = "irfn@pink.com";
                //User user1 = new Client("Igor", "Fine", "irfn@pink.com");
                //User user2 = new Client("Igor4", "Fine56", "irfn@pinkcom");
            }



            @Test
            public void TestValidateName() throws Exception {
                User user = new Client("Igor", "Fine", "irfn@pink.com");
                String resultName = user.getName();
                assertEquals(name, resultName);
            }

            @Test
            public void TestValidateSurname() throws Exception {
                User user = new Client("Igor", "Fine", "irfn@pink.com");
                String resultSurname = user.getSurname();
                assertEquals(surName, resultSurname);
            }

            @Test
            public void TestValidateEmail() throws Exception {
                User user = new Client("Igor", "Fine", "irfn@pink.com");
                String resultEmail = user.getEmail();
                assertEquals(email, resultEmail);
            }
    /*@Test
    public void TestValidateName1() throws Exception {
        User user = new Client("Igor4", "Fine56", "irfn@pinkcom");
        String resultName = user.getName();
        assertEquals(name, false);
    }

    @Test
    public void TestValidateSurname2() throws Exception {
        User user = new Client("Igor4", "Fine56", "irfn@pinkcom");
        String resultSurname = user.getSurname();
        assertEquals(surName, false);
    }

    *//*@Test
    public void TestValidateEmail2() throws Exception {
        User user = new Client("Igor4", "Fine56", "irfnpink.com");
        String resultEmail = user.getEmail();
        assertEquals(email, false);
    }*/
        }