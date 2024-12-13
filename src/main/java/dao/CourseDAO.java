package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CourseModel;

public class CourseDAO {

	public String insertCourseDetails(CourseModel coursemodel) {
		String status = "failure";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root",
					"root");
			String query = "INSERT INTO course (courseId, courseName, courseDuration, courseFees) VALUES (?, ?, ?, ?)";
			PreparedStatement Preparedstatement = connection.prepareStatement(query);
			Preparedstatement.setInt(1, coursemodel.getCourseId());
			Preparedstatement.setString(2, coursemodel.getCourseName());
			Preparedstatement.setString(3, coursemodel.getCourseDuration());
			Preparedstatement.setInt(4, coursemodel.getCourseFees());

			int n = Preparedstatement.executeUpdate();

			if (n > 0) {
				System.out.println("Data Inserted Successfully to the Database!....");
				status = "success";
			} else {
				System.out.println("something went wrong");
				status = "failure";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return status;

	}

	public List<CourseModel> getAllCourses() {
		List<CourseModel> courses = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root",
				"root")) {
			String query = "SELECT * FROM course";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				CourseModel course = new CourseModel();
				course.setCourseId(resultSet.getInt("courseId"));
				course.setCourseName(resultSet.getString("courseName"));
				course.setCourseDuration(resultSet.getString("courseDuration"));
				course.setCourseFees(resultSet.getInt("courseFees"));
				courses.add(course);
			}

		} catch (SQLException e) {
			System.out.println("Error retrieving courses: " + e.getMessage());
		}
		return courses;
	}

	// get Course By Id
	public CourseModel getCourseById(int courseId) {
		CourseModel course = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root",
				"root")) {
			String query = "SELECT * FROM course WHERE courseId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, courseId);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				course = new CourseModel();
				course.setCourseId(resultSet.getInt("courseId"));
				course.setCourseName(resultSet.getString("courseName"));
				course.setCourseDuration(resultSet.getString("courseDuration"));
				course.setCourseFees(resultSet.getInt("courseFees"));
			}
		} catch (SQLException e) {
			System.out.println("Error retrieving course: " + e.getMessage());
		}
		return course;
	}

	public boolean updateCourseDetails(CourseModel course) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root",
				"root")) {
			String query = "UPDATE course SET courseName = ?, courseDuration = ?, courseFees = ? WHERE courseId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, course.getCourseName());
			preparedStatement.setString(2, course.getCourseDuration());
			preparedStatement.setInt(3, course.getCourseFees());
			preparedStatement.setInt(4, course.getCourseId());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			System.out.println("Error updating course: " + e.getMessage());
			return false;
		}
	}

	public boolean deleteCourseDetails(int courseId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root",
					"root");

			String query = "DELETE FROM course WHERE courseId = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, courseId);

			int rowsAffected = statement.executeUpdate();
			statement.close();
			connection.close();
			return rowsAffected > 0;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}

}
