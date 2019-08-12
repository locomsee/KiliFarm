package com.kilifarm.org.Authentication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.kilifarm.org.Models.Registration;
import com.kilifarm.org.R;
import com.kilifarm.org.Rest.APIclient;
import com.kilifarm.org.Rest.KilifarmEndpoints;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {
    EditText First;
    EditText Last;
    EditText Phone;
    EditText Email;
    EditText Password;
    EditText ConfPass;

    ProgressBar progressBar;

    private RelativeLayout rl;
    private Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Toolbar tb=findViewById(R.id.bgHeader);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        First=(EditText) findViewById(R.id.editTextFirstName);
        Last=(EditText)findViewById(R.id.editTextLastName);
        Phone=(EditText) findViewById(R.id.editTextPhone);
        Email=(EditText)findViewById(R.id.editTextEmail);
        Password=(EditText)findViewById(R.id.editTextPass);
        ConfPass=(EditText)findViewById(R.id.editTextConfPass);

        progressBar=(ProgressBar)findViewById(R.id.regbar);
        progressBar.setVisibility(View.GONE);

        rl=findViewById(R.id.rlayout);
        anim= AnimationUtils.loadAnimation(this,R.anim.uptodowndiagonal);
        rl.setAnimation(anim);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void validateFields(){
        String valFirst=First.getText().toString();
        String valLast= Last.getText().toString();
        String valPhone=Phone.getText().toString();
        String valEmail=Email.getText().toString();
        String valPass=Password.getText().toString();
        String valConf=ConfPass.getText().toString();


        if(valFirst.isEmpty() && valLast.isEmpty() && valPhone.isEmpty() && valEmail.isEmpty() && valPass.isEmpty() && valConf.isEmpty()){
            Toast.makeText(getApplicationContext(), "All Details Are Required",Toast.LENGTH_LONG).show();
        }else
        if(valFirst.isEmpty()){
            First.setError("First Name Required");
            First.requestFocus();
            Toast.makeText(getApplicationContext(), "First Name Required",Toast.LENGTH_LONG).show();
            return;
        }else if(valLast.isEmpty()){
            Last.setError("Last Name Required");
            Last.requestFocus();
            Toast.makeText(getApplicationContext(), "Last Name Required",Toast.LENGTH_LONG).show();
            return;
        }else if(valEmail.isEmpty()){
            Email.setError("Email is Required");
            Email.requestFocus();
            Toast.makeText(getApplicationContext(), "Email is Required",Toast.LENGTH_LONG).show();
            return;
        }
        else if(valPhone.isEmpty()){
            Phone.setError("Phone Number Required");
            Phone.requestFocus();
            Toast.makeText(getApplicationContext(), "Phone Number Required",Toast.LENGTH_LONG).show();
            return;
        }else if(valPass.isEmpty()){
            Password.setError("Password is Required");
            Password.requestFocus();
            Toast.makeText(getApplicationContext(), "Password is Required",Toast.LENGTH_LONG).show();
            return;
        }else if(valConf.isEmpty()){
            ConfPass.setError("Confirm Password Required");
            Phone.requestFocus();
            Toast.makeText(getApplicationContext(), "Confirm Password required",Toast.LENGTH_LONG).show();
            return;
        }else{

            progressBar.setVisibility(View.VISIBLE);

            Registration register=new Registration(valFirst,valLast,valPhone,valEmail,valPass);
            sendInfo(register);

        }

    }
    public void procData(View view){
        validateFields();
    }

    public void sendInfo(Registration register){
        final String TAG = "RegistrationActivity";

            final KilifarmEndpoints apiservice= APIclient.getClient().create(KilifarmEndpoints.class);
        Call<Registration> call=apiservice.reg(register);
        try {
            call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        call.enqueue(new Callback<Registration>() {
            @Override
            public void onResponse(Call<Registration> call, Response<Registration> response) {
                Registration tl = response.body();
                String test="null";
                Log.e(TAG, "onResponse: " + tl.getMessage());
               // if(!test.equals(tl.getMessage())){
                    Toast.makeText(RegistrationActivity.this,"registered ",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
               /// }else {

                    Toast.makeText(RegistrationActivity.this, "registered " + tl.getMessage(), Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
              //  }
            }

            @Override
            public void onFailure(Call<Registration> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);

            }
        });



    }
}
