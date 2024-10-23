package com.example.rideshare;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RidesAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Ride> rides;

    public RidesAdapter(Context context, ArrayList<Ride> rides) {
        this.context = context;
        this.rides = rides;
    }

    @Override
    public int getCount() {
        return rides.size();
    }

    @Override
    public Object getItem(int position) {
        return rides.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = LayoutInflater.from(context).inflate(R.layout.ride_item, parent, false);
        }

        TextView pickupTextView = row.findViewById(R.id.pickupTextView);
        TextView dropOffTextView = row.findViewById(R.id.dropOffTextView);

        Ride ride = rides.get(position);
        pickupTextView.setText(ride.getPickupLocation());
        dropOffTextView.setText(ride.getDropOffLocation());

        row.setOnClickListener(v -> {
            Intent intent = new Intent(context, RideDetailsActivity.class);
            intent.putExtra("RIDE_DETAILS", ride.toString()); // Adjust based on your implementation
            context.startActivity(intent);
        });

        return row;
    }
}
