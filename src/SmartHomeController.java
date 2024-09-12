import java.time.LocalDateTime;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class SmartHomeController {
  // Logger for logging system events
  private static final Logger logger = Logger.getLogger(SmartHomeController.class.getName());

  // Instances of appliances
  Light light = new Light();
  Fan fan = new Fan();
  AirConditioner airConditioner = new AirConditioner();

  // Method to check if it's the system update time (January 1st, 1:00 AM - 1:10 AM)
  public static boolean isUpdateTime() {
    LocalDateTime now = LocalDateTime.now();
    return now.getMonth() == Month.JANUARY && now.getDayOfMonth() == 1 && now.getHour() == 1
        && now.getMinute() < 10;
  }

  // Method to turn off all appliances during system update
  public void turnOffAllAppliances() {
    light.turnOff();
    fan.turnOff();
    airConditioner.turnOff();
    logger.info("All appliances turned off for system update.");
  }

  // Main control loop that provides the user with options to control the appliances
  public void controlSystem() {
    Scanner scanner = new Scanner(System.in); // Single Scanner instance for the whole program
    boolean quit = false; // Flag to exit the program

    while (!quit) {
      // Check if it's system update time
      if (isUpdateTime()) {
        System.out.println(
            "System Update: Turning off all appliances. Please try again after 1:10 am local time.");
        turnOffAllAppliances();
        break; // Exit the loop if it's update time
      }

      // Main menu options for the user
      System.out.println("\nSmart Home Control System");
      System.out.println("1. Control Light");
      System.out.println("2. Control Fan");
      System.out.println("3. Control Air Conditioner");
      System.out.println("4. Quit");
      System.out.print("Choose an option: "); // Prompt user for input

      int choice = getValidIntegerInput(scanner); // Get user input

      // Handle user's menu selection
      switch (choice) {
        case 1:
          controlLight(scanner); // Control light menu
          break;
        case 2:
          controlFan(scanner); // Control fan menu
          break;
        case 3:
          controlAirConditioner(scanner); // Control air conditioner menu
          break;
        case 4:
          quit = true; // Set flag to exit the program
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          logger.warning("Invalid menu option selected: " + choice); // Log invalid choice
      }
    }
    scanner.close(); // Close the Scanner when the program ends
  }

  // Menu to control the Light appliance
  private void controlLight(Scanner scanner) {
    boolean goBack = false; // Flag to return to the main menu
    while (!goBack) {
      System.out.println("\n--- Light Control Menu ---");
      System.out.println("Current state: " + (light.isOn() ? "ON" : "OFF"));
      System.out.println("1. Toggle Power");
      System.out.println("2. Go Back to Main Menu");
      System.out.print("Choose an option: ");

      int choice = getValidIntegerInput(scanner); // Get user input

      // Handle user's choice
      switch (choice) {
        case 1:
          if (light.isOn()) {
            light.turnOff(); // Turn off the light
          } else {
            light.turnOn(); // Turn on the light
          }
          break;
        case 2:
          goBack = true; // Return to main menu
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          logger.warning("Invalid option in Light Control Menu: " + choice); // Log invalid choice
      }
    }
  }

  // Menu to control the Fan appliance
  private void controlFan(Scanner scanner) {
    boolean goBack = false; // Flag to return to the main menu
    while (!goBack) {
      System.out.println("\n--- Fan Control Menu ---");
      System.out.println("Current speed: " + fan.getSpeed());
      // Inform the user about the cyclic behavior of the fan speed
      System.out.println(
          "Note: Fan speed works in a cyclic manner. Increasing from speed 2 will reset the fan to 0, and decreasing from speed 0 will reset it to 2.");
      System.out.println("1. Increase Fan Speed");
      System.out.println("2. Decrease Fan Speed");
      System.out.println("3. Go Back to Main Menu");
      System.out.print("Choose an option: ");

      int choice = getValidIntegerInput(scanner); // Get user input

      // Handle user's choice
      switch (choice) {
        case 1:
          fan.increaseSpeed(); // Increase fan speed
          System.out.println("Fan speed increased to: " + fan.getSpeed());
          break;
        case 2:
          fan.decreaseSpeed(); // Decrease fan speed
          System.out.println("Fan speed decreased to: " + fan.getSpeed());
          break;
        case 3:
          goBack = true; // Return to main menu
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          logger.warning("Invalid option in Fan Control Menu: " + choice); // Log invalid choice
      }
    }
  }

  // Menu to control the Air Conditioner appliance
  private void controlAirConditioner(Scanner scanner) {
    boolean goBack = false; // Flag to return to the main menu
    while (!goBack) {
      System.out.println("\n--- Air Conditioner Control Menu ---");
      System.out.println("Current state: " + (airConditioner.isOn() ? "ON" : "OFF"));
      if (airConditioner.isOn()) {
        System.out.println("Current temperature: " + airConditioner.getTemperature());
      }
      System.out.println("1. Toggle Power");
      if (airConditioner.isOn()) {
        System.out.println("2. Increase Temperature");
        System.out.println("3. Decrease Temperature");
      }
      System.out.println((airConditioner.isOn() ? "4" : "2") + ". Go Back to Main Menu");
      System.out.print("Choose an option: ");

      int choice = getValidIntegerInput(scanner); // Get user input

      // Handle user's choice
      switch (choice) {
        case 1:
          if (airConditioner.isOn()) {
            airConditioner.turnOff(); // Turn off the air conditioner
          } else {
            airConditioner.turnOn(); // Turn on the air conditioner
          }
          break;
        case 2:
          if (airConditioner.isOn()) {
            airConditioner.increaseTemp(); // Increase temperature
            System.out.println("Temperature increased to: " + airConditioner.getTemperature());
          } else {
            goBack = true; // Go back if air conditioner is off
          }
          break;
        case 3:
          if (airConditioner.isOn()) {
            airConditioner.decreaseTemp(); // Decrease temperature
            System.out.println("Temperature decreased to: " + airConditioner.getTemperature());
          }
          break;
        case 4:
          if (airConditioner.isOn()) {
            goBack = true; // Return to main menu
          }
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          logger.warning("Invalid option in Air Conditioner Control Menu: " + choice); // Log
      }
    }
  }

  // method to get valid integer input with exception handling
  private int getValidIntegerInput(Scanner scanner) {
    int input = -1;
    boolean valid = false; // Flag to indicate valid input
    while (!valid) {
      try {
        input = scanner.nextInt(); // Attempt to read an integer
        valid = true; // Input is valid
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter an integer.");
        scanner.next(); // Clear the invalid input
        logger.warning("Invalid input entered."); // Log invalid input
      }
    }
    return input;
  }

  // Main method to start the application
  public static void main(String[] args) {
    SmartHomeController controller = new SmartHomeController();
    controller.controlSystem(); // Start the control system
  }
}
