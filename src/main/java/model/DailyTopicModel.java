package model;

import java.sql.Date;
import java.sql.Time;

public class DailyTopicModel {
    private Date date;
    private String facultyName;
    private String batchName;
    private Time startTime;
    private String topicDetails;

    public DailyTopicModel() {}

    public DailyTopicModel( Date date, String facultyName, String batchName, Time startTime, String topicDetails) {
        this.date = date;
        this.facultyName = facultyName;
        this.batchName = batchName;
        this.startTime = startTime;
        this.topicDetails = topicDetails;
    }

   
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public String getTopicDetails() {
        return topicDetails;
    }

    public void setTopicDetails(String topicDetails) {
        this.topicDetails = topicDetails;
    }
}
