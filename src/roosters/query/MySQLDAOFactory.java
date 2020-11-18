package roosters.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import roosters.dao.AuthDAO;
import roosters.dao.DAOFactory;

public class MySQLDAOFactory extends DAOFactory{    
	
	static {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}

	public static Connection getConnection() {
	    Connection cnx = null;
	        try {
	            cnx = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/rooster?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
	                    "root",
	                    "123456");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    return cnx;
	}

	@Override
	public AuthDAO getAuthDAO() {
		return new AuthQuery();
	}


}
