package com.example.countryapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.example.countryapp.model.CountryModel;
import com.example.countryapp.model.Result;
import com.example.countryapp.service.GetCountryDataService;
import com.example.countryapp.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    ArrayList<CountryModel> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        GetCountries();
    }

    private Object GetCountries() {

        GetCountryDataService getCountryDataService = RetrofitInstance.getCountryDataService();
        Call<Result> resultCall = getCountryDataService.getResult();

        resultCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();

                if(result != null && result.getResult() != null){
                    countries = (ArrayList<CountryModel>) result.getResult();

                    for(CountryModel c: countries){
                        Log.i("TAG", ""+ c.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {

            }
        });

        return countries;
    }
}