package org.kudryavtsev.kickstarter.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.kudryavtsev.kickstarter.data.Model;

public class ModelTest {
    Model model = new Model();

    @Test
    public void testModelInit() {

    }

    @Test
    public void testGetCategoriesList() {

        assertEquals(
                "[Sport - Sport projects, Technology - Technology projects, Science - Science projects]",
                model.getCategoriesList().toString());
    }

    @Test
    public void testGetProjectsList() {
        assertEquals(
                "[FutureForward; FutureForward is an innovative training project; funded: 4; pledged: 200; days to go: 45, U23; Support Team Canada U23 in their quest for Gold!; funded: 5500; pledged: 5000; days to go: 5]",
                model.getCategoriesList().get(0).getProjects().toString());
        assertEquals(
                "[APEX Wallet; The Apex is a slim aluminum wallet with RFID protection; funded: 56400; pledged: 4000; days to go: 12, Arduino; We love Arduino and we love space exploration. So we decided to combine them and let people run their own space experiments!; funded: 10600; pledged: 35000; days to go: 4]",
                model.getCategoriesList().get(1).getProjects().toString());
        assertEquals(
                "[EVB; EVB: Replace the Brain and Sensors in your LEGO® MINDSTORMS EV3 with a BeagleBone Black; funded: 36000; pledged: 8000; days to go: 1, Makeblock; Makeblock is an aluminum extrusion based construct platform that can be used to build robots; funded: 186000; pledged: 30000; days to go: 2]",
                model.getCategoriesList().get(2).getProjects().toString());
    }
}
