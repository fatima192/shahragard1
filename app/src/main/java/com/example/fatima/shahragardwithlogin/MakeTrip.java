package com.example.fatima.shahragardwithlogin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fatima.shahragardwithlogin.Database.DatabaseHelper;
import com.example.fatima.shahragardwithlogin.Database.Model.Trip;


public class MakeTrip extends Fragment {
    EditText origin, destination, day, month, time, seats , exp;
    Button btnMakeTrip;
    public static DatabaseHelper tripDb;
    boolean isInserted;


    public static MakeTrip newInstance() {
        MakeTrip fragment = new MakeTrip();
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
        tripDb = new DatabaseHelper(getContext());
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
                time.getText().toString(), seats.getText().toString(), exp.getText().toString());

        isInserted = tripDb.insertData(trip);
        if (isInserted == true) {
            Toast.makeText(getContext(), "سفر ساخته شد", Toast.LENGTH_SHORT).show();
            origin.setText("");destination.setText("");day.setText("");month.setText("");time.setText("");seats.setText("");exp.setText("");

        } else {
            Toast.makeText(getContext(), "در ساخت سفر مشکلی پیش آمپ.لطفا مجددا سعی نمایید", Toast.LENGTH_SHORT).show();
        }


    }
}
