package com.kilifarm.org.Rest;




import com.kilifarm.org.Models.Registration;
import com.kilifarm.org.Response.loginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface KilifarmEndpoints {

    @Headers("Content-Type: application/json")
    @POST("auth/signup")
    Call<Registration> reg(@Body Registration registration);


    @Headers("Content-Type: application/json")
    @POST("auth/login")
    Call<loginResponse> isValidUser(@Body loginResponse loginResponse);

}
