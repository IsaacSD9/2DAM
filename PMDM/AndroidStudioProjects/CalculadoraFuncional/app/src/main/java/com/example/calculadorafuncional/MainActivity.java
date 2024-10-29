package com.example.calculadorafuncional;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView visor;
    private double firstValue, secondValue;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visor = findViewById(R.id.visor);
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        visor.append(button.getText().toString());
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        firstValue = Double.parseDouble(visor.getText().toString());
        operator = button.getText().toString();
        visor.setText("");
    }

    public void onEqualClick(View view) {
        secondValue = Double.parseDouble(visor.getText().toString());
        double result = 0;

        switch (operator) {
            case "+":
                result = firstValue + secondValue;
                break;
            case "-":
                result = firstValue - secondValue;
                break;
            case "*":
                result = firstValue * secondValue;
                break;
            case "/":
                result = firstValue / secondValue;
                break;
            case "^":
                result = Math.pow(firstValue, secondValue);
                break;
        }
        visor.setText(String.valueOf(result));
    }
}
