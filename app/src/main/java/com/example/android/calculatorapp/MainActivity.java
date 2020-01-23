package com.example.android.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public int display=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
