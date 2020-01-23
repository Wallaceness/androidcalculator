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

    public String display="0";
    private TextView calculatorScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorScreen= (TextView) findViewById(R.id.calc_screen);
    }

    public void updateDisplay(View view){
//        Log.d(TAG, );
        display=(String) calculatorScreen.getText();
        Button b=(Button) view;
        String buttonText= b.getText().toString();
        if (display.equals("0")){
            Log.d(TAG, buttonText);
            display=buttonText;
            calculatorScreen.setText(display);
        }
        else{
            display+=buttonText;
            calculatorScreen.setText(display);
        }
    }

    public void add(){
//        return a + b;
        Log.d(TAG, "add: ");
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

    protected double squareRoot(double number){
        return Math.sqrt(number);
    }
}
