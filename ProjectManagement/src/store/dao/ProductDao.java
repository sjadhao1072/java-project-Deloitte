package store.dao;
import java.util.*;

import store.pojo.Product;
public class ProductDao {
	private Scanner sc;
	static Map<Integer,Product> mapProduct = new HashMap<Integer,Product>();
	public ProductDao() {
		sc = new Scanner(System.in);
		//mapProduct = new HashMap<Integer,Product>();
	}
	
	public void insertProduct() {
		System.out.println("Emyer how many product you want to insert ");
		int num = sc.nextInt();
		for(int i = 0;i<num;i++) {
			Product pro = new Product();
			System.out.println("Enter product Id");
			int productId = sc.nextInt();
			pro.setProductId(productId);
			System.out.println("Enter Product Name");
			pro.setProductName(sc.next());
			System.out.println("Enter price");
			pro.setBuyingPrice(sc.nextDouble());
			System.out.println("Enter Quantity");
			pro.setAvailableQuantity(sc.nextInt());
			System.out.println("Enter Category");
			pro.setCategory(sc.next());
			mapProduct.put(productId, pro);
		}
		System.out.println(mapProduct.size());
		System.out.println(mapProduct.get(123));
	}
	
	public void displayDetails() {
		System.out.println("From Dispaly Details");
		System.out.println(mapProduct.size());
		mapProduct.entrySet().stream().forEach(data->{
			Product p = data.getValue();
			System.out.println("Product name - " + p.getProductName());
			System.out.println("Product Quantity - " + p.getAvailableQuantity());
			System.out.println("Buying price - " + p.getBuyingPrice());
			System.out.println("Selling price - " + p.getSellingPrice());
		});
	}
	
	public void searchByCategory() {
		System.out.println("Enter Category to search");
		String category = sc.next();
		mapProduct.entrySet().stream().forEach(data ->{
			Product pro = data.getValue();
			if(pro.getCategory().equals(category)) {
				System.out.println("Product name - " + pro.getProductName());
				System.out.println("Buying price - " + pro.getBuyingPrice());
			}
		});
	}
	
	public void searchByname() {
		System.out.println("Enter Product Name");
		String pName = sc.next();
		mapProduct.entrySet().stream().forEach(data->{
			Product pro = data.getValue();
			if(pro.getProductName().equals(pName)) {
				System.out.println("Product name - " + pro.getProductName());
				System.out.println("Buying price - " + pro.getBuyingPrice());
			}
		});
	}
	
	public void searchProductId() {
		System.out.println("Enter Product Id");
		int pId = sc.nextInt();
		mapProduct.entrySet().stream().forEach(data->{
			Product pro = data.getValue();
			if(pro.getProductId() == pId) {
				System.out.println("Product name - " + pro.getProductName());
				System.out.println("Buying price - " + pro.getBuyingPrice());
			}
		});
	}
	
	public void checkTotalAmount() {
		double total = mapProduct.entrySet().stream().map(prod->prod.getValue().getBuyingPrice()).reduce(0.0,(a,b)->a+b);
		System.out.println(total);
	}
	
	public void displayProfit() {
		Map<String,Double> profitCaategoryWise = new HashMap<String,Double>();
		mapProduct.entrySet().stream().forEach(data->{
			Product pro = data.getValue();
			double profit = pro.getSellingPrice() - pro.getBuyingPrice();
			if(profitCaategoryWise.containsKey(pro.getCategory())) {
				profitCaategoryWise.put(pro.getCategory(),profitCaategoryWise.get(pro.getCategory()) + profit );
			}else {
				profitCaategoryWise.put(pro.getCategory(), profit);
			}
		});
		System.out.println("Profit Category Wise - ");
		profitCaategoryWise.entrySet().stream().forEach(data->{
			System.out.println(data.getKey() + " - " + data.getValue());
		});
	}
	
	public void filterByPrice() {
		System.out.println("Enter Price to filter");
		double filterPrice = sc.nextDouble();
		mapProduct.entrySet().stream().forEach(data ->{
			Product pro = data.getValue();
			if(pro.getSellingPrice() == filterPrice) {
				System.out.println("Product name - " + pro.getProductName());
				System.out.println("Selling price - " + pro.getSellingPrice());
			}
		});
	}
}
