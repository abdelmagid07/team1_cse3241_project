import java.time.LocalDate;

/** Class to load sample data into the database*/
public final class SampleData {
    private SampleData() { }

    public static void load(Database01 database) {

        database.getCustomers().add(new Customer(database.nextUserId(), "John", "Doe", LocalDate.of(2025, 3, 14),
                "1234 Hello St, Columbus, OH 56981", "614-555-0142", "john.doe@example.com", 2.4));
        database.getCustomers().add(new Customer(database.nextUserId(), "Jane", "Doe", LocalDate.of(2025, 8, 2),
                "5678 World St, Columbus, OH 56981", "614-565-5959", "jane.doe@example.com", 6.8));

        database.getAssets().add(new Robot("ROBOT-101", "Available", "Green Bot", LocalDate.of(2026, 12, 31), 2024, 1,
                "Dusty", 1.5, "Yellow Camera, LiDAR Sensor", "Cleaning"));

        database.getAssets().add(new Car("CAR-202", "Available", "Blue Car", LocalDate.of(2027, 9, 30), 2023, 1,
                "16378JNFJ8", 190, 75, 25));
    }
}
