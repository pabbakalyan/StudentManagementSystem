package model;

public class LoginModel {

    private String username;
    private String password;
    private String userType;
    private String email; 

    
    public LoginModel() {}

    
    public LoginModel(String username, String password, String userType, String email) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.email = email;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() { 
        return email;
    }

    public void setEmail(String email) { 
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginModel [username=" + username + ", password=" + password + ", userType=" + userType + ", email=" + email + "]";
    }
}
