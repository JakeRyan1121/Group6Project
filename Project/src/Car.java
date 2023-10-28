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
	 * Default constructor.
	 */
	public Car() {
		// Initializes to default values.
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
	}

	// Accessors with minor JavaDoc comments.
	/** @return Car ID */
	public String getID() { return this.id; }

	/** @return Mileage */
	public int getMileage() { return this.mileage; }

	/** @return MPG */
	public int getMpg() { return this.mpg; }

	/** @return Cost */
	public double getCost() { return this.cost; }

	/** @return Sold status */
	public boolean isSold() { return this.sold; }

	/** @return Sold price */
	public double getPriceSold() { return this.priceSold; }

	/** @return Profit */
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

	// Comparison methods
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

	// Mutators
	/**
	 * Sets the ID of the car.
	 * @param id New ID
	 */
	public void setID(String id) { this.id = id; }

	/**
	 * Sets the mileage of the car.
	 * @param mileage New mileage
	 */
	public void setMileage(int mileage) { this.mileage = mileage; }

	/**
	 * Sets the MPG of the car.
	 * @param mpg New MPG
	 */
	public void setMpg(int mpg) { this.mpg = mpg; }

	/**
	 * Sets the cost of the car.
	 * @param cost New cost
	 */
	public void setCost(double cost) { this.cost = cost; }

	/**
	 * Sells the car.
	 * @param priceSold Price for which the car was sold
	 */
	public void sellCar(double priceSold) {
		this.sold = true;
		this.priceSold = priceSold;
		this.profit = this.priceSold - this.cost;
	}
}
