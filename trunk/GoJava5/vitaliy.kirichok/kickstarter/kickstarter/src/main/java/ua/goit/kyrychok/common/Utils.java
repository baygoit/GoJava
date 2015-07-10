package ua.goit.kyrychok.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date convertDate(String date) {
        Date result = new Date();
        try {
            result = new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

}
