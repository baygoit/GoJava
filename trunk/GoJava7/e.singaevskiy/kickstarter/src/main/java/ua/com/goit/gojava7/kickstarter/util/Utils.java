package ua.com.goit.gojava7.kickstarter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    private static final Logger LOG = Logger.getLogger(Utils.class.getName());

    private Utils() {

    }

    public static Date dateFromString(String stringDate) {
        return dateFromString("dd.MM.yyyy", stringDate);
    }

    public static Date dateFromString(String pattern, String stringDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            return formatter.parse(stringDate);
        } catch (ParseException e) {
            LOG.log(Level.WARNING, "Invalid data", e);
        }
        return new Date();
    }

    public static Date addToDate(Date date, int value, int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(type, value);
        return calendar.getTime();
    }
}
