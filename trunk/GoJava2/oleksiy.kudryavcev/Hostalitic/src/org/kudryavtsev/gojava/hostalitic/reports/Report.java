package org.kudryavtsev.gojava.hostalitic.reports;

import org.kudryavtsev.gojava.hostalitic.Client;

public class Report {
    private Client userWantedReport;
//    ReportType reportType;

    public Report(final Client user) {
	setUserWantedReport(user);
    }

    public final void show(final String currentReportType) {
	
	System.out.println(currentReportType + ": " 
	+ getUserWantedReport().getName() + "\nReport done.");
    }

    final Client getUserWantedReport() {
	return userWantedReport;
    }

    final void setUserWantedReport(final Client userWantedReport) {
	this.userWantedReport = userWantedReport;
    }
}
