
/**
 * Tester class for CarLot.
 * This class tests the functionalities of the Car and CarLot classes.
 */
public class CarLotTester {
    public static void main(String[] args) {

        // Initialize a CarLot instance
        CarLot carLot = new CarLot();

        // Create several Car objects with different attributes
        Car car1 = new Car("1", 50000, 30, 20000, 25000);
        Car car2 = new Car("2", 30000, 35, 22000, 27000);
        Car car3 = new Car("3", 40000, 32, 21000, 26000);

        // Add the created Car objects to the CarLot's inventory
        carLot.addCar(car1);
        carLot.addCar(car2);
        carLot.addCar(car3);

        // Test the findCarByIdentifier method
        // Should return the correct Car object for a given ID
        assert carLot.findCarByIdentifier("1").equals(car1) : "Error in findCarByIdentifier";

        // Test the getCarsInOrderOfEntry method
        // Should return a list of cars in the order they were added
        assert carLot.getCarsInOrderOfEntry().get(0).equals(car1) : "Error in getCarsInOrderOfEntry";

        // Test the getCarsSortedByMPG method
        // Should return a sorted list of cars based on MPG
        assert carLot.getCarsSortedByMPG().get(0).equals(car2) : "Error in getCarsSortedByMPG";

        // Test the getCarWithBestMPG method
        // Should return the car with the highest MPG
        assert carLot.getCarWithBestMPG().equals(car2) : "Error in getCarWithBestMPG";

        // Test the getCarWithHighestMileage method
        // Should return the car with the highest mileage
        assert carLot.getCarWithHighestMileage().equals(car1) : "Error in getCarWithHighestMileage";

        // Test the getAverageMpg method
        // Should return the correct average MPG of all cars
        assert carLot.getAverageMpg() == ((car1.getMPG() + car2.getMPG() + car3.getMPG()) / 3.0) : "Error in getAverageMpg";

        // Test the sellCar method and getTotalProfit method
        // Sell a couple of cars and then check if the total profit is calculated correctly
        carLot.sellCar("1", 26000);
        carLot.sellCar("2", 28000);
        assert carLot.getTotalProfit() == ((26000 - car1.getCost()) + (28000 - car2.getCost())) : "Error in getTotalProfit";

        // Test File I/O functionality
        try {
            // Save the current state of carLot to a file
            carLot.saveToDisk();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error saving to disk.");
        }

        try {
            // Load the state into a new CarLot instance and verify if the data is loaded correctly
            CarLot newCarLot = new CarLot();
            newCarLot.loadFromDisk();
            assert newCarLot.findCarByIdentifier("1") != null : "Error in loadFromDisk";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading from disk.");
        }

        // Print a message indicating all tests have passed
        System.out.println("All tests passed!");
    }
}
