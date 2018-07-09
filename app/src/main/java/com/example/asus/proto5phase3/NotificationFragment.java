package com.example.asus.proto5phase3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.proto5phase3.Database.Model.RequestedTrips;
import com.example.asus.proto5phase3.Database.Model.Trip;
import com.example.asus.proto5phase3.Database.Model.User;

import java.util.ArrayList;
import java.util.List;


public class NotificationFragment extends Fragment {
    public static NotificationFragment newInstance() {
        NotificationFragment fragment= new NotificationFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }


    public  void view(){
       List<RequestedTrips> result= signIn.db.getrequestedtrips(signIn.globalUser.getId());
       List<Trip> resultTrips= new ArrayList<>();
       List<User> resultUsers= new ArrayList<>();
        for (int i = 0; i <result.size() ; i++) {
            resultTrips.add(signIn.db.findRequestedTrips(result.get(i).getTrip()));
            resultUsers.add(signIn.db.findRequestedUser(result.get(i).getRequestedUser()));

        }




    }
}
