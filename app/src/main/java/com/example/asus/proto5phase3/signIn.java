package com.example.asus.proto5phase3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.proto5phase3.Database.DatabaseHelper;
import com.example.asus.proto5phase3.Database.Model.User;
import com.example.asus.proto5phase3.signIn.*;
public class signIn extends AppCompatActivity {
    Button btnSignIn;
    EditText username, password, name, gender, age, city, number, car, carNumber;
    public static DatabaseHelper db;
    public static User globalUser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        db = new DatabaseHelper(signIn.this);
        setContentView(R.layout.activity_sign_in);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        gender = findViewById(R.id.gender);
        age = findViewById(R.id.age);
        city = findViewById(R.id.city);
        number = findViewById(R.id.phone_number);
        car = findViewById(R.id.car);
        carNumber = findViewById(R.id.car_number);

        btnSignIn = (Button) findViewById(R.id.signUp_button);
        btnSignIn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                signin();
                Intent intent = new Intent(signIn.this, MainActivity.class);
                startActivity(intent);
            }
        })
        ;
    }






    private void signin() {
        User user = new User(username.getText().toString(), password.getText().toString(), name.getText().toString(), gender.getText().toString(), age.getText().toString(), city.getText().toString(), number.getText().toString(), car.getText().toString(), carNumber.getText().toString());
//        if (db.findUserForSignUp(user.getUsername())) {
//            Toast.makeText(signIn.this, "این نام کاربری قبلا استفاده شده است", Toast.LENGTH_SHORT).show();
//
//
//        } else {


            boolean add = db.addNewUser(user);
            globalUser = user;

            if (add == true) {
                Toast.makeText(signIn.this, "اکانت شما ساخته شد", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(signIn.this, "در ساخت اکانت مشکلی پیش آمد.لطفا مجددا سعی نمایید", Toast.LENGTH_SHORT).show();
            }
        }
    }

