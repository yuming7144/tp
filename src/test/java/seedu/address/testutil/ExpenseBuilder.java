package seedu.address.testutil;

import seedu.address.model.expense.Amount;
import seedu.address.model.expense.Category;
import seedu.address.model.expense.Date;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.Expense;

/**
 * A utility class to help with building Person objects.
 */
public class ExpenseBuilder {

    public static final Double DEFAULT_AMOUNT = 10.0;
    public static final String DEFAULT_DATE = "0";
    public static final String DEFAULT_CATEGORY = "FOOD";
    public static final String DEFAULT_DESCRIPTION = "Bought sushi for dinner";
    private Amount amount;
    private Date date;
    private Category category;
    private Description description;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public ExpenseBuilder() {
        amount = new Amount(DEFAULT_AMOUNT);
        date = new Date(DEFAULT_DATE);
        category = new Category(DEFAULT_CATEGORY);
        description = new Description(DEFAULT_DESCRIPTION);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public ExpenseBuilder(Expense expenseToCopy) {
        amount = expenseToCopy.getAmount();
        date = expenseToCopy.getDate();
        category = expenseToCopy.getCategory();
        description = expenseToCopy.getDescription();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public ExpenseBuilder withAmount(Double amount) {
        this.amount = new Amount(amount);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public ExpenseBuilder withDate(String date) {
        this.date = new Date(date);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public ExpenseBuilder withCategory(String category) {
        this.category = new Category(category);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public ExpenseBuilder withDescription(String description) {
        this.description = new Description(description);
        return this;
    }

    public Expense build() {
        return new Expense(amount, date, category, description);
    }

}

