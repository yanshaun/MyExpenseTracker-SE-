package com.example.shauny.myexpensetracker;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;

public class minusMoney extends MainActivity {

    EditText amount1;
    TextView tv;
    String curview = CustomOnItemSelectedListener.currency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Expense");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minus_money);
        Spinner mySpinner = (Spinner) findViewById(R.id.chooseCategoryMinus);
        ArrayAdapter<String> myAdapter =
                new ArrayAdapter<String>(minusMoney.this, android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.expensesCategory));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    categoryMinus = "Eating Out";
                }
                if (i == 1) {
                    categoryMinus = "Clothes";
                }
                if (i == 2) {
                    categoryMinus = "Food";
                }
                if (i == 3) {
                    categoryMinus = "Bills";
                }
                if (i == 4) {
                    categoryMinus = "Entertainment";
                }
                if (i == 5) {
                    categoryMinus = "Others";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        minusButton();
        tv = (TextView) findViewById(R.id.currencyView);
        tv.setText(curview);
        amount1 = (EditText) findViewById(R.id.amountMinus);

    }

    private void minusButton() {

        Button btn = (Button) findViewById(R.id.subtractBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amount1.getText().toString().trim().isEmpty()){
                    Toast.makeText(minusMoney.this, "You did not enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    number1 = Integer.parseInt(amount1.getText().toString());
                    balance = balance - number1;
                    symbol = "-";
                }
                finish();
            }
        });
    }

}
