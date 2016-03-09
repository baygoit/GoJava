package com.goit.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DaysCounter {
	public final int HOURS_IN_DAY = 24;
	public final int MINUTES_IN_HOUR = 60;
	public final int SECONDS_IN_MINUTE = 60;
	public final int MILLISECONDS_IN_SECOND = 1000;
	public final int TIME_OFFSET = 1;

	// example: String "28.03.2016"
	public int getDays(String finalDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date finality = null;
		Date current = new Date();
		finality = format.parse(finalDate);
		long difference = finality.getTime() - current.getTime();
		int days = (int) (difference / 
						(HOURS_IN_DAY *
						MINUTES_IN_HOUR *
						SECONDS_IN_MINUTE *
						MILLISECONDS_IN_SECOND))
						+ TIME_OFFSET;
		return days;
	}
}