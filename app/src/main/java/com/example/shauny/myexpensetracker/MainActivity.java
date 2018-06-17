package com.example.shauny.myexpensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    //recyclerview
    private ArrayList<String> mCategory = new ArrayList<>();
    private ArrayList<String> mAmount = new ArrayList<>();

    TextView dispBlnce;
    static int balance;
    static String category;
    static String categoryMinus;
    static String currency;

    static int number;
    static int number1;
    static String symbol;

    ImageButton addButton, minusButton, settingsButton;

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        dispBlnce = (TextView) findViewById(R.id.dispBalance);
        addButton = (ImageButton) findViewById(R.id.addbtn);
        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivityForResult(new Intent(getApplicationContext(), addMoney.class), 999);

            }
        });
        minusButton = (ImageButton) findViewById(R.id.minusbtn);

        minusButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), minusMoney.class), 999);
            }
        });

        settingsButton = (ImageButton) findViewById(R.id.setbtn);
        settingsButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivityForResult(new Intent(getApplicationContext(), Settings.class), 999);

            }
        });


        initData();
    }

    @Override
    protected void onResume () {
        super.onResume();
        dispBlnce.setText(balance + "");

    }

    private void initData(){
        mCategory.add("Food");
        mAmount.add("200.50");

        mCategory.add("Bills");
        mAmount.add("150.67");

        mCategory.add("Car");
        mAmount.add("1405.23");

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.expenseLog);
        LogViewAdapter adapter = new LogViewAdapter(mCategory, mAmount, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



}

