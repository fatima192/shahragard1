package com.example.fatima.shahragardwithlogin.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.example.fatima.shahragardwithlogin.Database.Model.Trip;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "trips.db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("eeee","safa");
        db.execSQL(Trip.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Trip.TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(Trip trip){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Trip.COL_origin, trip.getOrigin());
        contentValues.put(Trip.COL_destination, trip.getDestination());
        contentValues.put(Trip.COL_day, trip.getDay());
        contentValues.put(Trip.COL_month, trip.getMonth() );
        contentValues.put(Trip.COL_time, trip.getTime());
        contentValues.put(Trip.COL_seats, trip.getSeats_num());
        contentValues.put(Trip.COL_exp, trip.getExp());
        Long result = db.insertOrThrow(Trip.TABLE_NAME, null, contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }
    ////Funtion get all friends//
    public List<Trip> getTrips() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlselect = {"id", "origin", "destination", "day", "month", "time", "seats_num", "exp"};
        String tableName = "trips_table";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlselect, null, null, null, null, null);
        List<Trip> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
//                Trip trip = new Trip();
//                trip.setId(cursor.getInt(cursor.getColumnIndex("id")));
//                trip.setOrigin(cursor.getString(cursor.getColumnIndex("origin")));
//                trip.setDestination(cursor.getString(cursor.getColumnIndex("destination")));
//                trip.setDay(cursor.getString(cursor.getColumnIndex("day")));
//                trip.setMonth(cursor.getString(cursor.getColumnIndex("month")));
//                trip.setTime(cursor.getString(cursor.getColumnIndex("time")));
//                trip.setSeats_num(cursor.getString(cursor.getColumnIndex("seats_num")));
//                trip.setExp(cursor.getString(cursor.getColumnIndex("exp")));
//                result.add(trip);
            }
            while (cursor.moveToNext());
        }
        return result;


    }

    public List<Trip> getTripsBySearch(String origin, String destination, String day, String month, String seats_num ){
        SQLiteDatabase db = getReadableDatabase();
        String[] sqlselect = {origin, destination, day, month, seats_num};
        String tableName = "trips_table";
        String sql="SELECT * From trips_table;";
        //String sql = "SELECT * From trips_table WHERE origin ="+origin+"  AND destination ="+destination+"  AND day = "+day+" AND month ="+month+" AND seats_num ="+seats_num;
        Cursor cursor =db.rawQuery(sql, null);
        Log.e("db",cursor.toString());
        boolean b =cursor==null;
        List<Trip> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Trip trip = new Trip(cursor.getString(cursor.getColumnIndex("origin")),cursor.getString(cursor.getColumnIndex("destination")),cursor.getString(cursor.getColumnIndex("day")),cursor.getString(cursor.getColumnIndex("month")),cursor.getString(cursor.getColumnIndex("time")),cursor.getString(cursor.getColumnIndex("seats_num")),cursor.getString(cursor.getColumnIndex("exp")));
                Log.e("trip:",trip.toString());
                trip.setId(cursor.getInt(cursor.getColumnIndex("id")));
//                trip.setOrigin(cursor.getString(cursor.getColumnIndex("origin")));
//                trip.setDestination(cursor.getString(cursor.getColumnIndex("destination")));
//                trip.setDay(cursor.getString(cursor.getColumnIndex("day")));
//                trip.setMonth(cursor.getString(cursor.getColumnIndex("month")));
//                trip.setTime(cursor.getString(cursor.getColumnIndex("time")));
//                trip.setSeats_num(cursor.getString(cursor.getColumnIndex("seats_num")));
//                trip.setExp(cursor.getString(cursor.getColumnIndex("exp")));
                result.add(trip);
            }
            while (cursor.moveToNext());
        }
        return result;




    }
}
