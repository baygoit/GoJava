package org.kudryavtsev.gojava.hostalitic.reports;

import org.kudryavtsev.gojava.hostalitic.User;

public class Report {
    private User userWantedReport;
//    ReportType reportType;

    public Report(final User user) {
	setUserWantedReport(user);
    }

    public final void show(final String currentReportType) {
	
	System.out.println(currentReportType + ": " 
	+ getUserWantedReport().getName() + "\nReport done.");
    }

    final User getUserWantedReport() {
	return userWantedReport;
    }

    final void setUserWantedReport(final User userWantedReport) {
	this.userWantedReport = userWantedReport;
    }
}
