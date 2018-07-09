package com.example.asus.proto5phase3;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.asus.proto5phase3.Database.Model.Trip;
import com.example.asus.proto5phase3.RecyclerView.SearchResult;

import java.util.List;

public class SearchFragment extends Fragment {
    Button btnSearch;
    EditText origin, destination, day, month, seats;
    public static List<Trip> res;

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;


    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
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
                android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
                SearchResult fragment = new SearchResult();
                transaction.replace(R.id.frame_layout, fragment);
                transaction.commit();
            }
        });
        return v;
    }

    public void view() {
      res=signIn.db.getTripsBySearch(origin.getText().toString(), destination.getText().toString(), day.getText().toString(), month.getText().toString(), seats.getText().toString());
        //viewTrips(res);

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
