package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BatchModel;

public class BatchDAO {

	public int getNextBatchId(int courseId) {
	    int nextBatchId = 1; // Start from 1 by default
	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root")) {
	        String query = "SELECT MAX(batchId) AS maxBatchId FROM batch WHERE courseId = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, courseId);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            int maxBatchId = resultSet.getInt("maxBatchId");
	            nextBatchId = maxBatchId + 1; // Increment the max value
	        }
	    } catch (SQLException e) {
	        System.out.println("Error getting next batch ID: " + e.getMessage());
	    }
	    return nextBatchId;
	}

	public String insertBatchDetail(BatchModel batchmodel) {
	    String status = "failure";
	    try {
	        int nextBatchId = getNextBatchId(batchmodel.getCourseId());
	        batchmodel.setBatchId(nextBatchId);

	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root");

	        String query = "INSERT INTO batch (batchId, batchName, batchStart, batchEnd, batchTiming, courseId) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, batchmodel.getBatchId());
	        preparedStatement.setString(2, batchmodel.getBatchName());
	        preparedStatement.setString(3, batchmodel.getBatchStart());
	        preparedStatement.setString(4, batchmodel.getBatchEnd());
	        preparedStatement.setString(5, batchmodel.getBatchTiming());
	        preparedStatement.setInt(6, batchmodel.getCourseId());

	        int rows = preparedStatement.executeUpdate();
	        status = rows > 0 ? "success" : "failure";
	    } catch (Exception e) {
	        System.out.println("Error inserting batch: " + e.getMessage());
	    }
	    return status;
	}
	
	public List<BatchModel> getAllBatches() {
		 List<BatchModel> batches = new ArrayList<>();
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root");
	             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM batch")) {

	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                BatchModel batch = new BatchModel();
	                batch.setBatchId(resultSet.getInt("batchId"));
	                batch.setBatchName(resultSet.getString("batchName"));
	                batch.setBatchStart(resultSet.getString("batchStart"));
	                batch.setBatchEnd(resultSet.getString("batchEnd"));
	                batch.setBatchTiming(resultSet.getString("batchTiming"));
	                batch.setCourseId(resultSet.getInt("courseId"));
	                batches.add(batch);
	            }

	        } catch (SQLException e) {
	            System.out.println("Error retrieving batches: " + e.getMessage());
	        }
	        return batches;
	    }
	
	public BatchModel getBatchById(int batchId, int courseId) {
	    BatchModel batch = null;
	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root")) {
	        String query = "SELECT * FROM batch WHERE batchId = ? AND courseId = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, batchId);
	        preparedStatement.setInt(2, courseId);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            batch = new BatchModel();
	            batch.setBatchId(resultSet.getInt("batchId"));
	            batch.setBatchName(resultSet.getString("batchName"));
	            batch.setBatchStart(resultSet.getString("batchStart"));
	            batch.setBatchEnd(resultSet.getString("batchEnd"));
	            batch.setBatchTiming(resultSet.getString("batchTiming"));
	            batch.setCourseId(resultSet.getInt("courseId"));
	        }
	    } catch (SQLException e) {
	        System.out.println("Error retrieving batch: " + e.getMessage());
	    }
	    return batch;
	}
	
	public boolean updateBatchDetails(BatchModel batch) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root");

	        String query = "UPDATE batch SET batchName = ?, batchStart = ?, batchEnd = ?, batchTiming = ? WHERE courseId = ? AND batchId = ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, batch.getBatchName());
	        statement.setString(2, batch.getBatchStart());
	        statement.setString(3, batch.getBatchEnd());
	        statement.setString(4, batch.getBatchTiming());
	        statement.setInt(5, batch.getCourseId());
	        statement.setInt(6, batch.getBatchId());

	        int rowsAffected = statement.executeUpdate();
	        statement.close();
	        connection.close();
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	        return false;
	    }
	}
	
	public boolean deleteBatchDetails(int batchId, int courseId) {
	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root")) {
	        String query = "DELETE FROM batch WHERE batchId = ? AND courseId = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, batchId);
	        preparedStatement.setInt(2, courseId);

	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        System.out.println("Error deleting batch: " + e.getMessage());
	        return false;
	    }
	}
	
	public List<BatchModel> getBatchesByCourseId(int courseId) {
	    List<BatchModel> batches = new ArrayList<>();
	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root")) {
	        String query = "SELECT * FROM batch WHERE courseId = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, courseId);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            BatchModel batch = new BatchModel();
	            batch.setBatchId(resultSet.getInt("batchId"));
	            batch.setBatchName(resultSet.getString("batchName"));
	            batch.setBatchStart(resultSet.getString("batchStart"));
	            batch.setBatchEnd(resultSet.getString("batchEnd"));
	            batch.setBatchTiming(resultSet.getString("batchTiming"));
	            batch.setCourseId(resultSet.getInt("courseId"));
	            batches.add(batch);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error retrieving batches: " + e.getMessage());
	    }
	    return batches;
	}
}
