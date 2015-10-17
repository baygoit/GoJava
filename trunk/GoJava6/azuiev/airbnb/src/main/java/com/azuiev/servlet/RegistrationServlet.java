package com.azuiev.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Masta on 17.10.2015.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.println("<html>\n" +
                "<head>\n" +
                "    <title>Registration Form</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table border=\"0\">\n" +
                "    <tr>\n" +
                "        <td valign=\"top\" align=\"left\">\n" +
                "\n" +
                "            <p>Name</p>\n" +
                "\n" +
                "            <p>Surname</p>\n" +
                "\n" +
                "            <p>Email</p>\n" +
                "\n" +
                "        </td>\n" +
                "\n" +
                "        <td>\n" +
                "            <form action=\"/register\" method=\"POST\">\n" +
                "\n" +
                "                <p><input type=\"text\" name=\"name\"></p>\n" +
                "\n" +
                "                <p><input type=\"text\" name=\"surname\"></p>\n" +
                "\n" +
                "                <p><input type=\"text\" name=\"email\"></p>\n" +
                "                <!--\n" +
                "                    <p>Сообщение: </p><p> <textarea rows= \"10\" cols= \"45\" name= \"message\"></textarea></p>\n" +
                "                -->\n" +
                "\n" +
                "                <input type=\"submit\" value=\"Send\">\n" +
                "            </form>\n" +
                "        </td>\n" +
                "\n" +
                "\n" +
                "    </tr>\n" +
                "\n" +
                "\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>");

        out.close();

    }

}
