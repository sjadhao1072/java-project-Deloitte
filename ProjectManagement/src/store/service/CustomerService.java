package store.service;
import java.util.*;

import store.dao.ProductDao;
public class CustomerService {
	Scanner sc;
	ProductDao pdao;
	
	public CustomerService() {
		sc = new Scanner(System.in);
		pdao = new ProductDao();
	}
	public void customerMenu() {
		System.out.println("1.Filter by price ");
		System.out.println("2. Dispplay List of Products");
		System.out.println("3. Display Product by category ");
		
		int choice = 'y';
		while(choice == 'y') {
			System.out.println("1.Filter by price ");
			System.out.println("2. Dispplay List of Products");
			System.out.println("3. Display Product by category ");
			System.out.println("Select your choice-----------");
			int uchoice = sc.nextInt();
			switch(uchoice) {
				case 1:
					pdao.filterByPrice();
					break;
				case 2:
					pdao.displayDetails();
					break;
				case 3:
					pdao.searchByCategory();
					break;
			}
		}
	}
}
