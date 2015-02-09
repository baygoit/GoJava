package ua.com.goit.gojava.alejnikovi.medsystem;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class WorkDay {
	Date workStartTime;
	Date workFinishTime;
	static final int DEFAULT_WORK_START_TIME = 9;
	static final int DEFAULT_WORK_FINISH_TIME = 18;
	
	WorkDay(Date workStartTime, Date workFinishTime) {
		this.workStartTime = workStartTime;
		this.workFinishTime = workFinishTime;
	}
		
	WorkDay(Date date) {
		long dateTime = date.getTime();
		this.workStartTime = new Date (dateTime + DEFAULT_WORK_START_TIME);
		this.workFinishTime = new Date (dateTime + DEFAULT_WORK_FINISH_TIME);
	}

	public Date getWorkStartTime() {
		return workStartTime;
	}

	public Date getWorkFinishTime() {
		return workFinishTime;
	}
	
	

}
