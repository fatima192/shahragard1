package com.example.asus.proto5phase3;


import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.asus.proto5phase3.Database.Model.User;

public class Login extends AppCompatActivity {
    private Button button1;
    private Button button2;
    EditText username, password;

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username= findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        Log.d(TAG,"on create: Starting.");

        button1 = (Button) findViewById(R.id.signIn_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onclick: clicked button");
                Intent intent = new Intent(Login.this, signIn.class);
                startActivity(intent);
            }
        });
        button2 = (Button) findViewById(R.id.logIn_button);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                signIn.globalUser=signIn.db.findUser(username.getText().toString(), password.getText().toString());
                if (signIn.globalUser==null){


                }
                else {

                    Log.d(TAG, "onclick: clicked button");
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


}
