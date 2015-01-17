package org.kudryavtsev.gojava.hostalitic.reports;

import org.kudryavtsev.gojava.hostalitic.User;

public class Report {
    User userWantedReport;
//    ReportType reportType;

    public Report(User user) {
	userWantedReport = user;
    }

    public void show(String currentReportType) {
	
	System.out.println(currentReportType + ": " 
	+ userWantedReport.getName() + "\nReport done.");
    }
}
