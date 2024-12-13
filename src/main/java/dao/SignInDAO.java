package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.SignInModel;

public class SignInDAO {

	public String insertDetail(SignInModel signinmodel) {
		String status="failure";
	            try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/application2", "root", "root");
			  	    String query = "INSERT INTO signIn (username, email, password, userType) VALUES (?, ?, ?, ?)";
			        PreparedStatement Preparedstatement = connection.prepareStatement(query);
			        Preparedstatement.setString(1, signinmodel.getUsername());
			        Preparedstatement.setString(2, signinmodel.getEmail());
			        Preparedstatement.setString(3, signinmodel.getPassword());
			        Preparedstatement.setString(4, signinmodel.getUserType());
			        
			        int n = Preparedstatement.executeUpdate();
			        
			        if(n>0) {
			        	System.out.println("Data Inserted Successfully to the Database!....");
			        	status = "success";
			        }
			        else {
			        	System.out.println("something went wrong");
			        	status = "failure";
			        }
			        
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
	           return status;
	}
}
