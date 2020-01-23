package com.example.android.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

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
    }

    public void updateDisplay(View view){
//        Log.d(TAG, );
        display=(String) calculatorScreen.getText();
        Button b=(Button) view;
        String buttonText= b.getText().toString();
        if (operationLast){
            storedNumber=display;
            display=buttonText;
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
            if (storedOperation.equals("+")){
                result=add(storedValue, displayValue);
            }
            else if (storedOperation.equals("-")){
                result=subtract(storedValue, displayValue);
            }
            else if (storedOperation.equals("x")){
                result=multiply(storedValue, displayValue);
            }
            else if (storedOperation.equals("÷")){
                result=divide(storedValue, displayValue);
            }
            else if (storedOperation.equals("^")){
                result=power(storedValue, displayValue);
            }
            else if (storedOperation.equals("√")){
                result=squareRoot(storedValue, displayValue);
            }
            else{
                result=0;
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
}
