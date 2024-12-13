package dao;

import model.DailyTopicModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DailyTopicsDAO {

  
    public String addDailyTopic(DailyTopicModel topic) {
    	String status = "failure";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root");
            String query = "INSERT INTO daily_topics (date, facultyName, batchName, startTime, topicDetails) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, topic.getDate());
            statement.setString(2, topic.getFacultyName());
            statement.setString(3, topic.getBatchName());
            statement.setTime(4, topic.getStartTime());
            statement.setString(5, topic.getTopicDetails());
            
            int n = statement.executeUpdate();
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
    
    public List<DailyTopicModel> getDailyTopics() {
        List<DailyTopicModel> topics = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root","root")) {
        	
        	String query = "select * from daily_topics";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	DailyTopicModel topic = new DailyTopicModel();
                topic.setDate(resultSet.getDate("date"));
                topic.setFacultyName(resultSet.getString("facultyName"));
                topic.setBatchName(resultSet.getString("batchName"));
                topic.setStartTime(resultSet.getTime("startTime"));
                topic.setTopicDetails(resultSet.getString("topicDetails"));
                topics.add(topic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topics;
    }
    
    public List<DailyTopicModel> getDailyTopicsByDate(Date date) {
        List<DailyTopicModel> topics = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root")) {
            String query = "SELECT * FROM daily_topics WHERE date = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, date);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DailyTopicModel topic = new DailyTopicModel();
                topic.setDate(resultSet.getDate("date"));
                topic.setFacultyName(resultSet.getString("facultyName"));
                topic.setBatchName(resultSet.getString("batchName"));
                topic.setStartTime(resultSet.getTime("startTime"));
                topic.setTopicDetails(resultSet.getString("topicDetails"));
                topics.add(topic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topics;
    }
}
