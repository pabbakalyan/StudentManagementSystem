package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.StudentDetailsDTO;
import model.StudentModel;

public class StudentDAO {
	
	public int getNextStudentId(int batchId, int courseId) {
	    int nextStudentId = 1; // Default to 1
	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root")) {
	        String query = "SELECT MAX(studentId) AS maxStudentId FROM student WHERE batchId = ? AND courseId = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, batchId);
	        preparedStatement.setInt(2, courseId);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            int maxStudentId = resultSet.getInt("maxStudentId");
	            nextStudentId = maxStudentId + 1;
	        }
	    } catch (SQLException e) {
	        System.out.println("Error getting next student ID: " + e.getMessage());
	    }
	    return nextStudentId;
	}

	public String insertStudentDetail(StudentModel studentmodel) {
	    String status = "failure";
	    try {
	        int nextStudentId = getNextStudentId(studentmodel.getBatchId(), studentmodel.getCourseId());
	        studentmodel.setStudentId(nextStudentId);

	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root");

	        String query = "INSERT INTO student (studentId, studentFirstName, studentLastName, mobile, email, yrPass, branch, gender, batchId, courseId) " +
	                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, studentmodel.getStudentId());
	        preparedStatement.setString(2, studentmodel.getStudentFirstName());
	        preparedStatement.setString(3, studentmodel.getStudentLastName());
	        preparedStatement.setLong(4, studentmodel.getMobile());
	        preparedStatement.setString(5, studentmodel.getEmail());
	        preparedStatement.setInt(6, studentmodel.getYrPass());
	        preparedStatement.setString(7, studentmodel.getBranch());
	        preparedStatement.setString(8, studentmodel.getGender());
	        preparedStatement.setInt(9, studentmodel.getBatchId());
	        preparedStatement.setInt(10, studentmodel.getCourseId());

	        int rowsInserted = preparedStatement.executeUpdate();
	        if (rowsInserted > 0) {
	            status = "success";
	        }
	    } catch (Exception e) {
	        System.out.println("Error inserting student: " + e.getMessage());
	    }
	    return status;
	}

	public List<StudentModel> getAllStudents() {
		List<StudentModel> students = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root",
				"root")) {
			String query = "SELECT * FROM student";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				StudentModel student = new StudentModel();
				student.setStudentId(resultSet.getInt("studentId"));
				student.setStudentFirstName(resultSet.getString("studentFirstName"));
				student.setStudentLastName(resultSet.getString("studentLastName"));
				student.setMobile(resultSet.getLong("mobile"));
				student.setEmail(resultSet.getString("email"));
				student.setYrPass(resultSet.getInt("yrPass"));
				student.setBranch(resultSet.getString("branch"));
				student.setGender(resultSet.getString("gender"));
				student.setBatchId(resultSet.getInt("batchId"));
				student.setCourseId(resultSet.getInt("courseId"));
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	public StudentModel getStudentById(int studentId) {
		StudentModel student = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root",
				"root")) {
			String query = "SELECT * FROM student WHERE studentId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				student = new StudentModel();
				student.setStudentId(resultSet.getInt("studentId"));
				student.setStudentFirstName(resultSet.getString("studentFirstName"));
				student.setStudentLastName(resultSet.getString("studentLastName"));
				student.setMobile(resultSet.getLong("mobile"));
				student.setEmail(resultSet.getString("email"));
				student.setYrPass(resultSet.getInt("yrPass"));
				student.setBranch(resultSet.getString("branch"));
				student.setGender(resultSet.getString("gender"));
				student.setBatchId(resultSet.getInt("batchId"));
				student.setCourseId(resultSet.getInt("courseId"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving course: " + e.getMessage());
		}
		return student;

	}

	public boolean updateStudentDetails(StudentModel student) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root",
					"root");

			String query = "UPDATE student SET studentFirstName = ?, studentLastName = ?, mobile = ?, email = ?, yrPass = ?, branch = ?, gender = ?, batchId = ?, courseId = ? WHERE studentId = ?";
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, student.getStudentFirstName());
			statement.setString(2, student.getStudentLastName());
			statement.setLong(3, student.getMobile());
			statement.setString(4, student.getEmail());
			statement.setInt(5, student.getYrPass());
			statement.setString(6, student.getBranch());
			statement.setString(7, student.getGender());
			statement.setInt(8, student.getBatchId());
			statement.setInt(9, student.getCourseId());
			statement.setInt(10, student.getStudentId());

			int rowsAffected = statement.executeUpdate();
			statement.close();
			connection.close();
			return rowsAffected > 0;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}

	// Delete Student Method
	public boolean deleteStudentDeatils(int studentId) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root",
					"root");

			String query = "DELETE FROM student WHERE studentId = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, studentId);

			int rowsAffected = statement.executeUpdate();
			statement.close();
			connection.close();
			return rowsAffected > 0;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}
	
	public List<StudentModel> getStudentsByBatchAndCourse(int batchId, int courseId) {
	    List<StudentModel> students = new ArrayList<>();
	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root")) {
	        String query = "SELECT * FROM student WHERE batchId = ? AND courseId = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, batchId);
	        preparedStatement.setInt(2, courseId);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            StudentModel student = new StudentModel();
	            student.setStudentId(resultSet.getInt("studentId"));
	            student.setStudentFirstName(resultSet.getString("studentFirstName"));
	            student.setStudentLastName(resultSet.getString("studentLastName"));
	            student.setMobile(resultSet.getLong("mobile"));
	            student.setEmail(resultSet.getString("email"));
	            student.setYrPass(resultSet.getInt("yrPass"));
	            student.setBranch(resultSet.getString("branch"));
	            student.setGender(resultSet.getString("gender"));
	            student.setBatchId(resultSet.getInt("batchId"));
	            student.setCourseId(resultSet.getInt("courseId"));
	            students.add(student);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error retrieving students: " + e.getMessage());
	    }
	    return students;
	}


	public List<StudentDetailsDTO> getEnrolledDetails(String email) {
		List<StudentDetailsDTO> details = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root",
					"root");

			String query = "SELECT c.courseName, c.courseDuration, c.courseFees, b.batchName, b.batchStart, b.batchEnd, b.batchTiming, "
					+ "CONCAT(f.facultyFirstName, ' ', f.facultyLastName) AS facultyName " + "FROM student s "
					+ "JOIN batch b ON s.batchId = b.batchId " + "JOIN course c ON b.courseId = c.courseId "
					+ "JOIN faculty f ON c.courseId = f.courseId " + "WHERE s.email = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				StudentDetailsDTO detail = new StudentDetailsDTO();
				detail.setCourseName(rs.getString("courseName"));
				detail.setCourseDuration(rs.getString("courseDuration"));
				detail.setCourseFees(rs.getInt("courseFees"));
				detail.setBatchName(rs.getString("batchName"));
				detail.setBatchStart(rs.getDate("batchStart"));
				detail.setBatchEnd(rs.getDate("batchEnd"));
				detail.setBatchTiming(rs.getString("batchTiming"));
				detail.setFacultyName(rs.getString("facultyName"));
				details.add(detail);
			}

			rs.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return details;
	}

}
