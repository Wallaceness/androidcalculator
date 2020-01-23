package com.example.android.calculatorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private String display="0";
    private String storedNumber;
    private String storedOperation;
    private TextView calculatorScreen;
    private boolean operationLast=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorScreen = (TextView) findViewById(R.id.calc_screen);
        if (savedInstanceState!=null){
            display = savedInstanceState.getString("display");
            storedNumber = savedInstanceState.getString("storedNumber");
            storedOperation = savedInstanceState.getString("storedOperation");
            operationLast = savedInstanceState.getBoolean("operationLast");
            calculatorScreen.setText(display);
        }
    }

    public void updateDisplay(View view){
//        Log.d(TAG, );
        display=(String) calculatorScreen.getText();
        Button b=(Button) view;
        String buttonText= b.getText().toString();
        if (operationLast){
            storedNumber=display;
            if (buttonText.equals(".")){
                display="0"+buttonText;
            }
            else{
                display=buttonText;
            }
            calculatorScreen.setText(display);
            operationLast=false;
        }
        else if (buttonText.equals(".")){
            if (display.indexOf('.')==-1){
                display+=buttonText;
                calculatorScreen.setText(display);
            }
        }
        else if (display.equals("0")){
            Log.d(TAG, buttonText);
            display=buttonText;
            calculatorScreen.setText(display);
        }
        else{
            display+=buttonText;
            calculatorScreen.setText(display);
        }
    }

    public void AC(View view){
        display="0";
        calculatorScreen.setText(display);
    }

    public void operation(View view){
        display=(String) calculatorScreen.getText();
        Button b=(Button) view;
        String buttonText= b.getText().toString();
        storedOperation=buttonText;
        operationLast=true;
    }

    public void onEquals(View view){
        if (storedOperation!=null && !operationLast){
            double storedValue= Double.parseDouble(storedNumber);
            double displayValue=Double.parseDouble(display);
            double result;
            switch(storedOperation) {
                case "+":
                    result = add(storedValue, displayValue);
                    break;
                case "-":
                    result = subtract(storedValue, displayValue);
                    break;
                case "x":
                    result = multiply(storedValue, displayValue);
                    break;
                case "÷":
                    result = divide(storedValue, displayValue);
                    break;
                case "^":
                    result = power(storedValue, displayValue);
                    break;
                case "√":
                    result = squareRoot(storedValue, displayValue);
                    break;
                default:
                    result = 0;
            }
            display=Double.toString(result);
            calculatorScreen.setText(display);
            storedNumber=null;
            storedOperation=null;
        }
    }

    public double add(double a, double b){
        return a + b;
    }

    protected double subtract(double a, double b){
        return a-b;
    }

    protected double multiply(double a, double b){
        return a*b;
    }

    protected double divide(double a, double b){
        return a/b;
    }

    protected double power(double number, double exponent){
        return Math.pow(number, exponent);
    }

    protected double squareRoot(double number, double exponent){
        return Math.pow(number, 1/exponent);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("display", display);
        outState.putString("storedNumber", storedNumber);
        outState.putString("storedOperation", storedOperation);
        outState.putBoolean("operationLast", operationLast);
    }
}
