package model;

import java.util.Date;

public class AttendanceModel {
	private int studentId;
    private int batchId;
    private int courseId;
    private String status;
    private Date date;
    private String studentName;
    private String batchName;
    

    public AttendanceModel() {}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public int getBatchId() {
		return batchId;
	}


	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	public String getStudentName() {
	    return studentName;
	}

	public void setStudentName(String studentName) {
	    this.studentName = studentName;
	}

	public String getBatchName() {
	    return batchName;
	}

	public void setBatchName(String batchName) {
	    this.batchName = batchName;
	}

}
