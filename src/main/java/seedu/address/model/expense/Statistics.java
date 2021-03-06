package seedu.address.model.expense;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 * Represents a Expense's statistic in the expense book.
 */
public class Statistics {

    private HashMap<String, Double> categoryAmountPercentage;

    //private HashMap<String, Double> categoryNumberPercentage;

    private ArrayList<String> categories;

    /**
     * Constructs a Statistics object.
     *
     * @param categoryAmountPercentage A hashmap of categories and corresponding percentages.
     * @param categories An arraylist of all existing categories.
     */
    public Statistics(HashMap<String, Double>categoryAmountPercentage, ArrayList<String> categories) {
        this.categoryAmountPercentage = categoryAmountPercentage;
        //this.categoryNumberPercentage = categoryNumberPercentage;
        this.categories = categories;
    }

    /**
     * Gets the hashmap pf categories and percentages.
     *
     * @return The hashmap of categories and percentage.
     */
    public HashMap<String, Double> getCategoryAmountPercentage() {
        return this.categoryAmountPercentage;
    }

    /**
     * Gets the data for PieChart.
     *
     * @return Data for PieChart.
     */
    public ObservableList<PieChart.Data> getCategoryAmountPercenatgePieCharStatistics() {

        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();

        for (String current: categories) {

            double percentage = categoryAmountPercentage.get(current);

            list.add(new PieChart.Data(current, percentage));

        }

        return list;
    }


}
