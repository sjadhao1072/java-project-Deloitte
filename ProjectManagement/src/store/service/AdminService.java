package store.service;
import java.util.*;

import store.dao.ProductDao;
public class AdminService {
	Scanner sc;
	ProductDao pdao;
	public AdminService() {
		sc = new Scanner(System.in);
		pdao = new ProductDao();
	}
	
	public void adminMenu() {
		
		char c = 'y';
		while(c == 'y') {
			System.out.println("1. List the products in the store" );
			System.out.println("2. Search the product by using productid");
			System.out.println("3. List the products by category");
			System.out.println("4. Search the product by using the name");
			System.out.println("5. To check the total amount, spend on her products");
			System.out.println(" 6. the Profit amount that she gets on category wise");
			System.out.println("7. Exit");
			System.out.println("Select Choice----");
			int choice = sc.nextInt();
			switch(choice) {
				case 1:
					pdao.displayDetails();
					break;
				case 2:
					pdao.searchProductId();
					break;
				case 3 : 
					pdao.searchByCategory();
					break;
				case 4:
					pdao.searchByname();
					break;
				case 5:
					pdao.checkTotalAmount();
					break;
				case 6:
					pdao.displayProfit();
					break;
				case 7:
					System.exit(0);
			}
		}
	}

}
