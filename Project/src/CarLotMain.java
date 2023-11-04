/**
 * 
 */
import java.util.Scanner;
/**
 * 
 */
public class CarLotMain {
	
	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			int option;
			// TODO Auto-generated method stub
			do {
				System.out.println("[0] to Exit \n" +
						"[1] Add a car to inventory \n" +
						"[2] Sell a car from inventory \n" +
						"[3] List inventory by order of acquistion \n" +
						"[4] List inventory from Best MPG to Worst MPG \n" +
						"[5] Display car with Best MPG" +
						"[6] Display car with the highest mileage" +
						"[7] Display overall MPG for the entire inventory \n" +
						"[8] Display profit for all sold cars \n");
				System.out.println("Enter a number from 0 to 8: ");
				option = input.nextInt();
				if (option == 0) {
					System.out.println("Exiting. Goodbye");
				}
					 else if (option >=1 && option <= 8) {
					System.out.println("You selected Option " + option + "\nPress any key and then enter to continue");}
		} while (option != 0);
			input.close();
			
		}
	}