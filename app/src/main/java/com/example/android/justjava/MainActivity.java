package com.example.android.justjava;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whippedCream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        Boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Boolean hasChocolate = chocolateCheckBox.isChecked();
        int price = calculatePrice();
        displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate));
    }

    /**
     * Calculates the price of the order.
     */
    public int calculatePrice() {
        return quantity * 5;
    }

    /**
     * creates order summary
     *
     * @param price of cup og coffee
     * @param hasWhippedCream is whipped cream check box had been checked.
     * @param hasChocolate whether user wants to add chocolate
     * @return string containing order information
     */

    public String createOrderSummary(int price, Boolean hasWhippedCream, Boolean hasChocolate) {
        return "Name: Adam Kirsch\nAdd whipped cream? " + hasWhippedCream +
                "\nAdd chocolate? " + hasChocolate + "\nQuantity: "+ quantity + "\nTotal: $"
                + price + "\nThank you!";
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }

}
