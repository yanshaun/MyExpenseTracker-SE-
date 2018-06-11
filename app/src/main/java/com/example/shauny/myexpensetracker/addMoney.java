package com.example.shauny.myexpensetracker;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class addMoney extends MainActivity {

    EditText amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Money");
        setContentView(R.layout.add_money);
        Spinner mySpinner = (Spinner) findViewById(R.id.chooseCategory);
        ArrayAdapter<String> myAdapter =
                new ArrayAdapter<String>(addMoney.this, android.R.layout.simple_list_item_1,
                        getResources().getStringArray(R.array.savingsCategory));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) {
                    category = "Income";
                }
                if (i == 1) {
                    category = "Savings";
                }
                if (i == 2) {
                    category = "Allowance";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        addButton();
        amount = (EditText) findViewById(R.id.amount);
        dispLogv = (TextView) findViewById(R.id.dispLog);
    }

    private void addButton() {
        Button btn = (Button) findViewById(R.id.Add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amount.getText().toString().trim().isEmpty()){
                    Toast.makeText(addMoney.this, "You did not enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    number = Integer.parseInt(amount.getText().toString());
                    balance += number;
                    symbol = "+";
                   Log l1 = new Log(number,symbol,category);
                   list.add(l1);

                }
        finish();
            }
        });
    }
}





