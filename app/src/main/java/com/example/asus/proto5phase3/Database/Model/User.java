package com.example.asus.proto5phase3.Database.Model;

import java.util.List;

public class User {
    public static final String TABLE_NAME = "users_table";

    public static final String COL_id= "id";
    public static final String COL_username= "username";
    public static final String COL_password= "password";
    public static final String COL_name= "name";
    public static final String COL_gender= "gender";
    public static final String COL_age= "age";
    public static final String COL_city = "city";
    public static final String COL_number= "number";
    public static final String COL_car= "car";
    public static final String COL_carNumber= "carNumber";


    private int id;
    private String username;
    private String password;
    private String name;
    private String gender;
    private String age;
    private String city;
    private String number;
    private String car;
    private String carNumber;

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    private List madeTrips;
    private List requestedTrips;
    private List acceptedTrips;

    public List getAcceptedTrips() {
        return acceptedTrips;
    }

    public void setAcceptedTrips(List acceptedTrips) {
        this.acceptedTrips = acceptedTrips;
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_username + " TEXT,"
                    + COL_password + " TEXT,"
                    + COL_name + " TEXT,"
                    + COL_gender + " TEXT,"
                    + COL_age + " TEXT,"
                    + COL_city + " TEXT,"
                    + COL_number + " TEXT,"
                    + COL_car + " TEXT,"
                    + COL_carNumber + " TEXT"


                    + ")";
    public User(String username , String password , String name , String gender , String age, String city , String number,String car, String carNumber  ){
        this.username=username;
        this.password=password;
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.city=city;
        this.number=number;
        this.car=car;
        this.carNumber=carNumber;

    }


    public static String getTableName() {
        return TABLE_NAME;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public List getMadeTrips() {
        return madeTrips;
    }

    public void setMadeTrips(List madeTrips) {
        this.madeTrips = madeTrips;
    }

    public List getRequestedTrips() {
        return requestedTrips;
    }

    public void setRequestedTrips(List requestedTrips) {
        this.requestedTrips = requestedTrips;
    }
}
