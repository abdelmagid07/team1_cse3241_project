import java.util.ArrayList; 
import java.util.List;

/* 
Temporary "database" class for the project. 

Stores everything using ArrayLists. In future checkpoints, this will be replaced with a real SQL database.
*/
public class Database01 {

    /* Attributes */
    private final List<Customer> customers = new ArrayList<>(); // all customers
    private final List<Asset> assets = new ArrayList<>(); // all assets (robots and cars)
    private int nextUserId = 1001; // next available customer ID

    /* Getter methods */
    public List<Customer> getCustomers() { return customers; }
    public List<Asset> getAssets() { return assets; }

    /* nextUserId method to return the next available customer ID */
    public int nextUserId() { return nextUserId++; }

    /* findCustomer method to search for a customer by user ID */
    public Customer findCustomer(int userId) {
        for (Customer c : customers) {
            if (c.getUserId() == userId) {
                return c;
            }
        }
        return null;
    }

    /* findAsset method to search for an asset by serial number */
    public Asset findAsset(String serialNumber) {
        for (Asset a : assets) {
            if (a.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                return a;
            }
        }
        return null;
    }

    /* licensePlateInUse method to check if a license plate is already used by another car */
    public boolean licensePlateInUse(String licensePlate, Asset except) {
        for (Asset a : assets) {
            if (a != except && a instanceof Car && ((Car) a).getLicensePlate().equalsIgnoreCase(licensePlate)) {
                return true;
            }
        }
        return false;
    }
}
