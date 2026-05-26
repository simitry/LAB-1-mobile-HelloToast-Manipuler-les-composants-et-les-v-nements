package com.example.hellotoast;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String SAVED_COUNTER = "counter_value";

    private int counter;
    private TextView counterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(SAVED_COUNTER, 0);
        }

        connectViews();
        installClickActions();
        showCounter();
    }

    private void connectViews() {
        counterText = findViewById(R.id.counter_value);
    }

    private void installClickActions() {
        Button toastButton = findViewById(R.id.toast_action);
        Button countButton = findViewById(R.id.count_action);

        toastButton.setOnClickListener(view -> sayHello());
        countButton.setOnClickListener(view -> addClick());
    }

    private void sayHello() {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show();
    }

    private void addClick() {
        counter += 1;
        showCounter();
    }

    private void showCounter() {
        counterText.setText(String.valueOf(counter));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SAVED_COUNTER, counter);
        super.onSaveInstanceState(outState);
    }
}
