package com.example.countryname.service;

import com.example.countryname.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {

    // retrofit interface
    @GET("countries")
    Call<Result> getResult();


}
