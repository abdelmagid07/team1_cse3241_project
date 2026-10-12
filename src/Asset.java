import java.time.LocalDate; // Used for the warrantyExpiration attribute
import java.util.Arrays; // Used for the STATUSES list
import java.util.List;

/* ASSET Class (superclass of ROBOT and CAR)

ROBOT and CAR will inherit from this class, and implement the abstract methods. This class 
contains the shared attributes and methods for all assets. This class is abstract, and 
cannot be instantiated directly.

Constructor and getter/setter methods are protected and can only be accessed by subclasses.
*/
public abstract class Asset {

    /* Attributes */
    public static final List<String> STATUSES = Arrays.asList("Available", "Rented", "In Transit", "In Maintenance", "Inactive");
    private final String serialNumber;
    private String status;
    private String model;
    private LocalDate warrantyExpiration;
    private int year;
    private int facilityId;

    /* Constructor: Initialize the asset class with the given attributes */
    protected Asset(String serialNumber, String status, String model, LocalDate warrantyExpiration,
                    int year, int facilityId) {
        this.serialNumber = serialNumber;
        this.status = status;
        this.model = model;
        this.warrantyExpiration = warrantyExpiration;
        this.year = year;
        this.facilityId = facilityId;
    }

    /* Getter and setter methods for the asset class */
    public String getSerialNumber() { return serialNumber; }
    public String getStatus() { return status; }
    public String getModel() { return model; }
    public LocalDate getWarrantyExpiration() { return warrantyExpiration; }
    public int getYear() { return year; }
    public int getFacilityId() { return facilityId; }

    public void setStatus(String status) { this.status = status; }
    public void setModel(String model) { this.model = model; }
    public void setWarrantyExpiration(LocalDate warrantyExpiration) { this.warrantyExpiration = warrantyExpiration; }
    public void setYear(int year) { this.year = year; }
    public void setFacilityId(int facilityId) { this.facilityId = facilityId; }

    /* assetDetails method to return a string representation of the shared asset attributes */
    protected String assetDetails() {
        return "  Status:               " + status + "\n"
                + "  Model:                " + model + "\n"
                + "  Warranty expiration:  " + warrantyExpiration + "\n"
                + "  Year:                 " + year + "\n"
                + "  Facility ID:          " + facilityId;
    }
}
