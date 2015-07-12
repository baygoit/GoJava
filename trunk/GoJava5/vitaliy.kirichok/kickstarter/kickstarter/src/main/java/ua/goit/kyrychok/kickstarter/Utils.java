package ua.goit.kyrychok.kickstarter;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

    public static Map<TimeUnit, Long> computeDiff(Date date1, Date date2) {
        long diffInMilliseconds = date2.getTime() - date1.getTime();
        List<TimeUnit> units = new ArrayList<>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        Map<TimeUnit, Long> result = new LinkedHashMap<>();
        long millisecondsRest = diffInMilliseconds;
        for (TimeUnit unit : units) {
            long diff = unit.convert(millisecondsRest, TimeUnit.MILLISECONDS);
            long diffInMillisecondsForUnit = unit.toMillis(diff);
            millisecondsRest = millisecondsRest - diffInMillisecondsForUnit;
            result.put(unit, diff);
        }
        return result;
    }

    public static String getDiffDate(Date deadLineDate, Date currentDate) {
        Map<TimeUnit, Long> diff = Utils.computeDiff(currentDate, deadLineDate);
        String result;
        if (diff.get(TimeUnit.DAYS) > 0) {
            result = String.format("%s days to go", diff.get(TimeUnit.DAYS));
        } else if (diff.get(TimeUnit.HOURS) > 0) {
            result = String.format("%s hours to go", diff.get(TimeUnit.HOURS));
        } else if (diff.get(TimeUnit.MINUTES) > 0) {
            result = String.format("%s minutes to go", diff.get(TimeUnit.MINUTES));
        } else {
            result = "time is up";
        }
        return result;
    }

}
