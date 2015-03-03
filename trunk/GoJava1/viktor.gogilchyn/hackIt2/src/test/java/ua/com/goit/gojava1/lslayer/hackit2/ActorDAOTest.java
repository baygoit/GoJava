package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.dao.ActorFileDAO;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitEcxeptionForUI;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitIOException;

public class ActorDAOTest {
    public static Actor actor = null;

    @BeforeClass
    public static void init() {
        actor = new HumanControlledCharacter("Testname");
        actor.addAttribute("attribute1", "Value1");
        actor.addAttribute("attribute2", "Val123");
        actor.addAttribute("attribute3", "Valsdf");
        actor.addAttribute("attribute4", "Valuss");
        actor.addAttribute("attribute5", "Valdfg");
        actor.addAttribute("attribute6", "123ue1");
        actor.addAttribute("attribute7", "4434");
        actor.addSkill("Boo");
    }

    @Test
    public void testDAOSave() {
        ActorFileDAO dao = new ActorFileDAO();
        try {
            dao.save(actor);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void testDAOSaveException() {
        Actor wrongActor = new HumanControlledCharacter(".\\;\\WrongName");
        ActorFileDAO dao = new ActorFileDAO();
        try {
            dao.save(wrongActor);
        } catch (Exception e) {
            assertTrue(e.getMessage().startsWith("Something in io"));
        }

    }

    @SuppressWarnings("unused")
    @Test
    public void testDAOLoadException() {
        
        // Testing unexisted actor load
        try {
            Actor actor = new ActorFileDAO().fromFile("Unexisted");
        } catch (Exception e) {
            assertTrue(e.getMessage().startsWith("Such actor not found"));
            assertEquals(HackitIOException.class, e.getClass());
        }
        
        
        // Testing wrong file format
        try {
            Actor actor = new ActorFileDAO().fromFile("Testname2");
        } catch (Exception e) {
            assertEquals("Wrong file format", e.getMessage());
            assertEquals(HackitIOException.class, e.getClass());
        }
        
        //Testing 
    }

    @Test
    public void testDAOLoad() {
        ActorFileDAO dao = new ActorFileDAO();
        try {
            Actor actor = dao.fromFile("Suleyman");
            assertNotNull(actor);
            assertEquals("Val123", actor.getAttribute("attribute2"));
            assertEquals(78, actor.getSkill("B78"));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
    @Test
    public void testLoadAll() {
        ActorFileDAO dao = new ActorFileDAO();
        List<Actor> list = new LinkedList<Actor>();
        try {
            list = dao.loadAll();
        } catch (HackitEcxeptionForUI e) {
            fail(e.getMessage());
        }
        assertTrue(list.size() > 1);
    }

}
