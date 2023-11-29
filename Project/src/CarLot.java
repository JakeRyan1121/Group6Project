package carlot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Represents a CarLot with an inventory of Cars.
 */
public class CarLot extends ArrayList<Car> {

    /**
     * Default constructor that initializes the inventory.
     */
    public CarLot() {
       
    }

    // Accessors

    /**
     * Finds a car by its identifier.
     *
     * @param identifier Identifier of the car to find.
     * @return Car object if found, otherwise null.
     */
    public Car findCarByIdentifier(String identifier) {
        for (Car car : this) {
            if (car.getID().equals(identifier)) {
                return car;
            }
        }
        return null;
    }

    /**
     * Gets all cars in the order they were entered into the inventory.
     *
     * @return ArrayList of cars.
     */
    public ArrayList<Car> getCarsInOrderOfEntry() {
        return new ArrayList<>(this);
    }

    /**
     * Gets all cars by MPG.
     *
     * @return ArrayList of cars sorted by MPG.
     */
    public ArrayList<Car> getCarsSortedByMPG() {
        ArrayList<Car> sortedInventory = new ArrayList<>(this);
        Collections.sort(sortedInventory, (a, b) -> b.compareMPG(a));
        return sortedInventory;
    }

    /**
     * Gets the car with the best MPG.
     *
     * @return Car with the highest MPG.
     */
    public Car getCarWithBestMPG() {
        return Collections.max(this, (a, b) -> a.compareMPG(b));
    }

    /**
     * Gets the car with the highest mileage.
     *
     * @return Car with the highest mileage.
     */
    public Car getCarWithHighestMileage() {
        return Collections.max(this, (a, b) -> a.compareMiles(b));
    }

    /**
     * Gets the average MPG of all cars in the inventory.
     *
     * @return Average MPG.
     */
    public double getAverageMpg() {
        if (this.size() == 0) {
            return 0;
        }

        double totalMpg = 0;
        for (Car car : this) {
            totalMpg += car.getMPG();
        }

        return totalMpg / this.size();
    }

    /**
     * Gets the total profit from all sold cars in the inventory.
     *
     * @return Total profit.
     */
    public double getTotalProfit() {
        double totalProfit = 0;
        for (Car car : this) {
            totalProfit += (car.getPriceSold() - car.getCost());
        }
        return totalProfit;
    }

    // Mutators

    /**
     * Adds a new car to the inventory.
     *
     * @param car The car to add.
     */
    public void addCar(Car car) {
        this.add(car);
    }

    /**
     * Sells a car by its identifier.
     *
     * @param identifier Identifier of the car to sell.
     * @param priceSold  Price at which the car is sold.
     * @throws IllegalArgumentException if the car is not found.
     */
    public void sellCar(String identifier, double priceSold) throws IllegalArgumentException {
        Car carToSell = findCarByIdentifier(identifier);
        if (carToSell == null) {
            throw new IllegalArgumentException("Car not found");
        }
        carToSell.sellCar(priceSold);
    }

    /**
     * Will save CarLot Array to the file carlot.txt
     *
     * @throws FileNotFoundException If the file cannot be found.
     */
    public void saveToDisk() throws FileNotFoundException {
        PrintWriter data = new PrintWriter("carlot.txt");
        for (int i = 0; i < this.size(); i++) {
            data.println(this.get(i).getID());
            data.print("mileage: ");
            data.println(this.get(i).getMileage());
            data.print("MPG: ");
            data.println(this.get(i).getMPG());
            data.print("Cost: ");
            data.println(this.get(i).getCost());
            data.print("Sales_Price: ");
            data.println(this.get(i).getSalesPrice());
            data.print("Is_it_Sold: ");
            data.println(this.get(i).isSold());
            data.print("Sold_Price: ");
            data.println(this.get(i).getPriceSold());
            data.print("Profit: ");
            data.println(this.get(i).getProfit());
            data.println("");
        }
        data.close();
    }

    /**
     * Will load data into CarLot inventory array from the carlot.txt file
     *
     * @throws FileNotFoundException If the file cannot be found.
     */
    public void loadFromDisk() throws FileNotFoundException {
        Scanner input = new Scanner(new File("carlot.txt"));
        double priceSold;
        double profit;
        while (input.hasNext()) {
            String ID = input.next();
            input.next();
            int mileage = input.nextInt();
            input.next();
            int mpg = input.nextInt();
            input.next();
            double cost = input.nextDouble();
            input.next();
            double salesPrice = input.nextDouble();
            input.next();
            boolean sold = input.nextBoolean();
            if (!sold) {
                priceSold = 0.0;
                profit = 0.0;
                input.nextLine();
                input.nextLine();
                input.nextLine();
            } else {
                input.next();
                priceSold = input.nextDouble();
                input.next();
                profit = input.nextDouble();
                input.nextLine();
            }

            Car car = new Car(ID, mileage, mpg, cost, salesPrice);
            car.setSold(sold);
            car.setProfit(profit);
            car.setPriceSold(priceSold);
            this.add(car);
        }
        input.close();
    }
}
