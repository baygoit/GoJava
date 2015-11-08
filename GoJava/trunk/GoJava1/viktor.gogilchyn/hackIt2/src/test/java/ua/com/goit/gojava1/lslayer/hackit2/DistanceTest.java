package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.Position;

public class DistanceTest {
    
    @Test
    public void testDistance() {
        Position kyiv = new Position();
        kyiv.setLatitude(50.437329);
        kyiv.setLongitude(30.484314);
        Position berdychiv = new Position();
        berdychiv.setLatitude(49.885344);
        berdychiv.setLongitude(28.572693);
        assertEquals(10,kyiv.countDistance(berdychiv), 1);
    }


}
