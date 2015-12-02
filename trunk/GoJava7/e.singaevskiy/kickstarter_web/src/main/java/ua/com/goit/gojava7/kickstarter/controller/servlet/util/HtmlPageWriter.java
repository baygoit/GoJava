package ua.com.goit.gojava7.kickstarter.controller.servlet.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HtmlPageWriter {

    private static final String ACTION = "%action%";
    private static final String FORM = "%form%";
    private static final String SAMPLE_HTML = "sample.html";
    private static final String BODY = "%body%";
    private static final String TITLE = "%title%";
    private StringBuilder content;

    public HtmlPageWriter() {

        content = new StringBuilder();

        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(SAMPLE_HTML);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {
            while (bufferedReader.ready()) {
                content.append(bufferedReader.readLine() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setTitle(String title) {
        int lastIndexOf = content.lastIndexOf(TITLE);
        if (lastIndexOf > 0) {
            content.replace(lastIndexOf, lastIndexOf, title);
        }
    }

    public void setBody(String body) {
        int lastIndexOf = content.lastIndexOf(BODY);
        if (lastIndexOf > 0) {
            content.insert(lastIndexOf, body.replaceAll("\n", "</br\n>"));
        }
    }

    public String prepare() {
        return content.toString().replace(TITLE, "").replace(BODY, "").replace(FORM, "");
    }

    public void addControl(String type, String name, String value) {
        addControl("", type, name, value);
    }

    public void addControl(String label, String type, String name, String value) {
        int lastIndexOf = content.lastIndexOf(FORM);
        if (lastIndexOf > 0) {
            String input;
            if (type.equals("textarea")) {
                input = "<textarea rows=\"5\" name=\"" + name + "\">" + value + "</textarea>";
            } else {
                input = "<input type=\"" + type + "\" value=\"" + value + "\" name=\"" + name + "\">";
            }            
            content.insert(lastIndexOf, "<tr><td width=\"25\" align=\"right\">" + label + "</td><td>" + input + "</td></tr>\n");
        }
    }

    public void setAction(String action) {
        int lastIndexOf = content.lastIndexOf(ACTION);
        if (lastIndexOf > 0) {
            content.replace(lastIndexOf, lastIndexOf + ACTION.length(), action);
        }
    }
}
