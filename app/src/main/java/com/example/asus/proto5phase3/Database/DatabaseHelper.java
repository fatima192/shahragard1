package com.example.asus.proto5phase3.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.asus.proto5phase3.Database.Model.RequestedTrips;
import com.example.asus.proto5phase3.Database.Model.Trip;
import com.example.asus.proto5phase3.Database.Model.User;
import com.example.asus.proto5phase3.R;

import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "trips.db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("eeee", "safa");
        db.execSQL(Trip.CREATE_TABLE);
        db.execSQL(User.CREATE_TABLE);
        db.execSQL(RequestedTrips.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Trip.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RequestedTrips.TABLE_NAME);

        onCreate(db);
    }


    public boolean insertData(Trip trip) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Trip.COL_origin, trip.getOrigin());
        contentValues.put(Trip.COL_destination, trip.getDestination());
        contentValues.put(Trip.COL_day, trip.getDay());
        contentValues.put(Trip.COL_month, trip.getMonth());
        contentValues.put(Trip.COL_time, trip.getTime());
        contentValues.put(Trip.COL_seats, trip.getSeats_num());
        contentValues.put(Trip.COL_exp, trip.getExp());
        contentValues.put(Trip.COL_exp, trip.getDriver());
        Long result = db.insertOrThrow(Trip.TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }


    public List<Trip> getTripsBySearch(String origin1, String destination1, String day1, String month1, String seats_num1) {
        SQLiteDatabase db = getReadableDatabase();
        int seatsNum = Integer.parseInt(seats_num1);
        String sql = "SELECT * From trips_table WHERE origin =" + "\"" + origin1 + "\"" + " AND destination =" + "\"" + destination1 + "\"" + " AND day =" + "\"" + day1 + "\"" + " AND month =" + "\"" + month1 + "\"" + " AND seats_num >=" + "\"" + seatsNum + "\"";
        Cursor cursor = db.rawQuery(sql, null);
        Log.e("db", cursor.toString());
        boolean b = cursor == null;
        List<Trip> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Trip trip = new Trip(cursor.getString(cursor.getColumnIndex("origin")), cursor.getString(cursor.getColumnIndex("destination")), cursor.getString(cursor.getColumnIndex("day")), cursor.getString(cursor.getColumnIndex("month")), cursor.getString(cursor.getColumnIndex("time")), cursor.getString(cursor.getColumnIndex("seats_num")), cursor.getString(cursor.getColumnIndex("exp")), cursor.getInt(cursor.getColumnIndex("driver")));
                Log.e("trip:", trip.toString());
                trip.setId(cursor.getInt(cursor.getColumnIndex("id")));
                result.add(trip);
            }
            while (cursor.moveToNext());
        }
        return result;
    }

    public boolean addNewUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(User.COL_username, user.getUsername());
        contentValues.put(User.COL_password, user.getPassword());
        contentValues.put(User.COL_name, user.getName());
        contentValues.put(User.COL_gender, user.getGender());
        contentValues.put(User.COL_age, user.getAge());
        contentValues.put(User.COL_city, user.getCity());
        contentValues.put(User.COL_number, user.getNumber());
        contentValues.put(User.COL_car, user.getCar());
        contentValues.put(User.COL_carNumber, user.getCarNumber());


        Long result = db.insertOrThrow(User.TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }

    public User findUser(String username1, String password1) {
        SQLiteDatabase db = getReadableDatabase();
        String[] sqlselect = {username1, password1};
        String tableName = "user's_table";
        String sql = "SELECT * From users_table  WHERE username =" + "\"" + username1 + "\"" + " AND password =" + "\"" + password1 + "\"";
        Cursor cursor = db.rawQuery(sql, null);
//        if (cursor == null) {
//            return null;
//        } else {
        if (cursor != null && cursor.moveToFirst()) {
            User user = new User(cursor.getString(cursor.getColumnIndex("username")), cursor.getString(cursor.getColumnIndex("password")), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("gender")), cursor.getString(cursor.getColumnIndex("age")), cursor.getString(cursor.getColumnIndex("city")), cursor.getString(cursor.getColumnIndex("number")), cursor.getString(cursor.getColumnIndex("car")), cursor.getString(cursor.getColumnIndex("carNumber")));

            return user;
//        }
        }
        else return null;

    }

    public boolean addRequest(RequestedTrips requestedTrips ,int trip, int driver , int requestedUser){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RequestedTrips.COL_trip, requestedTrips.getTrip() );
        contentValues.put(RequestedTrips.COL_driver, requestedTrips.getDriver() );
        contentValues.put(RequestedTrips.COL_requestedUser, requestedTrips.getRequestedUser() );
        Long result = db.insertOrThrow(RequestedTrips.TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;



    }
    public List<RequestedTrips> getrequestedtrips (int user1){
        SQLiteDatabase db = getReadableDatabase();
        String tableName = "requestedtrips_table";
        String sql = "SELECT * From requestedtrips_table WHERE id=" + "\""+ user1 + "\"" + " AND isAccepted=0";
        Cursor cursor= db.rawQuery(sql, null);
        boolean b = cursor == null;
        List<RequestedTrips> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                RequestedTrips requestedTrips= new RequestedTrips(cursor.getInt(cursor.getColumnIndex("trip")), cursor.getInt(cursor.getColumnIndex("driver")), cursor.getInt(cursor.getColumnIndex("requestedUser")),cursor.getInt(cursor.getColumnIndex("isAccepted")));

                requestedTrips.setId(cursor.getInt(cursor.getColumnIndex("id")));
                result.add(requestedTrips);
            }
            while (cursor.moveToNext());
        }
        return result;

    }
     public Trip findRequestedTrips(int trip1){
         SQLiteDatabase db = getReadableDatabase();
         String tableName = "trips_table";
         String sql = "SELECT * From trips_table WHERE id="+ "\"" + trip1 + "\"";
         Cursor cursor= db.rawQuery(sql, null);
         Trip trip = new Trip(cursor.getString(cursor.getColumnIndex("origin")), cursor.getString(cursor.getColumnIndex("destination")), cursor.getString(cursor.getColumnIndex("day")), cursor.getString(cursor.getColumnIndex("month")), cursor.getString(cursor.getColumnIndex("time")), cursor.getString(cursor.getColumnIndex("seats_num")), cursor.getString(cursor.getColumnIndex("exp")),cursor.getInt(cursor.getColumnIndex("driver")));
         return trip;


     }
     public User findRequestedUser(int user1){
        SQLiteDatabase db= getReadableDatabase();
        String sql= "SELECT * From users_table WHERE id=" + "\"" + user1 + "\"";
        Cursor cursor=db.rawQuery(sql, null);
        User user = new User(cursor.getString(cursor.getColumnIndex("username")), cursor.getString(cursor.getColumnIndex("password")), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("gender")), cursor.getString(cursor.getColumnIndex("age")), cursor.getString(cursor.getColumnIndex("city")), cursor.getString(cursor.getColumnIndex("number")), cursor.getString(cursor.getColumnIndex("car")), cursor.getString(cursor.getColumnIndex("carNumber")));

         return  user;

    }
    public List<RequestedTrips> getAnsweredTrips (int requestedUser1) {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * From trips_table WHERE requestedUser=" + "\"" + requestedUser1 + "\"";
        Cursor cursor = db.rawQuery(sql, null);
        List<RequestedTrips> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                RequestedTrips requestedTrips = new RequestedTrips(cursor.getInt(cursor.getColumnIndex("trip")), cursor.getInt(cursor.getColumnIndex("driver")), cursor.getInt(cursor.getColumnIndex("requestedUser")),cursor.getInt(cursor.getColumnIndex("isAccepetd")));
                requestedTrips.setId(cursor.getInt(cursor.getColumnIndex("id")));


                result.add(requestedTrips);
            }
            while (cursor.moveToNext());
        }
        return result;

    }
    public void setAccept(RequestedTrips trip){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RequestedTrips.COL_isAccepted,1);
        db.update(RequestedTrips.TABLE_NAME,values,RequestedTrips.COL_id + " = ? ", new String[]{String.valueOf(trip.getId())});
    }
    public void setReject(RequestedTrips trip){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RequestedTrips.COL_isAccepted,-1);
        db.update(RequestedTrips.TABLE_NAME,values,RequestedTrips.COL_id + " = ? ", new String[]{String.valueOf(trip.getId())});
    }
    public boolean findUserForSignUp(String username1){
        SQLiteDatabase db= getReadableDatabase();
        String sql= "SELECT * From users_table WHERE username = " + "\"" + username1 + "\"";
        Cursor cursor=db.rawQuery(sql, null);
        if (cursor==null){
            return  false;

        }
        else
            return true;


    }
}









