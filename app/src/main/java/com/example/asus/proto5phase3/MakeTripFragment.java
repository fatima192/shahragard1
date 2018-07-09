package com.example.asus.proto5phase3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.proto5phase3.Database.DatabaseHelper;
import com.example.asus.proto5phase3.Database.Model.Trip;


public class MakeTripFragment extends Fragment {
    EditText origin, destination, day, month, time, seats , exp;
    Button btnMakeTrip;
    boolean isInserted;


    public static MakeTripFragment newInstance() {
        MakeTripFragment fragment = new MakeTripFragment();
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //trip.creat();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_make_trip, container, false);
        Log.e("1", "1");
        origin = v.findViewById(R.id.origin_input);
        destination = v.findViewById(R.id.destination_input);
        day = v.findViewById(R.id.day_input);
        month = v.findViewById(R.id.month_input);
        time = v.findViewById(R.id.time_input);
        seats = v.findViewById(R.id.seats_input);
        exp = v.findViewById(R.id.editText5);
        //
        // d(R.id.exp_input);
        btnMakeTrip = v.findViewById(R.id.maketrip_button);
        btnMakeTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
        return v;
    }

    public void addData() {
        Log.e("sadfghjk", "fghjkl");
        Trip trip= new Trip(origin.getText().toString(), destination.getText().toString(), day.getText().toString(), month.getText().toString(),
                time.getText().toString(), seats.getText().toString(), exp.getText().toString(), signIn.globalUser.getId());

        isInserted = signIn.db.insertData(trip);
        if (isInserted == true) {
            Toast.makeText(getContext(), "سفر ساخته شد", Toast.LENGTH_SHORT).show();
            origin.setText("");destination.setText("");day.setText("");month.setText("");time.setText("");seats.setText("");exp.setText("");

        } else {
            Toast.makeText(getContext(), "در ساخت سفر مشکلی پیش آمپ.لطفا مجددا سعی نمایید", Toast.LENGTH_SHORT).show();
        }


    }
}
