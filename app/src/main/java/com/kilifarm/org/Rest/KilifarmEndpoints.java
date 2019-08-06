package com.kilifarm.org.Rest;




import com.kilifarm.org.Models.Registration;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface KilifarmEndpoints {

    @Headers("Content-Type: application/json")
    @POST("auth/register")
    Call<Registration> reg(@Body Registration registration);

}
