package ua.com.goit.gojava2.solo307.interview;

public class TimeCounter {

	static final int SECONDS_IN_HOUR = 3600;
	static final int SECONDS_IN_MINUTE = 60; 
	static final int MILLIS_IN_SECOND = 1000;
	
	public static long getTime(){
		return new Long(System.currentTimeMillis());
	}
	
	public static long elapsedTime(long start, long end) {
		return (end - start);
	}
	
	public static long calculateSeconds(long elapsedTime){
		return new Long(elapsedTime / MILLIS_IN_SECOND);
	}
	
	public static String formatIntoMMSS(long seconds) throws InterviewSimulatorException{
		boolean isSecondsToMuch = (seconds > Integer.MAX_VALUE);
		int remainder;
		if(!isSecondsToMuch){
			remainder = (int) (seconds % SECONDS_IN_HOUR);
		}
		else{
			throw new InterviewSimulatorException("there are to much seconds");
		}
		int minutes = remainder / SECONDS_IN_MINUTE;
		int remained = remainder % SECONDS_IN_MINUTE;
		if(minutes == 0)return new String("" + remained + " seconds");
		return new String(minutes + ":" + remained); 
	}
}
	
	
	

