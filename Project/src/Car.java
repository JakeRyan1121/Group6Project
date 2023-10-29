/**
 * Represents a Car with attributes such as ID, mileage, MPG, and cost.
 * Also provides functionalities like comparison and selling.
 */
public class Car {
	private String id;
	private int mileage;
	private int mpg;
	private double cost;
	private double salesPrice;
	private boolean sold;
	private double priceSold;
	private double profit;

	/**
	 * Default constructor that initializes a car with default values.
	 */
	public Car() {
		this.id = "";
		this.mileage = 0;
		this.mpg = 0;
		this.cost = 0.0;
		this.salesPrice = 0.0;
		this.sold = false;
		this.priceSold = 0.0;
		this.profit = 0.0;
	}

	/**
	 * Overloaded constructor for creating a new car.
	 * @param id Car ID
	 * @param mileage Mileage of the car
	 * @param mpg Miles per gallon
	 * @param cost Cost of the car
	 * @param salesPrice Selling price
	 */
	public Car(String id, int mileage, int mpg, double cost, double salesPrice) {
		this.id = id;
		this.mileage = mileage;
		this.mpg = mpg;
		this.cost = cost;
		this.salesPrice = salesPrice;
		this.sold = false;  // Not sold when created
		this.priceSold = 0.0;  // Initialize to zero
		this.profit = 0.0;  // Initialize to zero
	}

	/**
	 * @return Car ID
	 */
	public String getID() { return this.id; }

	/**
	 * @return Mileage of the car
	 */
	public int getMileage() { return this.mileage; }

	/**
	 * @return Miles per gallon of the car
	 */
	public int getMPG() { return this.mpg; }

	/**
	 * @return Cost of the car
	 */
	public double getCost() { return this.cost; }

	/**
	 * @return Selling price of the car
	 */
	public double getSalesPrice() { return this.salesPrice; }

	/**
	 * @return True if the car is sold, false otherwise
	 */
	public boolean isSold() { return this.sold; }

	/**
	 * @return Price the car was sold for
	 */
	public double getPriceSold() { return this.priceSold; }

	/**
	 * @return Profit made from selling the car
	 */
	public double getProfit() { return this.profit; }

	/**
	 * @return Human-readable string representation of the Car object.
	 */
	@Override
	public String toString() {
		return id + ", Mileage: " + mileage + ", MPG: " + mpg + ", Sold: " + sold +
				", Cost: " + cost + ", Selling Price: " + salesPrice + ", Sold For: " +
				priceSold + ", Profit: " + profit;
	}

	/**
	 * Compare cars based on MPG.
	 * @param otherCar Car to compare against
	 * @return int representing comparison result
	 */
	public int compareMPG(Car otherCar) {
		return Integer.compare(this.mpg, otherCar.mpg);
	}

	/**
	 * Compare cars based on mileage.
	 * @param otherCar Car to compare against
	 * @return int representing comparison result
	 */
	public int compareMiles(Car otherCar) {
		return Integer.compare(this.mileage, otherCar.mileage);
	}

	/**
	 * Compare cars based on selling price.
	 * @param otherCar Car to compare against
	 * @return int representing comparison result
	 */
	public int comparePrice(Car otherCar) {
		return Double.compare(this.salesPrice, otherCar.salesPrice);
	}

	/**
	 * Sells the car. Calculates the profit and updates the status.
	 * @param priceSold Price for which the car was sold
	 */
	public void sellCar(double priceSold) {
		if(priceSold < 0) {
			throw new IllegalArgumentException("Price sold cannot be negative");
		}
		this.sold = true;
		this.priceSold = priceSold;
		this.profit = this.priceSold - this.cost;
	}
}
