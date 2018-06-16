package com.example.shauny.myexpensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    TextView dispBlnce;
    static int balance;
    static String category;
    static String categoryMinus;
    static String currency;
    TextView dispLogv;
    static int number;
    static int number1;
    static String symbol;
    static ArrayList<Log> list;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        dispBlnce = (TextView) findViewById(R.id.dispBalance);
        dispLogv = (TextView) findViewById(R.id.dispLog);
        ImageButton addBtn = (ImageButton) findViewById(R.id.addbutton);
        addBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivityForResult(new Intent(getApplicationContext(), addMoney.class), 999);

            }
        });
        ImageButton minusButton = (ImageButton) findViewById(R.id.minusbtn);
        list = new ArrayList<Log>();
        minusButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), minusMoney.class), 999);
            }

        });

    }
        @Override
        protected void onResume () {
            super.onResume();
            dispBlnce.setText(balance + "");

        }
    }

