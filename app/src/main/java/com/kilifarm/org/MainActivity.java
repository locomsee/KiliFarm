package com.kilifarm.org;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kilifarm.org.Authentication.RegistrationActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void viewReg(View view){

        Intent i=new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(i);



    }
}
