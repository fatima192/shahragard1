package com.example.asus.proto5phase3.Database.Model;



import com.example.asus.proto5phase3.ProfileFragment;

import java.util.List;

public class Trip {
    public static final String TABLE_NAME = "trips_table";

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", time='" + time + '\'' +
                ", seats_num='" + seats_num + '\'' +
                ", exp='" + exp + '\'' +
                '}';
    }

    public static final String COL_id= "id";
    public static final String COL_origin= "origin";
    public static final String COL_destination= "destination";
    public static final String COL_day= "day";
    public static final String COL_month= "month";
    public static final String COL_time= "time";
    public static final String COL_seats= "seats_num";
    public static final String COL_exp= "exp";
    public static final String COL_driver="driver";


    private int id;
    private String origin;
    private String destination;
    private String day;
    private String month;
    private String time;
    private String seats_num;
    private String exp;
    private int driver;

    public int getDriver() {
        return driver;
    }

    public void setDriver(int driver) {
        this.driver = driver;
    }


    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_origin + " TEXT,"
                    + COL_destination + " TEXT,"
                    + COL_day + " TEXT,"
                    + COL_month + " TEXT,"
                    + COL_time + " TEXT,"
                    + COL_seats + " TEXT,"
                    + COL_exp + " TEXT"
                    + COL_driver + "TEXT"
                    + ")";

    public Trip( String origin,  String destination, String day, String month, String time , String seats_num, String exp, int driver ){
        this.origin= origin;
        this.destination=destination;
        this.day=day;
        this.month=month;
        this.time=time;
        this.seats_num=seats_num;
        this.exp=exp;
        this.driver=driver;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeats_num() {
        return seats_num;
    }

    public void setSeats_num(String seats_num) {
        this.seats_num = seats_num;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
