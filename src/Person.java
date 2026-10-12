import java.time.LocalDate; 

/* PERSON Class (superclass of CUSTOMER and EMPLOYEE)*/
public abstract class Person {

    /* Attributes */
    private final int userId;
    private String firstName;
    private String lastName;
    private LocalDate startDate;
    private String address;
    private String phoneNo;
    private String email;

    /* Constructor: Initialize the person class with the given attributes */
    protected Person(int userId, String firstName, String lastName, LocalDate startDate, String address,
                     String phoneNo, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    /* Getter and setter methods for the person class */
    public int getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getFullName() { return firstName + " " + lastName; }
    public LocalDate getStartDate() { return startDate; }
    public String getAddress() { return address; }
    public String getPhoneNo() { return phoneNo; }
    public String getEmail() { return email; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public void setEmail(String email) { this.email = email; }

    /* personDetails method to return a string representation of the shared person attributes */
    protected String personDetails() {
        return "  First name:         " + firstName + "\n"
                + "  Last name:          " + lastName + "\n"
                + "  Start date:         " + startDate + "\n"
                + "  Address:            " + address + "\n"
                + "  Phone number:       " + phoneNo + "\n"
                + "  Email:              " + email;
    }
}
