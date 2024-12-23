package mypackage;
import java.sql.*;
public class EmployeeConnect {
	
	private static Connection con; 
	
	private EmployeeConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//it will load driver class dynamically in the project
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DeloiteTraining","root","root123");
			System.out.println("database connected");
		}catch(ClassNotFoundException ex) {
			System.out.println("Unable to load Driever");
		}catch(SQLException ex) {
		
			System.out.println(ex.getMessage());
		}
		
	}
	
	public static Connection getConnect() {
		EmployeeConnect el = new EmployeeConnect();
		return con;
	}

}
