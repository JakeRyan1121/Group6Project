
public class Car {
	private String id = "";
	private int mileage;
	private int mpg;
	private double cost;
	private double salesPrice;
	private boolean sold;
	private double priceSold;
	private double profit;
	// Constructors
	Car() {
	}
	
	Car(String id, int mileage, int mpg, double cost, double salesprice) {
		this.id = id;
		this.mileage = mileage;
		this.mpg = mpg;
		this.cost = cost;
		this.salesPrice = salesPrice;
		
	}
	// Accessors
	public java.lang.String getID() {
		return this.id;
	}
	
	public int getMileage() {
		return this.mileage;
	}
	
	public int getMpg() {
		return this.mpg;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public boolean isSold() {
		return this.sold;
	}
	
	public double getPriceSold() {
		return this.priceSold;
	}
	
	public double getProfit() {
		return this.profit;
	}
	
	public String toString() {
		return id + ", Mileage: " + mileage + ", MPG: " + mpg + ", Sold: " + sold + 
				", Cost: " + cost + ", Selling Price: " + salesPrice + ", Sold For: " +
				priceSold + ", Profit: " + profit;
	}
	
	public int compareMPG(Car b) {
		if (this.mpg > b.mpg) {
			return 1;
		}
		else if (this.mpg < b.mpg) {
			return -1;
		}
		
		else {
			return 0;
		}
	}
	
	public int compareMiles(Car b) {
		if (this.mileage > b.mileage) {
			return 1;
		}
		else if (this.mileage < b.mileage) {
			return -1;
		}
		
		else {
			return 0;
		}
		
	}
	
	public int comparePrice(Car b) {
		if (this.salesPrice > b.salesPrice) {
			return 1;
		}
		else if (this.salesPrice < b.salesPrice) {
			return -1;
		}
		
		else {
			return 0;
		}
	}
	// Mutators
	public void setID(String id) {
		this.id = id;
	}
	
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	public void setMpg(int mpg) {
		this.mpg = mpg;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public void sellCar(double priceSold) {
		this.sold = true;
		this.priceSold = priceSold;
		this.profit = this.priceSold - this.salesPrice;
		
	}
}
