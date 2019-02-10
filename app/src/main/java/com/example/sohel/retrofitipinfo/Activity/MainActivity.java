package com.example.sohel.retrofitipinfo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sohel.retrofitipinfo.Model.ServerResponse;
import com.example.sohel.retrofitipinfo.Network.ApiInterface;
import com.example.sohel.retrofitipinfo.R;
import com.example.sohel.retrofitipinfo.Retrofit.RetrofitApiClient;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnGetIp;
    private TextView txtIp, txtCity, txtCountry;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetIp = findViewById(R.id.show_ip_button);
        txtIp = findViewById(R.id.ip_address_textView);
        txtCity = findViewById(R.id.city_textView);
        txtCountry = findViewById(R.id.country_textView);
        progressBar = findViewById(R.id.progressBar);

        btnGetIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyIp();
            }
        });
    }

    private void showMyIp() {
        progressBar.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);

        retrofit2.Call<ServerResponse> call = apiInterface.getMyIp();
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(retrofit2.Call<ServerResponse> call, Response<ServerResponse> response) {
                progressBar.setVisibility(View.GONE);

                ServerResponse serverResponse = response.body();

                if(response.code()==200 && serverResponse!=null){ //code 200 means server call success
                    //data found, so place them
                    txtIp.setText(serverResponse.getIp());
                    txtCity.setText(serverResponse.getCity());
                    txtCountry.setText(serverResponse.getCountry());
                }
                else{
                    txtIp.setText(response.message()); //error message shown
                    txtCity.setText("");
                    txtCountry.setText("");
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ServerResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);

                txtIp.setText(t.getMessage());
                txtCity.setText("");
                txtCountry.setText("");
            }
        });

    }
}
