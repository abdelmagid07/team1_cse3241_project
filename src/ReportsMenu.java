/** Class to handle reports 
 Allows:
 - view assets past warranty expiration
 - view assets by asset type
 - view manufacturer lookup by serial number
 - view robots with no maintenance in last year

 As per the checkpoint specifications, this is not implemented yet.
 */
public class ReportsMenu {
    private final InputHelper input;
    public ReportsMenu(InputHelper input) {
        this.input = input;
    }

    /* Menu runner, shows menu until user types "5" */
    public void run() {
        while (true) {
            System.out.println();
            System.out.println("Reports & Queries:");
            System.out.println("1. Assets Past Warranty Expiration");
            System.out.println("2. Assets by Asset Type");
            System.out.println("3. Manufacturer Lookup by Serial Number");
            System.out.println("4. Robots with No Maintenance in Last Year");
            System.out.println("5. Back");
            try {
                int choice = input.readInt("Choose an option: ");
                switch (choice) {
                    case 1:
                    case 2:
                    case 3:
                    case 4: System.out.println("Not implemented yet."); break;
                    case 5: return;
                    default: System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }
}
