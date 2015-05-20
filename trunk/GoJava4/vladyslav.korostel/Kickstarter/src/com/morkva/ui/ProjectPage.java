package com.morkva.ui;

import com.morkva.entities.Project;
import com.morkva.logic.Printer;
import com.morkva.logic.Reader;

/**
 * Created by vladyslav on 20.05.15.
 */
public class ProjectPage {
    Printer printer;
    Reader reader;
    Project project;

    public ProjectPage(Printer printer, Reader reader, Project project) {
        this.printer = printer;
        this.reader = reader;
        this.project = project;
    }

    public void showProjectMenu() {
        while(true) {

            printer.print(project.getFullInfo()+"\n");

            printer.print("\n");
            printer.print("Press 0 to return back\n");
            printer.print("--------------------------------------------\n");

            int keyCode = reader.readUserInput();
            if (keyCode == 0) {
                break;
            } else {
                printer.print("Wrong code!\n");
            }
        } //end loop
    }
}
