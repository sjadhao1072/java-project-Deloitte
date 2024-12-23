package store.service;
import java.util.*;

import store.dao.ProductDao;
import store.pojo.User;
public class UserService {
	Scanner sc;
	User userObj;
	AdminService adminService;
	CustomerService customerService;
	ProductDao pdao;
	public UserService() {
		sc = new Scanner(System.in);
		userObj = new User();
		adminService = new AdminService();
		customerService = new CustomerService();
		pdao = new ProductDao();
	}
	
	public void checkUser() {
		System.out.println("Data Setup_____");
		pdao.insertProduct();
		System.out.println("Data Setup Done_____");
		System.out.println("Enter username");
		userObj.setUsername(sc.next());
		System.out.println("Enter Password");
		userObj.setPassword(sc.next());
		
		if(userObj.getUsername().equals("admin") && userObj.getPassword().equals("admin")) {
			adminService.adminMenu();
		}else {
			customerService.customerMenu();
		}
	}
	
	public static void main(String args[]) {
		UserService service = new UserService();
		service.checkUser();
	}
}
