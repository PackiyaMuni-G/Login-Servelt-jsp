package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import loginform.LoginBean;

public class LoginDao {

	boolean status=false;
	public boolean validate(LoginBean loginBean) throws SQLException, ClassNotFoundException {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "root");
	         PreparedStatement statement = con.prepareStatement("select * from login where username = ? and password = ? ")) {
	        statement.setString(1, loginBean.getUserName());
	        statement.setString(2, loginBean.getPassWord());
	        ResultSet rs = statement.executeQuery();
	        status = rs.next();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Database connection error", e);
	    }
	    return status;
	}
}
