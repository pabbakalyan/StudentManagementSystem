package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FacultyModel;

public class FacultyDAO {
	
	public int getNextFacultyId(int batchId, int courseId) {
	    int nextFacultyId = 1; // Default to 1
	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root")) {
	        String query = "SELECT MAX(facultyId) AS maxFacultyId FROM faculty WHERE batchId = ? AND courseId = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, batchId);
	        preparedStatement.setInt(2, courseId);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            int maxFacultyId = resultSet.getInt("maxFacultyId");
	            nextFacultyId = maxFacultyId + 1;
	        }
	    } catch (SQLException e) {
	        System.out.println("Error getting next student ID: " + e.getMessage());
	    }
	    return nextFacultyId;
	}

	public String insertFacultyDetail(FacultyModel facultymodel) {
		String status = "failure";
		try {
			 int nextFacultyId = getNextFacultyId(facultymodel.getBatchId(), facultymodel.getCourseId());
		     facultymodel.setFacultyId(nextFacultyId);
		     
		     
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root","root");
			
			String query = "INSERT INTO faculty (facultyId, facultyFirstName, facultyLastName, mobile, email, yearsExperience, "
					+ "certificate, qualification, batchId, courseId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, facultymodel.getFacultyId());
			preparedStatement.setString(2, facultymodel.getFacultyFirstName());
			preparedStatement.setString(3, facultymodel.getFacultyLastName());
			preparedStatement.setLong(4, facultymodel.getMobile());
			preparedStatement.setString(5, facultymodel.getEmail());
			preparedStatement.setInt(6, facultymodel.getYearsExperience());
			preparedStatement.setString(7, facultymodel.getCertificate());
			preparedStatement.setString(8, facultymodel.getQualification());
			preparedStatement.setInt(9, facultymodel.getBatchId());
			preparedStatement.setInt(10, facultymodel.getCourseId());

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				status = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<FacultyModel> getAllFaculty() {
		List<FacultyModel> facultys = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2","root","root");
			String query = "select * from faculty";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				FacultyModel faculty = new FacultyModel();
				faculty.setFacultyId(resultSet.getInt("facultyId"));
				faculty.setFacultyFirstName(resultSet.getString("facultyFirstName"));
				faculty.setFacultyLastName(resultSet.getString("facultyLastName"));
				faculty.setMobile(resultSet.getLong("mobile"));
				faculty.setEmail(resultSet.getString("email"));
				faculty.setYearsExperience(resultSet.getInt("yearsExperience"));
				faculty.setCertificate(resultSet.getString("certificate"));
				faculty.setQualification(resultSet.getString("qualification"));
				faculty.setBatchId(resultSet.getInt("batchId"));
				faculty.setCourseId(resultSet.getInt("courseId"));
				facultys.add(faculty);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facultys;
	}
	
	public FacultyModel getFacultyById(int facultyId) {
		FacultyModel faculty = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root",
				"root")) {
			String query = "select * from faculty where facultyId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, facultyId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				faculty = new FacultyModel();
				faculty.setFacultyId(resultSet.getInt("facultyId"));
				faculty.setFacultyFirstName(resultSet.getString("facultyFirstName"));
				faculty.setFacultyLastName(resultSet.getString("facultyLastName"));
				faculty.setMobile(resultSet.getLong("mobile"));
				faculty.setEmail(resultSet.getString("email"));
				faculty.setYearsExperience(resultSet.getInt("yearsExperience"));
				faculty.setCertificate(resultSet.getString("certificate"));
				faculty.setQualification(resultSet.getString("qualification"));
				faculty.setBatchId(resultSet.getInt("batchId"));
				faculty.setCourseId(resultSet.getInt("courseId"));
			}
		}catch(SQLException e) {
			System.out.println("Error retrieving course: " + e.getMessage());
		}
		return faculty;
	}

	public boolean updateFacultyDetails(FacultyModel faculty) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root");

	        String query = "UPDATE faculty SET facultyFirstName = ?, facultyLastName = ?, mobile = ?, email = ?, yearsExperience = ?, certificate = ?, qualification = ?, batchId = ?, courseId = ? WHERE facultyId = ?";
	        PreparedStatement statement = connection.prepareStatement(query);

	        statement.setString(1, faculty.getFacultyFirstName());
	        statement.setString(2, faculty.getFacultyLastName());
	        statement.setLong(3, faculty.getMobile());
	        statement.setString(4, faculty.getEmail());
	        statement.setInt(5, faculty.getYearsExperience());
	        statement.setString(6, faculty.getCertificate());
	        statement.setString(7, faculty.getQualification());
	        statement.setInt(8, faculty.getBatchId());
	        statement.setInt(9, faculty.getCourseId());
	        statement.setInt(10, faculty.getFacultyId());

	        int rowsAffected = statement.executeUpdate();
	        statement.close();
	        connection.close();
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	        return false;
	    }
	}

	public boolean deleteFacultyDetails(int facultyId) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root",
					"root");

			String query = "DELETE FROM faculty WHERE facultyId = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, facultyId);

			int rowsAffected = statement.executeUpdate();
			statement.close();
			connection.close();
			return rowsAffected > 0;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}
	
	public List<FacultyModel> getFacultyByBatchAndCourse(int batchId, int courseId) {
		List<FacultyModel> facultys = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root")) {
	        String query = "SELECT * FROM faculty WHERE batchId = ? AND courseId = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, batchId);
	        preparedStatement.setInt(2, courseId);
	        
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while(resultSet.next()) {
	        	FacultyModel faculty = new FacultyModel();
	        	faculty.setFacultyId(resultSet.getInt("facultyId"));
				faculty.setFacultyFirstName(resultSet.getString("facultyFirstName"));
				faculty.setFacultyLastName(resultSet.getString("facultyLastName"));
				faculty.setMobile(resultSet.getLong("mobile"));
				faculty.setEmail(resultSet.getString("email"));
				faculty.setYearsExperience(resultSet.getInt("yearsExperience"));
				faculty.setCertificate(resultSet.getString("certificate"));
				faculty.setQualification(resultSet.getString("qualification"));
				faculty.setBatchId(resultSet.getInt("batchId"));
				faculty.setCourseId(resultSet.getInt("courseId"));
				facultys.add(faculty);
	        }
		}catch(SQLException e) {
			System.out.println("Error retrieving students: " + e.getMessage());
		}
		return facultys;
	           
	}

}
