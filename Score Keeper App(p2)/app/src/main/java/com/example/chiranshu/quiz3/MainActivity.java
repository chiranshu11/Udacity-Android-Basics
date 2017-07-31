package com.example.chiranshu.quiz3; /**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.chiranshu.quiz3.R;

import static com.example.chiranshu.quiz3.R.id.ScoreA;
import static com.example.chiranshu.quiz3.R.id.ScoreB;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int value_a=0;
    int value_b=0;

    /**
     * This method is called when the order button is clicked.
     */
    public void decrement1A(View view) {
        value_a=value_a-1;
        displayA(value_a);
    }
    public void increment1A(View view) {
        value_a=value_a+1;
        displayA(value_a);
    }

    public void increment2A(View View){
        value_a=value_a+2;
        displayA(value_a);
    }
    public void decrement1B(View view){
        value_b=value_b-1;
        displayB(value_b);
    }
    public void increment1B(View view) {
        value_b=value_b+1;
        displayB(value_b);
    }

    public void increment2B(View View){
        value_b=value_b+2;
        displayB(value_b);
    }
    public void Reset1(View view) {
        value_a=0;
        value_b=0;
        displayA(value_a);
        displayB(value_b);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayA(int number) {
        TextView quantityTextView = (TextView) findViewById(ScoreA);
        quantityTextView.setText(String.valueOf(number));
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayB(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.ScoreB);
        priceTextView.setText(String.valueOf(number));
    }

}
;