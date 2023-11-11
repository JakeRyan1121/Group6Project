import java.util.ArrayList;
import java.util.Collections;
import java.io.File;

/**
 * Represents a CarLot with an inventory of Cars.
 */
public class CarLot {
    private ArrayList<Car> inventory;

    /**
     * Default constructor that initializes the inventory.
     */
    public CarLot() {
        this.inventory = new ArrayList<>();
    }

    // Accessors
    /**
     * Finds a car by its identifier.
     * @param identifier Identifier of the car to find.
     * @return Car object if found, otherwise null.
     */
    public Car findCarByIdentifier(String identifier) {
        for (Car car : inventory) {
            if (car.getID().equals(identifier)) {
                return car;
            }
        }
        return null;
    }

    /**
     * Gets all cars in the order they were entered into the inventory.
     * @return ArrayList of cars.
     */
    public ArrayList<Car> getCarsInOrderOfEntry() {
        return new ArrayList<>(inventory);
    }

    /**
     * Gets all cars sorted by MPG.
     * @return ArrayList of cars sorted by MPG.
     */
    public ArrayList<Car> getCarsSortedByMPG() {
        ArrayList<Car> sortedInventory = new ArrayList<>(inventory);
        Collections.sort(sortedInventory, (a, b) -> a.compareMPG(b));
        return sortedInventory;
    }

    /**
     * Gets the car with the best MPG.
     * @return Car with the highest MPG.
     */
    public Car getCarWithBestMPG() {
        return Collections.max(inventory, (a, b) -> a.compareMPG(b));
    }

    /**
     * Gets the car with the highest mileage.
     * @return Car with the highest mileage.
     */
    public Car getCarWithHighestMileage() {
        return Collections.max(inventory, (a, b) -> a.compareMiles(b));
    }

    /**
     * Gets the average MPG of all cars in the inventory.
     * @return Average MPG.
     */
    public double getAverageMpg() {
        if (inventory.size() == 0) {
            return 0;
        }

        double totalMpg = 0;
        for (Car car : inventory) {
            totalMpg += car.getMPG();
        }

        return totalMpg / inventory.size();
    }

    /**
     * Gets the total profit from all sold cars in the inventory.
     * @return Total profit.
     */
    public double getTotalProfit() {
        double totalProfit = 0;
        for (Car car : inventory) {
            totalProfit += (car.getSalesPrice() - car.getCost());
        }
        return totalProfit;
    }

    // Mutators
    /**
     * Adds a new car to the inventory.
     */

    public void addCar(Car car) {
        inventory.add(car);
    }

    /**
     * Sells a car by its identifier.
     * @param identifier Identifier of the car to sell.
     * @param priceSold Price at which the car is sold.
     * @throws IllegalArgumentException if the car is not found.
     */
    public void sellCar(String identifier, double priceSold) throws IllegalArgumentException {
        Car carToSell = findCarByIdentifier(identifier);
        if (carToSell == null) {
            throw new IllegalArgumentException("Car not found");
        }
        carToSell.sellCar(priceSold);
    }
    public void saveToDisk() {
        
}
