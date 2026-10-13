import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/** Class to handle asset management (robots, cars)
 Allows:
 - add new assets
 - edit existing assets
 - delete assets
 - search for assets by serial number
 */
public class AssetMenu {
    private final Database01 database;
    private final InputHelper input;

    public AssetMenu(Database01 database, InputHelper input) {
        this.database = database;
        this.input = input;
    }

    /* Menu runner, shows menu until user types "5" */
    public void run() {
        while (true) {
            System.out.println();
            System.out.println("Asset Management:");
            System.out.println("1. Add New Asset (Robot/Car)");
            System.out.println("2. Edit Asset");
            System.out.println("3. Delete Asset");
            System.out.println("4. Search Asset by Serial Number");
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

    /* add method to create a new robot or car and store it in the database */
    private void add() {
        String type = input.readLine("Asset type (Robot or Car): ");
        if (!type.equalsIgnoreCase("Robot") && !type.equalsIgnoreCase("Car")) {
            System.out.println("Invalid option.");
            return;
        }
        String serialNumber = input.readLine("Serial number: ").toUpperCase();
        if (database.findAsset(serialNumber) != null) {
            System.out.println("Serial number " + serialNumber + " already exists. Asset not added.");
            return;
        }
        String status = input.readLine("Status (" + String.join(", ", Asset.STATUSES) + "): ");
        if (!Asset.STATUSES.contains(status)) {
            System.out.println("Invalid status. Asset not added.");
            return;
        }
        String model = input.readLine("Model: ");
        LocalDate warrantyExpiration = input.readDate("Warranty expiration (YYYY-MM-DD): ");
        int year = input.readInt("Year: ");
        int facilityId = input.readInt("Facility ID: ");

        if (type.equalsIgnoreCase("Robot")) {
            database.getAssets().add(new Robot(serialNumber, status, model, warrantyExpiration, year, facilityId,
                    input.readLine("Name: "),
                    input.readDouble("Battery autonomy (hours): "),
                    input.readLine("Sensor suite: "),
                    input.readLine("Primary function: ")));
            System.out.println("Robot added. Serial number:" + serialNumber);
        } else {
            database.getAssets().add(new Car(serialNumber, status, model, warrantyExpiration, year, facilityId,
                    input.readLine("License plate: ").toUpperCase(),
                    input.readDouble("Payload capacity (kg): "),
                    input.readDouble("Distance autonomy (miles): "),
                    input.readDouble("Max speed (mph): ")));
            System.out.println("Car added. Serial number:" + serialNumber);
        }
    }

    /* edit method to change the attributes of an existing robot or car */
    private void edit() {
        Asset a = findAsset();
        if (a == null) {
            return;
        }
        System.out.println("Press Enter to keep the current value.");
        String status = input.editText("Status (" + String.join(", ", Asset.STATUSES) + ")", a.getStatus());
        if (Asset.STATUSES.contains(status)) {
            a.setStatus(status);
        } else {
            System.out.println("Invalid status. Keeping " + a.getStatus() + ".");
        }
        a.setModel(input.editText("Model", a.getModel()));
        a.setWarrantyExpiration(input.editDate("Warranty expiration", a.getWarrantyExpiration()));
        a.setYear(input.editInt("Year", a.getYear()));
        a.setFacilityId(input.editInt("Facility ID", a.getFacilityId()));

        if (a instanceof Robot) {
            Robot r = (Robot) a;
            r.setName(input.editText("Name", r.getName()));
            r.setBatteryAutonomy(input.editDouble("Battery autonomy (hours)", r.getBatteryAutonomy()));
            r.setSensorSuite(input.editText("Sensor suite", r.getSensorSuite()));
            r.setPrimaryFunction(input.editText("Primary function", r.getPrimaryFunction()));
        } else {
            Car c = (Car) a;
            c.setLicensePlate(input.editText("License plate", c.getLicensePlate()).toUpperCase());
            c.setPayloadCapacity(input.editDouble("Payload capacity (kg)", c.getPayloadCapacity()));
            c.setDistanceAutonomy(input.editDouble("Distance autonomy (miles)", c.getDistanceAutonomy()));
            c.setMaxSpeed(input.editDouble("Max speed (mph)", c.getMaxSpeed()));
        }
        System.out.println("Asset updated.");
        System.out.println(a);
    }

    /* remove an asset from the database */
    private void delete() {
        Asset a = findAsset();
        if (a == null) {
            return;
        }
        database.getAssets().remove(a);
        System.out.println("Asset " + a.getSerialNumber() + " deleted.");
    }

    /* search method to find an asset by serial number and print it */
    private void search() {
        Asset a = findAsset();
        if (a != null) {
            System.out.println(a);
        }
    }

    /* helper method to ask for a serial number and look it up in the database */
    private Asset findAsset() {
        String serialNumber = input.readLine("Serial number: ");
        Asset a = database.findAsset(serialNumber);
        if (a == null) {
            System.out.println("No asset found with serial number " + serialNumber.toUpperCase() + ".");
        }
        return a;
    }
}
