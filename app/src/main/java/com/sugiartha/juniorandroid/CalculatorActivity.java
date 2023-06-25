package com.sugiartha.juniorandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private TextView textViewResult;
    private TextView textViewOperation;

    private StringBuilder currentNumber = new StringBuilder();
    private double result = 0;
    private String operator = "";
    private String recentOperation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textViewResult = findViewById(R.id.textViewResult);
        textViewOperation = findViewById(R.id.textViewOperation);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonEquals = findViewById(R.id.buttonEquals);
        Button buttonClear = findViewById(R.id.buttonClear);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber.append("0");
                appendToRecentOperation("0");
                updateDisplay();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber.append("1");
                appendToRecentOperation("1");
                updateDisplay();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber.append("2");
                appendToRecentOperation("2");
                updateDisplay();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber.append("3");
                appendToRecentOperation("3");
                updateDisplay();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber.append("4");
                appendToRecentOperation("4");
                updateDisplay();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber.append("5");
                appendToRecentOperation("5");
                updateDisplay();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber.append("6");
                appendToRecentOperation("6");
                updateDisplay();
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber.append("7");
                appendToRecentOperation("7");
                updateDisplay();
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber.append("8");
                appendToRecentOperation("8");
                updateDisplay();
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber.append("9");
                appendToRecentOperation("9");
                updateDisplay();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                performOperation("+");
                appendToRecentOperation("+");
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                performOperation("-");
                appendToRecentOperation("-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                performOperation("*");
                appendToRecentOperation("*");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                performOperation("/");
                appendToRecentOperation("/");
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateResult();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCalculator();
            }
        });
    }

    private void performOperation(String newOperator) {
        if (operator.isEmpty()) {
            result = Double.parseDouble(currentNumber.toString());
        } else {
            calculateResult();
        }
        operator = newOperator;
        currentNumber.setLength(0); // Clear current number
    }

    private void calculateResult() {
        if (operator.isEmpty() || currentNumber.length() == 0) {
            return;
        }

        double number = Double.parseDouble(currentNumber.toString());
        switch (operator) {
            case "+":
                result += number;
                break;
            case "-":
                result -= number;
                break;
            case "*":
                result *= number;
                break;
            case "/":
                if (number != 0) {
                    result /= number;
                } else {
                    textViewResult.setText("Error");
                    return;
                }
                break;
        }

        currentNumber.setLength(0); // Clear current number
        currentNumber.append(result);
        operator = "";
        recentOperation = currentNumber.toString();
        textViewOperation.setText(recentOperation);
        updateDisplay();
    }

    private void clearCalculator() {
        currentNumber.setLength(0); // Clear current number
        result = 0;
        operator = "";
        recentOperation = "";
        textViewOperation.setText(recentOperation);
        updateDisplay();
    }

    private void updateDisplay() {
        textViewResult.setText(currentNumber.toString());

    }
    private void appendToRecentOperation(String value) {
        recentOperation += value;
        textViewOperation.setText(recentOperation);
    }
}





