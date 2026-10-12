import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/** Helper class for reading console input and easily changing values.*/
public class InputHelper {
    private static final DateTimeFormatter DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final Scanner in;

    public InputHelper(Scanner in) {
        this.in = in;
    }

    /* Basic wrappers for reading input with formatting applied. */
    public String readLine(String prompt) {
        System.out.print(prompt);
        return in.nextLine().trim();
    }
    public int readInt(String prompt) {
        return Integer.parseInt(readLine(prompt));
    }
    public double readDouble(String prompt) {
        return Double.parseDouble(readLine(prompt));
    }
    public LocalDate readDate(String prompt) {
        return LocalDate.parse(readLine(prompt));
    }
    public LocalDateTime readDateTime(String prompt) {
        return LocalDateTime.parse(readLine(prompt), DATE_TIME);
    }

    /* Helper methods to prompt user to edit existing values. Pressing Enter keeps the current value. */
    public String editText(String label, String current) {
        String s = readLine(label + " [" + current + "]: ");
        if (s.isEmpty()) {
            return current;
        } else {
            return s;
        }
    }

    public int editInt(String label, int current) {
        String s = readLine(label + " [" + current + "]: ");
        if (s.isEmpty()) {
            return current;
        } else {
            return Integer.parseInt(s);
        }
    }

    public double editDouble(String label, double current) {
        String s = readLine(label + " [" + current + "]: ");
        if (s.isEmpty()) {
            return current;
        } else {
            return Double.parseDouble(s);
        }
    }

    public LocalDate editDate(String label, LocalDate current) {
        String s = readLine(label + " [" + current + "]: ");
        if (s.isEmpty()) {
            return current;
        } else {
            return LocalDate.parse(s);
        }
    }
}