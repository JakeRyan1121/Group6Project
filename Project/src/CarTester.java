/**
 * Class to test the functionalities of the Car class.
 */
public class CarTester {

	/**
	 * Main method to run tests.
	 * @param args Command line arguments (none expected)
	 */
	public static void main(String[] args) {
		// Initialize a CarLot object to hold cars
		CarLot carLot = new CarLot();

		// Initialize two Car objects with different attributes
		Car car1 = new Car("Captain Crunch Mobile", 3000, 20, 15500.0, 17500.0);
		Car car2 = new Car("DingleBerry Truck", 4000, 50, 7500.0, 10000.0);

		// Test 1: Add cars to CarLot
		carLot.addCar(car1);
		carLot.addCar(car2);

		// Test 2: Display individual car details
		System.out.println("Car 1 Details: " + car1);
		System.out.println("Car 2 Details: " + car2);

		// Test 3: Try to sell a car at a negative price (should throw an exception)
		try {
			car1.sellCar(-15000.0);
		} catch (Exception e) {
			System.out.println("Test 3 result (expect an error): " + e.getMessage());
		}

		// Test 4: Compare cars based on MPG, mileage, and price
		System.out.println("MPG Difference: " + car1.compareMPG(car2));
		System.out.println("Mileage Difference: " + car1.compareMiles(car2));
		System.out.println("Price Difference: " + car1.comparePrice(car2));

		// Test 5: Sell a car and display the details afterward
		try {
			car1.sellCar(16000.0);
		} catch (Exception e) {
			System.out.println("Test 5 result (expect an error): " + e.getMessage());
		}
		System.out.println("Updated Car 1 Details: " + car1);
	}
}
