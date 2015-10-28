package org.kudryavtsev.kickstarter;

import java.io.IOException;

import org.kudryavtsev.kickstarter.data.Category;
import org.kudryavtsev.kickstarter.data.Model;
import org.kudryavtsev.kickstarter.data.Project;
import org.kudryavtsev.kickstarter.in.In;
import org.kudryavtsev.kickstarter.in.InConsole;
import org.kudryavtsev.kickstarter.out.Out;
import org.kudryavtsev.kickstarter.out.OutConsole;
import org.kudryavtsev.kickstarter.out.OutFile;
import org.kudryavtsev.kickstarter.out.View;

public class Kickstarter {

    public static void main(String[] args) {

        Out whereToOut = null;
        try {
            whereToOut = new OutFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Out whereToOut = new OutConsole();
        In whereToIn = new InConsole();

        Model model = new Model();
        initWithDemoData(model);
        View view = new View(whereToOut);
        Controller controller = new Controller(model, view, whereToIn);

        controller.start();

        if (whereToOut != null)
            whereToOut.close();
    }

    public static void initWithDemoData(Model model) {
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
