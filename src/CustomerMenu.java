import java.time.format.DateTimeParseException;

/** Class to handle customer management
 Allows:
 - add new customers
 - edit existing customers
 - delete customers
 - search for customers by ID
 */
public class CustomerMenu {
    private final Database01 database;
    private final InputHelper input;

    public CustomerMenu(Database01 database, InputHelper input) {
        this.database = database;
        this.input = input;
    }

    /* Menu runner, shows menu until user types "5" */
    public void run() {
        while (true) {
            System.out.println();
            System.out.println("Customer Management:");
            System.out.println("1. Add Customer");
            System.out.println("2. Edit Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Search Customer by ID");
            System.out.println("5. Back");
            try {
                int choice = input.readInt("Choose an option: ");
                switch (choice) {
                    case 1: add(); break;
                    case 2: edit(); break;
                    case 3: delete(); break;
                    case 4: search(); break;
                    case 5: return;
                    default: System.out.println("Invalid option.");
                }
            } catch (NumberFormatException | DateTimeParseException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    /* add method to create a new customer and store it in the database */
    private void add() {
        Customer c = new Customer(database.nextUserId(),
                input.readLine("First name: "),
                input.readLine("Last name: "),
                input.readDate("Start date (YYYY-MM-DD): "),
                input.readLine("Address: "),
                input.readLine("Phone number: "),
                input.readLine("Email: "),
                input.readDouble("Facility distance (miles): "));

        database.getCustomers().add(c);
        System.out.println("Customer added. ID:" + c.getUserId());
    }

    /* edit method to change the attributes of an existing customer */
    private void edit() {
        Customer c = findCustomer();
        if (c == null) {
            return;
        }
        System.out.println("Press Enter to keep the current value.");
        c.setFirstName(input.editText("First name", c.getFirstName()));
        c.setLastName(input.editText("Last name", c.getLastName()));
        c.setStartDate(input.editDate("Start date", c.getStartDate()));
        c.setAddress(input.editText("Address", c.getAddress()));
        c.setPhoneNo(input.editText("Phone number", c.getPhoneNo()));
        c.setEmail(input.editText("Email", c.getEmail()));
        c.setFacilityDistance(input.editDouble("Facility distance (miles)", c.getFacilityDistance()));
        System.out.println("Customer updated.");
        System.out.println(c);
    }

    /* remove a customer from the database */
    private void delete() {
        Customer c = findCustomer();
        if (c == null) {
            return;
        }
        database.getCustomers().remove(c);
        System.out.println("Customer " + c.getUserId() + " deleted.");
    }

    /* search method to find a customer by user ID and print it */
    private void search() {
        Customer c = findCustomer();
        if (c != null) {
            System.out.println(c);
        }
    }

    /* helper method to ask for a user ID and look it up in the database */
    private Customer findCustomer() {
        int id = input.readInt("User ID: ");
        Customer c = database.findCustomer(id);
        if (c == null) {
            System.out.println("No customer found with user ID " + id + ".");
        }
        return c;
    }
}
