package store.pojo;

public class Product extends Item{
	private int productId;
	private String productName;
	private double sellingPrice;
	private int availableQuantity;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSellingPrice() {
		return (this.getBuyingPrice()*0.5)+this.getBuyingPrice();
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = (this.getBuyingPrice()*0.5)+this.getBuyingPrice();
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
 
}