package seedu.address.model.expense;

/**
 * Represents a Expense's budget in the expense book.
 * Guarantees: the budget is non-negative; is valid as declared in {@link #isValidBudget(Amount)}
 */
public class Budget {
    private final Amount budget;

    public Budget() {
        this.budget = new Amount((double) 0);
    }

    public Budget(double budget) {
        this.budget = new Amount(budget);
    }

    /**
     * @param spending of an amount.
     * @return the remaining budget.
     */
    public Budget remaining(double spending) {
        double remaining = this.getValue() - spending;
        return new Budget(remaining);
    }

    /**
     * Exchange the current Budget with a exchangeRate
     * @param exchangeRate of toCurrency.
     * @return new Amount at the given exchangeRate.
     */
    public Budget exchange(ExchangeRate exchangeRate) {
        double value = this.budget.getValue() * exchangeRate.getRate();
        return new Budget(value);
    }

    public boolean isEmpty() {
        return budget.getValue() <= 0;
    }

    @Override
    public String toString() {
        return budget.toString();
    }

    public double getValue() {
        return budget.getValue();
    }

    /**
     * Returns true if a given amount is a valid amount.
     */
    public static boolean isValidBudget(Amount budget) {
        return budget.value >= 0;
    }

}
