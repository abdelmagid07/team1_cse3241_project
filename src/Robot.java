import java.time.LocalDate; // Used for the warrantyExpiration attribute

/* ROBOT Class (subclass of ASSET)*/
public class Robot extends Asset {
    /* Attributes */
    private String name;
    private double batteryAutonomy; // hours
    private String sensorSuite;
    private String primaryFunction;

    /* Constructor: Initialize the robot object with the given attributes */
    public Robot(String serialNumber, String status, String model, LocalDate warrantyExpiration, int year,
                 int facilityId, String name, double batteryAutonomy, String sensorSuite, String primaryFunction) {
        super(serialNumber, status, model, warrantyExpiration, year, facilityId);
        this.name = name;
        this.batteryAutonomy = batteryAutonomy;
        this.sensorSuite = sensorSuite;
        this.primaryFunction = primaryFunction;
    }

    /* Getter and setter methods for the robot class */
    public String getName() { return name; }
    public double getBatteryAutonomy() { return batteryAutonomy; }
    public String getSensorSuite() { return sensorSuite; }
    public String getPrimaryFunction() { return primaryFunction; }

    public void setName(String name) { this.name = name; }
    public void setBatteryAutonomy(double batteryAutonomy) { this.batteryAutonomy = batteryAutonomy; }
    public void setSensorSuite(String sensorSuite) { this.sensorSuite = sensorSuite; }
    public void setPrimaryFunction(String primaryFunction) { this.primaryFunction = primaryFunction; }

    /* toString method to return a string representation of the robot */
    @Override
    public String toString() {
        return "Robot " + getSerialNumber() + "\n"
                + assetDetails() + "\n"
                + "  Name:                 " + name + "\n"
                + "  Battery autonomy:     " + batteryAutonomy + " hours\n"
                + "  Sensor suite:         " + sensorSuite + "\n"
                + "  Primary function:     " + primaryFunction;
    }
}
