import java.util.Scanner;

/** Main class to run the application */
public class Main {
    /* Shows main menu until user types "0" */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHelper input = new InputHelper(scanner);
        Database01 database = new Database01();
        SampleData.load(database);

        CustomerMenu customers = new CustomerMenu(database, input);
        AssetMenu assets = new AssetMenu(database, input);
        RentalMenu rentals = new RentalMenu(input);
        ReportsMenu reports = new ReportsMenu(input);

        while (true) {
            System.out.println();
            System.out.println("Menu: ");
            System.out.println("1. Customer Management");
            System.out.println("2. Asset Management");
            System.out.println("3. Rental Management");
            System.out.println("4. Reports & Queries");
            System.out.println("0. Exit");
            try {
                int choice = input.readInt("Choose an option: ");
                switch (choice) {
                    case 1: customers.run(); break;
                    case 2: assets.run(); break;
                    case 3: rentals.run(); break;
                    case 4: reports.run(); break;
                    case 0:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default: System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }
}
