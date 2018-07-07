package com.example.fatima.shahragardwithlogin;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class search extends Fragment {
    Button btnSearch;
    EditText origin, destination, day, month, seats;

    public static search newInstance() {
        search fragment = new search();
        return fragment;


    }
    //  SearchActivity search;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //      search= new SearchActivity();
        //     search.creat();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        Log.e("1", "1");
        origin = v.findViewById(R.id.search_origin_input);
        destination = v.findViewById(R.id.search_destination_input);
        day = v.findViewById(R.id.search_day_input);
        month = v.findViewById(R.id.search_month_input);
        seats = v.findViewById(R.id.search_seats_input);


        btnSearch = v.findViewById(R.id.search_button);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view();
            }
        });
        return v;
    }

    public void view() {
        List<Trip> res=MakeTrip.tripDb.getTripsBySearch(origin.getText().toString(), destination.getText().toString(), day.getText().toString(), month.getText().toString(), seats.getText().toString());
        viewTrips(res);

        if(!res.isEmpty())
            Toast.makeText(getContext(), "در ساخت سفر", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();
    }
    public void viewTrips(final List<Trip> trips){
        // Cursor res = (Cursor) trips;
        StringBuffer buffer = new StringBuffer();
        if (trips.size() == 0){
            showMessage("Error" , "سفری یافت نشد");
            return;
        }
        for (int i = 0 ; i<trips.size() ; i++){
            buffer.append("Origin : "+trips.get(i).getOrigin()+"\n");
            buffer.append("Destination : "+trips.get(i).getDestination()+"\n");
            buffer.append("Day : "+trips.get(i).getDay()+"    ");
            buffer.append("Month : "+trips.get(i).getMonth()+"\n");
            buffer.append("Time : "+trips.get(i).getTime()+"\n");
            buffer.append("Seats Number : "+trips.get(i).getSeats_num()+"\n\n");
        }
        showMessage("Trips" , buffer.toString());
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}

