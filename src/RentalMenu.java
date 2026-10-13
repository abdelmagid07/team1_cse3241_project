import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/** Class to handle rental management
 Allows:
 - create new rentals
 - process returns
 - deliveries and pickups

 As per the checkpoint specifications, nothing is stored in the database.
 */
public class RentalMenu {
    private final InputHelper input;
    public RentalMenu(InputHelper input) {
        this.input = input;
    }

    /* Menu runner, shows menu until user types "5" */
    public void run() {
        while (true) {
            System.out.println();
            System.out.println("Rental Management:");
            System.out.println("1. Create New Rental");
            System.out.println("2. Process Return");
            System.out.println("3. Schedule Robot Delivery");
            System.out.println("4. Schedule Robot Pickup");
            System.out.println("5. Back");
            try {
                int choice = input.readInt("Choose an option: ");
                switch (choice) {
                    case 1: createNewRental(); break;
                    case 2: processReturn(); break;
                    case 3: scheduleMovement("Delivery"); break;
                    case 4: scheduleMovement("Pickup"); break;
                    case 5: return;
                    default: System.out.println("Invalid option.");
                }
            } catch (NumberFormatException | DateTimeParseException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    /* method to collect rental info and print confirmation */
    private void createNewRental() {
        int customerId = input.readInt("Customer ID: ");
        String serialNumbers = input.readLine("Robot serial number(s), separate by commas: ").toUpperCase();
        LocalDate checkOut = input.readDate("Check-out date (YYYY-MM-DD): ");
        LocalDate dueDate = input.readDate("Due date (YYYY-MM-DD): ");
        double rentalFee = input.readDouble("Rental fee ($): ");
        int supervisorId = input.readInt("Supervisor ID: ");

        System.out.println("Rental created: customer " + customerId + ", robot(s) " + serialNumbers
                + ", check-out " + checkOut + ", due " + dueDate + ", fee " + rentalFee
                + ", supervisor " + supervisorId + ".");
    }

    /* method to collect return date and print confirmation */
    private void processReturn() {
        int customerId = input.readInt("Customer ID: ");
        int rentalId = input.readInt("Rental ID: ");
        LocalDate returnDate = input.readDate("Return date (YYYY-MM-DD): ");

        System.out.println("Return processed: rental " + rentalId + " for customer " + customerId
                + ", returned " + returnDate + ".");
    }

    /* method to collect a delivery or pickup and print confirmation */
    private void scheduleMovement(String kind) {
        int customerId = input.readInt("Customer ID: ");
        String robots = input.readLine("Robot serial number(s), separate by commas: ").toUpperCase();
        String car = input.readLine("Car serial number: ").toUpperCase();
        LocalDateTime scheduledTime = input.readDateTime("Scheduled time (YYYY-MM-DD HH:MM): ");

        System.out.println(kind + " scheduled: car " + car + " assigned to robot(s) " + robots
                + " for customer " + customerId + " at " + scheduledTime.toLocalDate() + " "
                + scheduledTime.toLocalTime() + ".");
    }
}
