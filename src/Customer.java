import java.time.LocalDate; // Used for the startDate attribute

/* CUSTOMER Class (subclass of PERSON)*/
public class Customer {
    /* Attributes */
    private final int userId;
    private String firstName;
    private String lastName;
    private LocalDate startDate;
    private String address;
    private String phoneNo;
    private String email;
    private double facilityDistance; // miles
 
    /* Constructor: Initialize the customer object with the given attributes */
    public Customer(int userId, String firstName, String lastName, LocalDate startDate, String address,
                    String phoneNo, String email, double facilityDistance) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
        this.facilityDistance = facilityDistance;
    }

    /* Getter and setter methods for the customer class */
    public int getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getFullName() { return firstName + " " + lastName; }
    public LocalDate getStartDate() { return startDate; }
    public String getAddress() { return address; }
    public String getPhoneNo() { return phoneNo; }
    public String getEmail() { return email; }
    public double getFacilityDistance() { return facilityDistance; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public void setEmail(String email) { this.email = email; }
    public void setFacilityDistance(double facilityDistance) { this.facilityDistance = facilityDistance; }

    /* toString method to return a string representation of the customer */
    @Override
    public String toString() {
        return "Customer " + userId + "\n"
                + "  First name:         " + firstName + "\n"
                + "  Last name:          " + lastName + "\n"
                + "  Start date:         " + startDate + "\n"
                + "  Address:            " + address + "\n"
                + "  Phone number:       " + phoneNo + "\n"
                + "  Email:              " + email + "\n"
                + "  Facility distance:  " + facilityDistance + " miles";
    }
}
