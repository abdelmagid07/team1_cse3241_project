import java.time.LocalDate; // Used for the warrantyExpiration attribute

/* CAR Class (subclass of ASSET)*/
public class Car extends Asset {
    /* Attributes */
    private String licensePlate;
    private double payloadCapacity; // kg
    private double distanceAutonomy; // miles
    private double maxSpeed; // mph

    /* Constructor: Initialize the car object with the given attributes */
    public Car(String serialNumber, String status, String model, LocalDate warrantyExpiration, int year,
               int facilityId, String licensePlate, double payloadCapacity, double distanceAutonomy, double maxSpeed) {
        super(serialNumber, status, model, warrantyExpiration, year, facilityId);
        this.licensePlate = licensePlate;
        this.payloadCapacity = payloadCapacity;
        this.distanceAutonomy = distanceAutonomy;
        this.maxSpeed = maxSpeed;
    }

    /* Getter and setter methods for the car class */
    public String getLicensePlate() { return licensePlate; }
    public double getPayloadCapacity() { return payloadCapacity; }
    public double getDistanceAutonomy() { return distanceAutonomy; }
    public double getMaxSpeed() { return maxSpeed; }

    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public void setPayloadCapacity(double payloadCapacity) { this.payloadCapacity = payloadCapacity; }
    public void setDistanceAutonomy(double distanceAutonomy) { this.distanceAutonomy = distanceAutonomy; }
    public void setMaxSpeed(double maxSpeed) { this.maxSpeed = maxSpeed; }

    /* toString method to return a string representation of the car */
    @Override
    public String toString() {
        return "Car " + getSerialNumber() + "\n"
                + assetDetails() + "\n"
                + "  License plate:        " + licensePlate + "\n"
                + "  Payload capacity:     " + payloadCapacity + " kg\n"
                + "  Distance autonomy:    " + distanceAutonomy + " miles\n"
                + "  Max speed:            " + maxSpeed + " mph";
    }
}
