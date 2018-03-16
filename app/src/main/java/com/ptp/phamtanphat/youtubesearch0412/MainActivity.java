package com.ptp.phamtanphat.youtubesearch0412;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.ptp.phamtanphat.youtubesearch0412.Retrofit2.API.Item;
import com.ptp.phamtanphat.youtubesearch0412.Retrofit2.API.YoutubeSearch;
import com.ptp.phamtanphat.youtubesearch0412.Retrofit2.DataClient;
import com.ptp.phamtanphat.youtubesearch0412.Retrofit2.RetrofitAPI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static String API_KEY = "AIzaSyAkAPhTuGxpylPNlDOSL4qwZWLRtXdH91o";
    Button btnsearch;
    ListView lvsearch;
    EditText edtsearch;
    ArrayList<Item> mangitem;
    YoutubeSearchAdapter youtubeSearchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = edtsearch.getText().toString();
                search = search.replace(" " ,"%20");
                DataClient dataClient = RetrofitAPI.getdata();
                Call<YoutubeSearch> callback = dataClient.searchVideoYoutube("snippet",search,"50","video",API_KEY);
                callback.enqueue(new Callback<YoutubeSearch>() {
                    @Override
                    public void onResponse(Call<YoutubeSearch> call, Response<YoutubeSearch> response) {
                        YoutubeSearch youtubeSearch = response.body();
                        mangitem = (ArrayList<Item>) youtubeSearch.getItems();
                        youtubeSearchAdapter = new YoutubeSearchAdapter(MainActivity.this,android.R.layout.simple_list_item_1,mangitem);
                        lvsearch.setAdapter(youtubeSearchAdapter);
//                        Log.d("BBB",youtubeSearch.getItems().get(0).getSnippet().getTitle());
                    }

                    @Override
                    public void onFailure(Call<YoutubeSearch> call, Throwable t) {
                        Log.d("BBB",t.getMessage());
                    }
                });
           }
        });
    }

    private void anhxa() {
        btnsearch = findViewById(R.id.buttonsearch);
        lvsearch = findViewById(R.id.listviewyoutube);
        edtsearch = findViewById(R.id.edittextsearch);
    }
}
