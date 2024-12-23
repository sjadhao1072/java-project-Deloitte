package hashmapPackage;
import java.util.*;
public class StudentMenu {
	
	StudentDao stdou;
	Scanner sc;
	public StudentMenu() {
		stdou = new StudentDao();
		sc = new Scanner(System.in);
	}
	
	public void createMenu() {
		System.out.println("Select your choice");
		int choice  = 'y';
		while(choice == 'y'){
			System.out.println("1 : Insert");
			System.out.println("2 : Delete");
			System.out.println("3 : Update");
			System.out.println("4 : Display");
			System.out.println("5 : Exit");
			System.out.println("Enter You chice");
			
			int cho = sc.nextInt();
			switch(cho) {
			case 1:
				stdou.insertStudent();
				break;
			case 2:
				stdou.deleteStudent();
				break;
			case 3:
				stdou.updateStudent();
				break;
			case 4:
				stdou.displayData();
				break;
			case 5:
				System.exit(0);
			}
		}
		choice = 'y';
	}
	

}
