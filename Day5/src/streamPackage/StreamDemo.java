package streamPackage;
import java.util.*;
public class StreamDemo {
	
	private List<Integer> arrayList;
	
	public StreamDemo() {
		arrayList = new LinkedList();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(33);
		arrayList.add(30);
		arrayList.add(50);
		arrayList.add(60);
		
	}
	
	public void checkGreater() {
		arrayList.stream().filter(var->var>10).forEach(data->System.out.println("Data is - " + data));
	}
	
	public void checkEven() {
		arrayList.stream().filter(var->var%2==0).forEach(data-> System.out.println("Even Numbers -> " + data));
	}
	
	public void checkOdd() {
		arrayList.stream().filter(var->var%2 != 0).forEach(data-> System.out.println("Odd Number -> " + data));
	}
	
	public void findSquare() {
		arrayList.stream().map(num->num*num).forEach(s->{
				System.out.println("Squre of num->" + s);
			});
		}
	
	public void findSum() {
		int total = arrayList.stream().mapToInt(num->num).sum();
		System.out.println("Sum of numbers - > " + total);
	}
	
	
	public static void main(String args[]) {
		StreamDemo demo = new StreamDemo();
		demo.checkGreater();
		demo.checkEven();
		demo.findSquare();
		demo.findSum();
	}
	
}
