package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AttendanceModel;


public class AttendanceDAO {

	 public String markAttendance(AttendanceModel attendance) {
	        String status = "failure";
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root");

	            String query = "INSERT INTO attendance (studentId, batchId, courseId, status, date) VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, attendance.getStudentId());
	            preparedStatement.setInt(2, attendance.getBatchId());
	            preparedStatement.setInt(3, attendance.getCourseId());
	            preparedStatement.setString(4, attendance.getStatus());
	            preparedStatement.setDate(5, new java.sql.Date(attendance.getDate().getTime()));

	            // Debugging statement
	            System.out.println("Inserting date: " + attendance.getDate());

	            int n = preparedStatement.executeUpdate();
	            if (n > 0) {
	                System.out.println("Data Inserted Successfully to the Database!....");
	                status = "success";
	            } else {
	                System.out.println("Something went wrong");
	                status = "failure";
	            }

	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return status;
	    }
	 
	 
    public List<AttendanceModel> getAttendanceWithDetails() {
        List<AttendanceModel> attendanceList = new ArrayList<>();
        try {
            // Database connection setup
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root");

            // Query to fetch attendance along with studentName and batchName
            String query = "SELECT " +
            	    "s.studentId, " +
            	    "s.batchId, " +
            	    "s.courseId, " +
            	    "CONCAT(s.studentFirstName, ' ', s.studentLastName) AS studentName, " + // Change alias to `studentName`
            	    "b.batchName AS batchName, " +                                         // Change alias to `batchName`
            	    "c.courseName, " +
            	    "a.date AS date, " +                                                  // Match field name `date`
            	    "a.status AS status " +                                               // Match field name `status`
            	    "FROM attendance a " +
            	    "JOIN student s ON a.studentId = s.studentId " +
            	    "AND a.batchId = s.batchId " +
            	    "AND a.courseId = s.courseId " +
            	    "JOIN batch b ON a.batchId = b.batchId " +
            	    "AND a.courseId = b.courseId " +
            	    "JOIN course c ON a.courseId = c.courseId";


            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                AttendanceModel attendance = new AttendanceModel();
                attendance.setStudentId(resultSet.getInt("studentId"));
                attendance.setStudentName(resultSet.getString("studentName"));  // New field
                attendance.setBatchId(resultSet.getInt("batchId"));
                attendance.setBatchName(resultSet.getString("batchName"));  // New field
                attendance.setCourseId(resultSet.getInt("courseId"));
                attendance.setStatus(resultSet.getString("status"));
                attendance.setDate(resultSet.getDate("date"));

                // Add the object to the list
                attendanceList.add(attendance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
    
//    public List<AttendanceModel> getAttendanceByStudentsAndBatchAndCourse(int studentId, int batchId, int courseId) {
//        List<AttendanceModel> attendances = new ArrayList<>();
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root")) {
//            String query = "SELECT " +
//                    "s.studentId, " +
//                    "CONCAT(s.studentFirstName, ' ', s.studentLastName) AS studentName, " +
//                    "b.batchId, " +
//                    "b.batchName, " +
//                    "c.courseId, " +
//                    "a.status, " +
//                    "a.date " +
//                    "FROM attendance a " +
//                    "JOIN student s ON a.studentId = s.studentId AND a.batchId = s.batchId AND a.courseId = s.courseId " +
//                    "JOIN batch b ON a.batchId = b.batchId AND a.courseId = b.courseId " +
//                    "JOIN course c ON a.courseId = c.courseId " +
//                    "WHERE a.batchId = ? AND a.courseId = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, batchId);
//            preparedStatement.setInt(2, courseId);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                AttendanceModel attendance = new AttendanceModel();
//                attendance.setStudentId(resultSet.getInt("studentId"));
//                attendance.setStudentName(resultSet.getString("studentName"));
//                attendance.setBatchId(resultSet.getInt("batchId"));
//                attendance.setBatchName(resultSet.getString("batchName"));
//                attendance.setCourseId(resultSet.getInt("courseId"));
//                attendance.setStatus(resultSet.getString("status"));
//                attendance.setDate(resultSet.getDate("date"));
//                attendances.add(attendance);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error retrieving students: " + e.getMessage());
//        }
//        return attendances;
//    }

    public List<AttendanceModel> getAttendanceByCourseBatchAndDate(int courseId, int batchId, String date) {
        List<AttendanceModel> attendanceList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root")) {
            String query = "SELECT DISTINCT s.studentId, s.studentFirstName, s.studentLastName, a.status, a.date "
                         + "FROM student s "
                         + "JOIN attendance a ON s.studentId = a.studentId "
                         + "WHERE s.courseId = ? AND s.batchId = ? AND a.date = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, batchId);
            preparedStatement.setString(3, date);

//            // Debugging statement
//            System.out.println("Executing query with date: " + date);
//            System.out.println("Executing query with courseId: " + courseId);
//            System.out.println("Executing query with batchId: " + batchId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                AttendanceModel attendance = new AttendanceModel();
                attendance.setStudentId(resultSet.getInt("studentId"));
                attendance.setStudentName(resultSet.getString("studentFirstName") + " " + resultSet.getString("studentLastName"));
                attendance.setStatus(resultSet.getString("status"));
                attendance.setDate(resultSet.getDate("date"));
                attendanceList.add(attendance);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving attendance: " + e.getMessage());
        }
        return attendanceList;
    }
    
    
   
    public List<AttendanceModel> getStudentAttendance(String email) {
        List<AttendanceModel> attendanceList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root");

            String query = "SELECT a.date, a.status " +
                    "FROM attendance a " +
                    "JOIN student s " +
                    "ON a.studentId = s.studentId " +
                    "AND a.batchId = s.batchId " +
                    "AND a.courseId = s.courseId " +
                    "WHERE s.email = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                AttendanceModel attendance = new AttendanceModel();
                attendance.setDate(resultSet.getDate("date"));
                attendance.setStatus(resultSet.getString("status"));
                attendanceList.add(attendance);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attendanceList;
    }

}
