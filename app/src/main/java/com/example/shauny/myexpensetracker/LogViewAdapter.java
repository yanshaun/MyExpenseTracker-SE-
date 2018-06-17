package com.example.shauny.myexpensetracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class LogViewAdapter extends RecyclerView.Adapter<LogViewAdapter.ViewHolder> {

    private static final String TAG = "LogViewAdapter";

    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mAmount = new ArrayList<>();
    private Context mContext;

    public LogViewAdapter(ArrayList<String> mTitle, ArrayList<String> mAmount, Context mContext) {
        this.mTitle = mTitle;
        this.mAmount = mAmount;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.log_layout, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        holder.title.setText(mTitle.get(position));
        holder.amount.setText(mAmount.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on " + mTitle.get(position));

                Toast.makeText(mContext, mAmount.get(position), Toast.LENGTH_SHORT).show();
                
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView amount;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.logTitle);
            amount = (TextView) itemView.findViewById(R.id.logAmount);
            parentLayout = (RelativeLayout) itemView.findViewById(R.id.logLayout);
        }
    }
}
