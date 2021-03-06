package seedu.address.model.expense;

import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a Expense's date in the expense book.
 * Guarantees: the date is non-negative; is valid as declared in {@link #isValidDate(String)}
 */
public class Date {

    //public static final String MESSAGE_CONSTRAINTS =
    // "Date should only contain numbers, and it should be at least 1 digits long";
    // public static final String VALIDATION_REGEX = "\\d{1,}";
    public static final String MESSAGE_CONSTRAINTS =
            "Date can be entered in one of these two ways: \n"
                   + "i) As number of days before today. Then it should only contain numbers, "
        + "and it should be at least 1 digits long.\n"
            + "ii) As the actual date, that is YYYY-MM-DD.";
    public static final String VALIDATION_REGEX = "[^\\s].*";
    public final String date;
    public final String howManyDaysAgo;
    private LocalDate localDate;

    /**
     * Constructor for Date.
     * @param inputDay Allow user to type in how many days ago he spent the money.
     */
    public Date(String inputDay) {
        checkArgument(isValidDate(inputDay), MESSAGE_CONSTRAINTS);
        if (!inputDay.contains("-")) {
            this.howManyDaysAgo = inputDay;
            assert Integer.parseInt(inputDay) >= 0 : "Invalid days Being Enter";
            LocalDate localdate = LocalDate.now();
            int convertedDay = Integer.parseInt(inputDay);
            LocalDate dayBefore = localdate.minusDays(convertedDay);
            localDate = dayBefore;
            this.date = dayBefore.toString();
        } else {
            this.howManyDaysAgo = "undefined";
            // LocalDate date = LocalDate.parse(inputDay);
            // this.date = date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            this.date = inputDay;
            localDate = LocalDate.parse(date);
        }
    }
    /**
     * Constructor for Date. When the date is not entered, localdate will be used for the date of expense。
     */
    public Date () {
        LocalDate localdate = LocalDate.now();
        this.howManyDaysAgo = "0";
        this.date = localdate.toString();
    }

    /**
     * Returns true if a given string is a valid Day.
     */
    public static boolean isValidDate(String test) {
        //return test.matches(VALIDATION_REGEX);
        if (test.contains("-")) {
            try {
                LocalDate date = LocalDate.parse(test);
                String dateString = date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }
        } else {
            try {
                int dayBefore = Integer.parseInt(test);
                return dayBefore >= 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    /**
     * Gets the localDate of the Date.
     *
     * @return The localDate of the date.
     */
    public LocalDate getLocalDate() {
        return this.localDate;
    }

    @Override
    public String toString() {
        return this.date;
    }

    @Override
    public int hashCode() {
        return this.date.hashCode();
    }

    public String getDate() {
        return this.date;
    }
    public String getHowManyDaysAgo() {
        return this.howManyDaysAgo;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Date // instanceof handles nulls
                && date.equals(((Date) other).date)); // state check
    }

}
