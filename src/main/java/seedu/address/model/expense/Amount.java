package seedu.address.model.expense;

import static seedu.address.commons.util.AppUtil.checkArgument;

public class Amount {
    public static final String MESSAGE_CONSTRAINTS =
            "Amount should only positive numbers";


    public final Double value;

    public Amount(Double value) {
        checkArgument(isValidAmount(value), MESSAGE_CONSTRAINTS);
        this.value = value;
    }

    /**
     * Returns true if a given amount is a valid amount.
     */
    public static boolean isValidAmount(Double value) {
        return value >= 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f", this.value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Amount // instanceof handles nulls
                && value.equals(((Amount) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public double getValue() {
        return this.value;
    }

}
