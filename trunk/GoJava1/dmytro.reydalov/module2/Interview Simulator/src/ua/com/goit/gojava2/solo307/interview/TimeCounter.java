package ua.com.goit.gojava2.solo307.interview;

public class TimeCounter {
	
	private final long START;

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
			remainder = (int) (seconds % 3600);
		}
		else{
			throw new InterviewSimulatorException("there are to much seconds");
		}
		int minutes = remainder / 60;
		int remained = remainder % 60;
		return new String(minutes + ":" + remained); 
	}
}
	
	
	

