package management.dao;
import java.util.Scanner;

import management.pojo.Employee;

import java.sql.*;
public class EmployeeDao {
	private Connection con;
    private	Employee emp;
    private Scanner sc;
	PreparedStatement stat;

	public EmployeeDao() {
		con = EmployeeConnect.getConnect();
		sc = new Scanner(System.in);
	}
	
	
	public void addEmployee() {
		System.out.println("Enter number of employess");
		int num = sc.nextInt();
		stat = con.prepareStatement("insert into employee values(?,?,?)");
		try {
			for(int i = 0;i<num;i++) {
				System.out.println("Enter Employee Id");
				stat.setInt(1,sc.nextInt());
				System.out.println("Enter Employee Name");
				stat.setString(1,sc.next());
				System.out.println("Enter Employee Department");
				stat.setString(1,sc.next());
				stat.addBatch();
			}
			int result = stat.executeUpdate();
			if(result > 0) {
				System.out.println("Employee data inserted Succesfully");
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
		}
	}
	
	
	public void updateEmployee() {
		System.out.println("Enter Employee Id to update");
		int id = sc.nextInt();
		System.out.println("Enter Department  to update");
		String newDepart = sc.nextString();
		try {
			stat = con.prepareStatement("UPDATE employee SET department = ? WHERE empId = ?");
			stat.setInt(1,id);
			stat.setString(1,newDepart);
			int result = stat.executeUpdate();
			if(result > 0) {
				System.out.println("Employee data updated Succesfully");
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
		}		
	}
	
	public void displayEmployee() {
		try {
			stat = con.prepareStatement("SELECT * FROM employee");
			ResultSet result = stat.executeQuery();
			while(result.next()) {
				System.out.println("Employee Id is - " + result.getInt(1));
				System.out.println("Employee Name - " + result.getString(2));
				System.out.println("Department is - " + result.getString(3));
			}
		}catch(SQLException ex) {
			System.out.println("Exception " + ex.getMessage());
		}
	}
	
	public void removeEmployee() {
		System.out.println("Enter employee code to delete");
		int code = sc.nextInt();
		try {
			stat = con.prepareStatement("delete from employee where empId=?");
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
	
	public void searchEmployee() {
		System.out.println("Select Criteria to search employee.");
		System.out.println("1. EmpId");
		System.out.println("2. Emp Name");
		System.out.println("3. Emp Department");
		int choice = sc.nextInt();
		if(choice == 1) {
			System.out.println("Enter emp Id - ");
			int empId = sc.nextInt();
			stat = con.prepareStatement("SELECT * FROM employee WHERE empId = ?");
			stat.setInt(1,empId);
		}else if(choice == 2) {
			System.out.println("Enter emp Name - ");
			String empName = sc.nextInt();
			stat = con.prepareStatement("SELECT * FROM employee WHERE name = ?");
			stat.setString(1,empName);
		}else if(choice == 3) {
			System.out.println("Enter emp Department - ");
			String empDepa = sc.nextInt();
			stat = con.prepareStatement("SELECT * FROM employee WHERE department = ?");
			stat.setString(1,empDepa); 
		}
		ResultSet result = stat.executeQuery();
		while(result.next()) {
			System.out.println("Employee Id is - " + result.getInt(1));
			System.out.println("Employee Name - " + result.getString(2));
			System.out.println("Department is - " + result.getString(3));
		}
	}
}
