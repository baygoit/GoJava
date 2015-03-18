package ua.com.goit.gojava.solo307.intersim.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCounter {

	static final int SECONDS_IN_HOUR = 3600;
	static final int SECONDS_IN_MINUTE = 60;
	static final int MILLIS_IN_SECOND = 1000;

	public static long elapsedTime(long start, long end) {
		return (end - start);
	}

	public static long calculateSeconds(long elapsedTime) {
		return new Long(elapsedTime / MILLIS_IN_SECOND);
	}

	public static String getTime(long start) throws InterviewSimulatorCommonsException {
		long end = System.currentTimeMillis();
		long elapsed = TimeCounter.elapsedTime(start, end);
		long seconds = TimeCounter.calculateSeconds(elapsed);
		boolean isSecondsToMuch = (seconds > Integer.MAX_VALUE);
		int remainder;
		if (!isSecondsToMuch) {
			remainder = (int) (seconds % SECONDS_IN_HOUR);
		} else {
			throw new InterviewSimulatorCommonsException("there are to much seconds");
		}
		int minutes = remainder / SECONDS_IN_MINUTE;
		int remained = remainder % SECONDS_IN_MINUTE;
		if (minutes == 0)
			return new String("" + remained + " seconds");
		return new String(minutes + ":" + remained);
	}

	public static String getCurrentTime() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date current = new Date();
		String currentDate = sdfDate.format(current);
		return currentDate;
	}
}
