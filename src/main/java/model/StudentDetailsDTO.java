package model;
import java.util.Date;

public class StudentDetailsDTO {
    private String courseName;
    private String courseDuration;
    private int courseFees;
    private String batchName;
    private Date batchStart;
    private Date batchEnd;
    private String batchTiming;
    private String facultyName;
    
    
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	public int getCourseFees() {
		return courseFees;
	}
	public void setCourseFees(int courseFees) {
		this.courseFees = courseFees;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public Date getBatchStart() {
		return batchStart;
	}
	public void setBatchStart(Date batchStart) {
		this.batchStart = batchStart;
	}
	public Date getBatchEnd() {
		return batchEnd;
	}
	public void setBatchEnd(Date batchEnd) {
		this.batchEnd = batchEnd;
	}
	public String getBatchTiming() {
		return batchTiming;
	}
	public void setBatchTiming(String batchTiming) {
		this.batchTiming = batchTiming;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
}
