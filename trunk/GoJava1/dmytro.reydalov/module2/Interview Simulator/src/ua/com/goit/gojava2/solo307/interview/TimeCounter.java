package ua.com.goit.gojava2.solo307.interview;

public class TimeCounter {
	
	private final long START;
	final int SECONDS_IN_HOUR = 3600;
	final int SECONDS_IN_MINUTE = 60;
	
    public TimeCounter() {
    	START = System.currentTimeMillis();
    } 

	public long elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - START);
	}
	
	public long calculateSeconds(long elapsedTime){
		final int MILLIS_IN_SECOND = 1000;
		return new Long(elapsedTime / MILLIS_IN_SECOND);
	}
	
	public String formatIntoMMSS(long seconds) throws InterviewSimulatorException{
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
		return new String(minutes + ":" + remained); 
	}
}
	
	
	

