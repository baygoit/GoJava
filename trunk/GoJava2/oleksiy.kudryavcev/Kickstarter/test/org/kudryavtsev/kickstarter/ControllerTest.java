package org.kudryavtsev.kickstarter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.kudryavtsev.kickstarter.data.Category;
import org.kudryavtsev.kickstarter.data.Model;
import org.kudryavtsev.kickstarter.data.Project;
import org.kudryavtsev.kickstarter.in.In;
import org.kudryavtsev.kickstarter.in.InArrayList;
import org.kudryavtsev.kickstarter.out.OutArrayList;
import org.kudryavtsev.kickstarter.out.View;

public class ControllerTest {

    @Test
    public void shouldContainsGreeting_whenControllerStart() {
        // given
        In in = new InArrayList(0);
        OutArrayList out = controllerInitAndRun(in);

        // then
        assertTrue(out.getAll().toString().contains("Лучший способ предвидеть будущее"));
    }

    @Test
    public void shouldContainsCategories_whenControllerStart() throws IOException {
        // given
        In in = new InArrayList(1, 1, 0, 0, 0, 0);
        OutArrayList out = controllerInitAndRun(in);

        // then
        // writeToFile_output_txt(out);
        assertTrue(out.getAll().toString().contains("(1) Sport"));
        assertTrue(out.getAll().toString().contains("(2) Technology"));
        assertTrue(out.getAll().toString().contains("(3) Science"));
        assertTrue(out.getAll().toString().contains("You choice (0 - exit):"));
    }

    @Test
    public void shouldContainsCateg1Projects_whenControllerStart() throws IOException {
        // given
        In in = new InArrayList(1, 1, 0, 0, 0);
        OutArrayList out = controllerInitAndRun(in);

        // then
        // writeToFile_output_txt(out);
        assertTrue(out.getAll().toString().contains("FutureForward"));
        assertTrue(out.getAll().toString().contains("U23"));
    }

    @Test
    public void shouldContainsCateg2Projects_whenControllerStart() throws IOException {
        // given
        In in = new InArrayList(2, 1, 0, 2, 0, 0, 0);
        OutArrayList out = controllerInitAndRun(in);
        // writeToFile_output_txt(out);
        // then
        assertTrue(out.getAll().toString().contains("APEX"));
        assertTrue(out.getAll().toString().contains("Arduino"));
    }

    @Test
    public void shouldContainsCateg3Projects_whenControllerStart() throws IOException {
        // given
        In in = new InArrayList(3, 1, 0, 2, 0, 0, 0);
        OutArrayList out = controllerInitAndRun(in);

        // then
        assertTrue(out.getAll().toString().contains("EVB"));
        assertTrue(out.getAll().toString().contains("Makeblock"));
    }

    @Test
    public void shouldContainsAllProjects_whenControllerStart() throws IOException {
        // given
        In in = new InArrayList(1, 1, 0, 2, 0, 0, 2, 1, 0, 2, 0, 0, 3, 1, 0, 2, 0, 0, 0);
        OutArrayList out = controllerInitAndRun(in);

        // then
//        writeToFile_output_txt(out);
        assertTrue(out.getAll().toString().contains("FutureForward"));
        assertTrue(out.getAll().toString().contains("U23"));
        assertTrue(out.getAll().toString().contains("EVB"));
        assertTrue(out.getAll().toString().contains("Makeblock"));
        assertTrue(out.getAll().toString().contains("EVB"));
        assertTrue(out.getAll().toString().contains("Makeblock"));
    }

    private OutArrayList controllerInitAndRun(In in) {
        OutArrayList out = new OutArrayList();
        Model model = new Model();
        Controller controller = new Controller(model, new View(out), in);
        initWithDemoData(model);
        // when
        controller.start();
        return out;
    }

    private void writeToFile_output_txt(OutArrayList out) throws IOException {
        FileWriter writer = new FileWriter("output.txt");
        writer.append(Integer.toString(out.getAll().size())).append(System.lineSeparator());
        for (int i = 0; i < out.getAll().size(); i++) {
            writer.append(Integer.toString(i)).append(" ").append(out.print())
                    .append(System.lineSeparator());
        }
        writer.close();
    }

    private void initWithDemoData(Model model) {
        model.add(new Category("Sport", "Sport projects"));
        model.add(new Category("Technology", "Technology projects"));
        model.add(new Category("Science", "Science projects"));

        model.addProjectToCategory(0, new Project("FutureForward",
                "FutureForward is an innovative training project", 4, 200, 45));

        model.addProjectToCategory(1, new Project("APEX Wallet",
                "The Apex is a slim aluminum wallet with RFID protection", 56400, 4000, 12));

        model.addProjectToCategory(
                2,
                new Project(
                        "EVB",
                        "EVB: Replace the Brain and Sensors in your LEGO® MINDSTORMS EV3 with a BeagleBone Black",
                        36000, 8000, 1));

        model.addProjectToCategory(0, new Project("U23",
                "Support Team Canada U23 in their quest for Gold!", 5500, 5000, 5));

        model.addProjectToCategory(
                1,
                new Project(
                        "Arduino",
                        "We love Arduino and we love space exploration. So we decided to combine them and let people run their own space experiments!",
                        10600, 35000, 4));

        model.addProjectToCategory(
                2,
                new Project(
                        "Makeblock",
                        "Makeblock is an aluminum extrusion based construct platform that can be used to build robots",
                        186000, 30000, 2));
    }

}
