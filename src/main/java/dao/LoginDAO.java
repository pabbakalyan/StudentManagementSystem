package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.LoginModel;


public class LoginDAO {
//	String dbuser;
//	String dbpass;
//	boolean b1;
//	
//	public boolean auth(String uname,String pwd) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kalyan","root","root");
//			String query = "SELECT * FROM login WHERE uname = ? AND pwd = ?";
//			
//			PreparedStatement statement = connection.prepareStatement(query);
//			statement.setString(1, uname);
//			statement.setString(2, pwd);
//			ResultSet rs = statement.executeQuery();
//			while(rs.next()) {
//				dbuser = rs.getString(1);
//				dbpass = rs.getString(2);
//				
//				if(uname.equals(dbuser) && pwd.equals(dbpass)) {
//					b1=true;
//					System.out.println("Credentials access Successfully");
//				}
//				else {
//					b1=false;
//					System.out.println("something went wrong");
//				}
//			}
//		}
//		catch (Exception e) {
//			System.out.println(e);
//		}
//		return b1;
//	}
	
	public boolean auth(LoginModel loginModel) {
	    boolean isAuthenticated = false;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root");

	        String query = "SELECT email FROM signin WHERE username = ? AND password = ? AND userType = ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, loginModel.getUsername());
	        statement.setString(2, loginModel.getPassword());
	        statement.setString(3, loginModel.getUserType());

	        ResultSet rs = statement.executeQuery();
	        if (rs.next()) {
	            // Populate email in LoginModel
	            loginModel.setEmail(rs.getString("email"));
	            isAuthenticated = true;
	        }

	        rs.close();
	        statement.close();
	        connection.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return isAuthenticated;
	}

}
