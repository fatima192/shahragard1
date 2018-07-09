package com.example.asus.proto5phase3.Database.Model;

public class RequestedTrips {
    public static final String TABLE_NAME = "requestedtrips_table";

    public static final String COL_id="id";
    public static final String COL_trip="trip";
    public static final String COL_driver="driver";
    public static final String COL_requestedUser=" requestedUser";
    public static final String COL_isAccepted ="isAccepted";


    private int id;
    private int trip;
    private int driver;
    private int requestedUser;
    private int isAccepetd;

    public int getIsAccepetd() {
        return isAccepetd;
    }

    public void setIsAccepetd(int isAccepetd) {
        this.isAccepetd = isAccepetd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrip() {
        return trip;
    }

    public void setTrip(int trip) {
        this.trip = trip;
    }

    public int getDriver() {
        return driver;
    }

    public void setDriver(int driver) {
        this.driver = driver;
    }

    public int getRequestedUser() {
        return requestedUser;
    }

    public void setRequestedUser(int requestedUser) {
        this.requestedUser = requestedUser;
    }



    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_trip + "TEXT,"
                    + COL_driver + " TEXT,"
                    + COL_requestedUser + " TEXT,"
                    + COL_isAccepted + "TEXT"
                    + ")";
    public RequestedTrips (int trip, int driver, int requestedUser, int isAccepetd){
        this.trip=trip;
        this.driver=driver;
        this.requestedUser=requestedUser;
        this.isAccepetd=isAccepetd;

    }

}
