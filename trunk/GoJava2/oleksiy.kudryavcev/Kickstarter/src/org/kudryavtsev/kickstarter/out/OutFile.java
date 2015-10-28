package org.kudryavtsev.kickstarter.out;

import java.io.FileWriter;
import java.io.IOException;

public class OutFile implements Out, AutoCloseable {

    private static FileWriter writer;

    public OutFile() throws IOException {
        writer = new FileWriter("outfile.txt");
    }

    @Override
    public void output(String output) {

        try {
            writer.append(output).append(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public final void close() {
        try {
            writer.append(System.lineSeparator()).append("*******").append(System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
