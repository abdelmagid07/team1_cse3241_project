import java.time.LocalDate; // Used for the startDate attribute

/* CUSTOMER Class (subclass of PERSON)*/
public class Customer extends Person {
    /* Attributes */
    private double facilityDistance; // miles

    /* Constructor: Initialize the customer object with the given attributes */
    public Customer(int userId, String firstName, String lastName, LocalDate startDate, String address,
                    String phoneNo, String email, double facilityDistance) {
        super(userId, firstName, lastName, startDate, address, phoneNo, email);
        this.facilityDistance = facilityDistance;
    }

    /* Getter and setter methods for the customer class */
    public double getFacilityDistance() { return facilityDistance; }
    public void setFacilityDistance(double facilityDistance) { this.facilityDistance = facilityDistance; }

    /* toString method to return a string representation of the customer */
    @Override
    public String toString() {
        return "Customer " + getUserId() + "\n"
                + personDetails() + "\n"
                + "  Facility distance:  " + facilityDistance + " miles";
    }
}
