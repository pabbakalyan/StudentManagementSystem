package model;

public class FacultyModel {
    private int facultyId;
    private String facultyFirstName;
    private String facultyLastName;
    private long mobile;
    private String email;
    private int yearsExperience;
    private String certificate;
    private String qualification;
    private int batchId;
    private int courseId;

    // Constructors
    public FacultyModel() {}

	public FacultyModel(int facultyId, String facultyFirstName, String facultyLastName, long mobile, String email,
			int yearsExperience, String certificate, String qualification, int batchId, int courseId) {
		super();
		this.facultyId = facultyId;
		this.facultyFirstName = facultyFirstName;
		this.facultyLastName = facultyLastName;
		this.mobile = mobile;
		this.email = email;
		this.yearsExperience = yearsExperience;
		this.certificate = certificate;
		this.qualification = qualification;
		this.batchId = batchId;
		this.courseId = courseId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyFirstName() {
		return facultyFirstName;
	}

	public void setFacultyFirstName(String facultyFirstName) {
		this.facultyFirstName = facultyFirstName;
	}

	public String getFacultyLastName() {
		return facultyLastName;
	}

	public void setFacultyLastName(String facultyLastName) {
		this.facultyLastName = facultyLastName;
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

	public int getYearsExperience() {
		return yearsExperience;
	}

	public void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
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
		return "FacultyModel [facultyId=" + facultyId + ", facultyFirstName=" + facultyFirstName + ", facultyLastName="
				+ facultyLastName + ", mobile=" + mobile + ", email=" + email + ", yearsExperience=" + yearsExperience
				+ ", certificate=" + certificate + ", qualification=" + qualification + ", batchId=" + batchId
				+ ", courseId=" + courseId + "]";
	}

	
}
