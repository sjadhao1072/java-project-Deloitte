package management.connect;
import java.sql.*;
public class DatabaseConnect {
private static Connection con; 
	
	private DatabaseConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//it will load driver class dynamically in the project
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeManagement","root","root123");
			System.out.println("database connected");
		}catch(ClassNotFoundException ex) {
			System.out.println("Unable to load Driever");
		}catch(SQLException ex) {
		
			System.out.println(ex.getMessage());
		}
	}
	
	public static Connection getConnect() {
		DatabaseConnect el = new DatabaseConnect();
		return con;
	}

}
