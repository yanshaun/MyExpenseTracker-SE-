package com.example.shauny.myexpensetracker;

import android.support.v7.app.AppCompatActivity;

public class Log extends AppCompatActivity{
    public int amount;
    public String symbol;
    public String category;
    Log(int amount, String symbol, String category){
        this.amount = amount;
        this.symbol = symbol;
        this.category = category;
    }
}
