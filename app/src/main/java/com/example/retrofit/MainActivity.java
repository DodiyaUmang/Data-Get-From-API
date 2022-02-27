package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ApiInterface apiInterface;
    myAdapter myAdapter;
    Example examples;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiInterface=RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<Example> call=apiInterface.getExamples();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                examples=response.body();
                myAdapter = new myAdapter(examples, MainActivity.this);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }
}