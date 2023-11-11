import java.util.Scanner;

/**
 * Main class that interacts with the CarLot and manages the car inventory.
 */
public class CarLotMain {

    /**
     * The main method that runs the CarLot management system.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CarLot carLot = new CarLot(); // Initializes the car lot

        int option;
        do {
            // Displays the menu options
            System.out.println("[0] Exit");
            System.out.println("[1] Add a car to inventory");
            System.out.println("[2] Sell a car from inventory");
            System.out.println("[3] List inventory by order of acquisition");
            System.out.println("[4] List inventory from Best MPG to Worst MPG");
            System.out.println("[5] Display car with Best MPG");
            System.out.println("[6] Display car with the highest mileage");
            System.out.println("[7] Display overall MPG for the entire inventory");
            System.out.println("[8] Display profit for all sold cars");
            System.out.println("[9] Save current Data to Disk");
            System.out.println("[10] Load Data from Disk");

            System.out.print("Enter a number from 0 to 8: ");
            option = input.nextInt();

            if (option == 0) {
                System.out.println("Exiting. Goodbye");
            } else if (option == 1) {
                // Adds a car to inventory
                Car car = createCar(input);
                carLot.addCar(car);
                System.out.println("Car added to the inventory.");
            } else if (option == 2) {
                // Sells a car from inventory
                System.out.print("Enter the car identifier to sell: ");
                String identifier = input.next();
                System.out.print("Enter the selling price: ");
                double priceSold = input.nextDouble();
                try {
                    carLot.sellCar(identifier, priceSold);
                    System.out.println("Car sold successfully.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (option == 3) {
                // List inventory by order of acquisition
                displayCars(carLot.getCarsInOrderOfEntry());
            } else if (option == 4) {
                // List inventory from Best MPG to Worst MPG
                displayCars(carLot.getCarsSortedByMPG());
            } else if (option == 5) {
                // Display car with Best MPG
                Car bestMpgCar = carLot.getCarWithBestMPG();
                if (bestMpgCar != null) {
                    System.out.println("Car with the best MPG:\n" + bestMpgCar);
                } else {
                    System.out.println("No cars in the inventory.");
                }
            } else if (option == 6) {
                // Display car with the highest mileage
                Car highestMileageCar = carLot.getCarWithHighestMileage();
                if (highestMileageCar != null) {
                    System.out.println("Car with the highest mileage:\n" + highestMileageCar);
                } else {
                    System.out.println("No cars in the inventory.");
                }
            } else if (option == 7) {
                // Display overall MPG for the entire inventory
                double averageMpg = carLot.getAverageMpg();
                System.out.println("Average MPG for the entire inventory: " + averageMpg);
            } else if (option == 8) {
                // Display profit for all sold cars
                double totalProfit = carLot.getTotalProfit();
                System.out.println("Total profit for all sold cars: $" + totalProfit);
            } else if (option == 9) {
                carLot.saveToDisk()
                System.out.println("Data Saved") 
            } else if (option == 10) {
                carLot.loadFromDisk()
                System.out.println("Data Loaded")
            } else {
                System.out.println("Invalid option. Please enter a number from 0 to 10.");
            }

            if (option != 0) {
                System.out.print("Press any key and hit ENTER to continue.");
                input.next();
            }
        } while (option != 0);

        input.close();
    }

    /**
     * Method that creates a Car object based on the user's input.
     *
     * @param input The Scanner that reads the user input.
     * @return A new Car object that's created from the user's input.
     */
    private static Car createCar(Scanner input) {
        System.out.print("Enter car ID: ");
        String id = input.next();
        System.out.print("Enter mileage: ");
        int mileage = input.nextInt();
        System.out.print("Enter MPG: ");
        int mpg = input.nextInt();
        System.out.print("Enter cost: ");
        double cost = input.nextDouble();
        System.out.print("Enter selling price: ");
        double salesPrice = input.nextDouble();
        return new Car(id, mileage, mpg, cost, salesPrice);
    }

    /**
     * Method to display the list of cars.
     *
     * @param cars The collection that will be displayed.
     */
    private static void displayCars(Iterable<Car> cars) {
        System.out.println("Car Inventory:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
