package seedu.address.model.person.exceptions;

/**
 * Signals that the operation is unable to find the specified expense.
 */
public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException() {
        super("The expense can not be found!");
    }
}
