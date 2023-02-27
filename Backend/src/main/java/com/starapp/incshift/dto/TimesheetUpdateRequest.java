package com.starapp.incshift.dto;

public class TimesheetUpdateRequest {
	public String getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(String timesheetId) {
		this.timesheetId = timesheetId;
	}

	private String timesheetId;

	public TimesheetUpdateRequest(String timesheetId) {
		super();
		this.timesheetId = timesheetId;
	}
	

 
 
}
