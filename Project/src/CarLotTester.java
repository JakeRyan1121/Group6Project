public class CarLotTester {
	public static void main(String[] args) {
		
		//*Creates two cars named the Captain Crunch Mobile and DingleBerry Truck*/
	Car car1 = new Car("Captain Crunch Mobile", 3000, 20, 15500.00, 17500.00);
	Car car2 = new Car("DingleBerry Truck", 4000, 50, 7500.00, 10000.00);
	
	//* Displays the details of those cars */
	System.out.println(car1);
	System.out.println(car2);
	
	//* Checks to see if the sellCar() method works and displays an error if it doesn't */
	try {
		 car1.sellCar(-15000);
	}
	catch (Exception ex) {
		System.err.println(ex);
	}
	
	//* Compares the MPG, Miles, and Price between the two cars */
	int mpgComparison = car1.compareMPG(car2);
	System.out.println("The mpg difference between car 1 and car 2 is: " + mpgComparison);
	
	int milesComparison = car1.compareMiles(car2);
	System.out.println("The miles difference between car 1 and car 2 is: " + milesComparison);
	
	int priceComparison = car1.comparePrice(car2);
	System.out.println("The price difference between car 1 and car 2 is: " + priceComparison);
	}
}
