package model;

public class StudentModel {

	private int studentId;
	private String studentFirstName;
	private String studentLastName;
	private long mobile;
	private String email;
	private int yrPass;
	private String branch;
	private String gender;
	private int batchId;
	private int courseId;
	

	// Constructors
	public StudentModel() {
	}

	public StudentModel(int studentId, String studentFirstName, String studentLastName, long mobile, String email,
			int yrPass, String branch, String gender, int batchId, int courseId) {
		this.studentId = studentId;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.mobile = mobile;
		this.email = email;
		this.yrPass = yrPass;
		this.branch = branch;
		this.gender = gender;
		this.batchId = batchId;
		this.courseId = courseId;
	}

	// Getters and Setters
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getYrPass() {
		return yrPass;
	}

	public void setYrPass(int yrPass) {
		this.yrPass = yrPass;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	@Override
	public String toString() {
		return "StudentModel [studentId=" + studentId + ", studentFirstName=" + studentFirstName + ", studentLastName="
				+ studentLastName + ", mobile=" + mobile + ", email=" + email + ", yrPass=" + yrPass + ", branch="
				+ branch + ", gender=" + gender + ", batchId=" + batchId + ", courseId=" + courseId + "]";
	}

}
