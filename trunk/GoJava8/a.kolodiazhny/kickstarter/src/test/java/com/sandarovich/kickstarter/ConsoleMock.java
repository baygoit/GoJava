package com.sandarovich.kickstarter;

import java.io.*;

/**
 * Created by oleksandr.baglai on 02.10.2015.
 */
public class ConsoleMock {

    private ConfigurableInputStream in;
    private ByteArrayOutputStream out;

    public ConsoleMock() {
        out = new ByteArrayOutputStream();
        in = new ConfigurableInputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));
    }

    public void addIn(String line) {
        in.add(line);
    }

    public String getOut() {
        try {
            String result = new String(out.toByteArray(), "UTF-8");
            out.reset();
            return result.replace("\r\n", "\n");
        } catch (UnsupportedEncodingException e) {
            return e.getMessage();
        }
    }

    public static class ConfigurableInputStream extends InputStream {

        private String line;
        private String printed = "";
        private boolean endLine = false;

        @Override
        public int read() throws IOException {
            if (line.length() == 0) {
                printInput();
                return -1;
            }

            if (endLine) {
                endLine = false;
                printInput();
                return -1;
            }

            char ch = line.charAt(0);
            line = line.substring(1);

            if (ch == '\n') {
                endLine = true;
            } else {
                printed += ch;
            }

            return (int) ch;
        }

        private void printInput() {
            System.out.println(printed);
            printed = "";
        }

        public void add(String line) {
            if (this.line == null) {
                this.line = line + '\n';
            } else {
                this.line += line + '\n';
            }
        }

        @Override
        public synchronized void reset() throws IOException {
            line = null;
            endLine = false;
        }
    }
}
