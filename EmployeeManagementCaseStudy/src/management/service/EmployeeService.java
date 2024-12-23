package management.service;
import java.util.Scanner;

import management.dao.EmployeeDao;
public class EmployeeService {
	
	private EmployeeDao emDao;
	private Scanner sc;
	public EmployeeService(){
		emDao = new EmployeeDao();
		sc = new Scanner(System.in);
	}
	
	public void empMenu() {
		char c = 'y';
		while(c == 'y') {
			System.out.println("1. Add employee details" );
			System.out.println("2. Update employee details");
			System.out.println("3. Remove employee details");
			System.out.println("4. Display Employee details");
			System.out.println("5. Search Employee");
			System.out.println("6. Exit");

			int choice = sc.nextInt();
			switch(choice) {
				case 1:
					emDao.addEmployee();
					break;
				case 2:
					emDao.updateEmployee();
					break;
				case 3 : 
					emDao.removeEmployee();
					break;
				case 4:
					emDao.displayEmployee();
					break;
				case 5:
					emDao.searchEmployee();
					break;
				case 6:
					System.exit(0);
			} }
	}
		
	public static void main(String args[]) {
		EmployeeService empService = new EmployeeService();
		empService.empMenu();
	}
	

}
