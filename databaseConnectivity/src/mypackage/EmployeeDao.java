package mypackage;
import java.util.*;
import java.sql.*;
public class EmployeeDao {
	private Connection con;
	Scanner sc;
	PreparedStatement stat;
	public EmployeeDao() {
		con = EmployeeConnect.getConnect();
		sc = new Scanner(System.in);
	}
	
	public void insertEmployee() {
		System.out.println("Enter employee code");
		int code = sc.nextInt();
		System.out.println("Enter employee name");
		String name = sc.next();
		System.out.println("Enter address");
		String address = sc.next();
		System.out.println("Enter salasry");
		double salary = sc.nextDouble();
		System.out.println("Enter mobile no");
		String mobile = sc.next();
		
		try {
			stat = con.prepareStatement("insert into employee values(?,?,?,?,?)");
			stat.setInt(1,code);
			stat.setString(2, name);
			stat.setString(3, address);
			stat.setDouble(4, salary);
			stat.setString(5, mobile);
			int result = stat.executeUpdate();
			if(result > 0) {
				System.out.println("Data inserted Succesfully");
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
		}
	}
	
	public void deleteEmployedd()
	{
		System.out.println("Enter employee code");
		int code = sc.nextInt();
		try {
			stat = con.prepareStatement("delete from employee where empcode=?");
			stat.setInt(1, code);
			int result = stat.executeUpdate();
			if(result > 0) {
				System.out.println("Data deleted Succesfully");
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
		}
	}
	
	public void updateEmployeeSalary() {
		System.out.println("Enter employee code");
		int code = sc.nextInt();
		System.out.println("Enter new salary");
		double salry = sc.nextDouble();
		try {
			stat = con.prepareStatement("UPDATE employee SET salary = ? where empcode=?");
			stat.setDouble(1, salry);
			stat.setInt(2, code);
			int result = stat.executeUpdate();
			if(result > 0) {
				System.out.println("Data updated Succesfully");
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
		}
	}
	
	public void getEmployeeDetails() {
		try {
			stat = con.prepareStatement("SELECT * FROM employee");
			ResultSet result = stat.executeQuery();
			while(result.next()) {
				System.out.println("Employee code is - " + result.getInt(1));
				System.out.println("Employee Name - " + result.getString(2));
				System.out.println("Salary is - " + result.getDouble(4));
			}
		}catch(SQLException ex) {
			System.out.println("Exception " + ex.getMessage());
		}
	}
	
	public static void main(String args[]) {
		EmployeeDao dao = new EmployeeDao();
		dao.getEmployeeDetails();
		
	}
	
}
