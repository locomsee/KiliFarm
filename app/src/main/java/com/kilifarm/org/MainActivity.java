package com.kilifarm.org;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kilifarm.org.Authentication.RegistrationActivity;
import com.kilifarm.org.Dashboard.Dashboard;
import com.kilifarm.org.Models.Registration;
import com.kilifarm.org.Response.loginResponse;
import com.kilifarm.org.Rest.APIclient;
import com.kilifarm.org.Rest.KilifarmEndpoints;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    EditText phone;
    EditText pass;
    TextView viewreg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone=(EditText)findViewById(R.id.lgphone);
        pass=(EditText)findViewById(R.id.lgpass);

        phone.setText("0702689658");
        pass.setText("123456");
        viewreg=(TextView)findViewById(R.id.tvReg);
        viewreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(i);

            }
        });


    }

    public void viewMain(View view){

        String coolphone=phone.getText().toString();
        String coolpass=pass.getText().toString();
        if(coolphone.isEmpty()){
            phone.setError("Phone number is required");
            phone.requestFocus();
           // Toast.makeText(getApplicationContext(),"Phone Number is Required",Toast.LENGTH_LONG).show();
            return;
        }else if(coolpass.isEmpty()){
            pass.setError("Password is required");
            pass.requestFocus();
           // Toast.makeText(getApplicationContext(),"Password is Required",Toast.LENGTH_LONG).show();
            return;

        }else if(coolphone.length()<10) {
            phone.setError("Phone Number should be 10 characters long");
            phone.requestFocus();

            return;
        }

        else if(coolpass.length()<6) {
            pass.setError("Password should be atleast 6 characters long");
            pass.requestFocus();
            return;
        }


            loginResponse logi=new loginResponse(coolphone,coolpass);

        logdata(logi);

    }


   public void logdata(final loginResponse loginResponse){
       final String TAG = "LoginActivity";

       final KilifarmEndpoints apiservice= APIclient.getClient().create(KilifarmEndpoints.class);
       Call<loginResponse> call=apiservice.isValidUser(loginResponse);
       call.enqueue(new Callback<loginResponse>() {
           @Override
           public void onResponse(Call<loginResponse> call, Response<loginResponse> response) {
               int result=response.code();
               loginResponse haha=response.body();


               if(result==200){
                   Toast.makeText(MainActivity.this,""+haha.getMessage(),Toast.LENGTH_LONG).show();
                   Intent i=new Intent(MainActivity.this, Dashboard.class);
                   startActivity(i);
               }else if(result==401){
                   Toast.makeText(MainActivity.this,"Wrong Email or Password",Toast.LENGTH_LONG).show();
               }



           }

           @Override
           public void onFailure(Call<loginResponse> call, Throwable t) {
               Toast.makeText(MainActivity.this,""+t.getMessage(),Toast.LENGTH_LONG).show();
           }
       });




   }



}
