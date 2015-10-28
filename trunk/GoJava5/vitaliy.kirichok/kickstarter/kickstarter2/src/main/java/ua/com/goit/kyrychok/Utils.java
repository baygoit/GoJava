package ua.com.goit.kyrychok;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Utils {

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
            result = String.format("%s days", diff.get(TimeUnit.DAYS));
        } else if (diff.get(TimeUnit.HOURS) > 0) {
            result = String.format("%s hours", diff.get(TimeUnit.HOURS));
        } else if (diff.get(TimeUnit.MINUTES) > 0) {
            result = String.format("%s minutes", diff.get(TimeUnit.MINUTES));
        } else {
            result = "time is up";
        }
        return result;
    }

    public static String getMoney(Integer money) {
        double value = (double) money / 100;
        return new DecimalFormat("#.##").format(value);
    }

    public static String getDate(Date date) {
        String result = "";
        if (date != null) {
            result = new SimpleDateFormat("dd.MM.yyyy").format(date);
        }
        return result;
    }
}
