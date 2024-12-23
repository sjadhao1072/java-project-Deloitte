package mypackage;
import java.sql.*;
import java.util.*;
public class UserDao {

	Connection con;
	Scanner sc;
	PreparedStatement ste;
	public UserDao() {
		con = UserConnection.getConnection();
		sc = new Scanner(System.in);
	}
	
	public void validateUser() {
		System.out.println("Enter username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		try {
			ste = con.prepareStatement("SELECT * FROM user WHERE usernaem=? and password=?");
			ste.setString(1, username);
			ste.setString(2, password);
			ResultSet result = ste.executeQuery();
			if(result.next()) {
				System.out.println("Username -" + result.getString(1));
				System.out.println("Name of the user -" + result.getString(3));
			}else {
				System.out.println("User does not exits");
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
		}
	}
	
	public static void main(String args[]) {
		UserDao dao = new UserDao();
		dao.validateUser();
	}
	
	
}
