package ua.com.goit.gojava7.kickstarter.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.Properties;
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
            return new Date(formatter.parse(stringDate).getTime());
        } catch (ParseException e) {
            LOG.log(Level.WARNING, "Invalid data", e);
        }
        return new Date(System.currentTimeMillis());
    }

    public static Date addToDate(Date date, int value, int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(type, value);
        return new Date(calendar.getTimeInMillis());
    }
    
    public static Properties readProperties(String path) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    
    public static Properties readProperties(InputStream resourceStream) {
        Properties properties = new Properties();
        try {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
