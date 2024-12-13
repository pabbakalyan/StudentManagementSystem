package model;

public class BatchModel {

	private int batchId;
	private String batchName;
	private String batchStart;
	private String batchEnd;
	private String batchTiming;
	private int courseId;
	
	public BatchModel() {
		
	}

	public BatchModel(int batchId, String batchName, String batchStart, String batchEnd, String batchTiming, int courseId) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.batchStart = batchStart;
		this.batchEnd = batchEnd;
		this.batchTiming = batchTiming;
		this.courseId = courseId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchStart() {
	    return batchStart;
	}

	public void setBatchStart(String batchStart) {
	    this.batchStart = batchStart;
	}

	public String getBatchEnd() {
	    return batchEnd;
	}

	public void setBatchEnd(String batchEnd) {
	    this.batchEnd = batchEnd;
	}

	public String getBatchTiming() {
		return batchTiming;
	}

	public void setBatchTiming(String batchTiming) {
		this.batchTiming = batchTiming;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "BatchModel [batchId=" + batchId + ", batchName=" + batchName + ", batchStart=" + batchStart
				+ ", batchEnd=" + batchEnd + ", batchTiming=" + batchTiming + ", courseId=" + courseId + "]";
	}
	
	
	
}
