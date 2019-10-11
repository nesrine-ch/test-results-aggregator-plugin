package com.jenkins.testresultsaggregator.helper;

import java.util.ResourceBundle;

public enum LocalMessages {
	REPORT_DISPLAYNAME ("DisplayName"),
	START_AGGREGATE ("StartAggregate"),
	FINISHED_AGGREGATE ("FINISHED_AGGREGATE"),
	ERROR_OCCURRED ("ERROR_OCCURRED"),
	VALIDATION_POSITIVE_NUMBER ("VALIDATION_POSITIVE_NUMBER"),
	VALIDATION_INTEGER_NUMBER ("VALIDATION_INTEGER_NUMBER"),
	SUCCESS ("SUCCESS"),
	GENERATE ("GENERATE"),
	FINISHED ("FINISHED"),
	HTML_REPORT ("HTML_REPORT"),
	EMAIL_REPORT ("EMAIL_REPORT"),
	VALIDATION_MAIL_NOT_FOUND_JOBS ("VALIDATION_MAIL_NOT_FOUND_JOBS"),
	VALIDATION_MAIL_RECEIPIENTS_EMPTY ("VALIDATION_MAIL_RECEIPIENTS_EMPTY"),
	VALIDATION_MAIL_SMTP_ISSUE ("VALIDATION_MAIL_SMTP_ISSUE"),
	SEND_MAIL_TO ("SEND_MAIL_TO"),
	COLLECT_DATA ("COLLECT_DATA"),
	JOB_NOT_FOUND ("JOB_NOT_FOUND"),
	JOB_IS_DISABLED ("JOB_IS_DISABLED"),
	TEST_RESULTS ("TEST_RESULTS"),
	RESULTS_RUNNING ("RESULTS_RUNNING"),
	RESULTS_SUCCESS ("RESULTS_SUCCESS"),
	RESULTS_FAILED ("RESULTS_FAILED"),
	RESULTS_UNSTABLE ("RESULTS_UNSTABLE"),
	RESULTS_ABORTED ("RESULTS_ABORTED"),
	COLUMN_GROUP ("COLUMN_GROUP"),
	COLUMN_GROUP_STATUS ("COLUMN_GROUP_STATUS"),
	COLUMN_JOB ("COLUMN_JOB"),
	COLUMN_JOB_STATUS ("COLUMN_JOB_STATUS"),
	COLUMN_TESTS ("COLUMN_TESTS"),
	COLUMN_PASS ("COLUMN_PASS"),
	COLUMN_FAIL ("COLUMN_FAIL"),
	COLUMN_SKIP ("COLUMN_SKIP"),
	COLUMN_LAST_RUN ("COLUMN_LAST_RUN"),
	COLUMN_COMMITS ("COLUMN_COMMITS"),
	XML_REPORT ("XML_REPORT");
	
	private final static ResourceBundle MESSAGES = ResourceBundle.getBundle("com.jenkins.testresultsaggregator.Messages");
	private final String msgRef;
	
	private LocalMessages(final String msgReference) {
		msgRef = msgReference;
	}
	
	@Override
	public String toString() {
		return MESSAGES.getString(msgRef);
	}
}
