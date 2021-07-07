package com.example.icehockeynews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.example.icehockeynews.model.Teams;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void addTeamsToClickableList(){
        ListView teams = findViewById(R.id.teamsliste);
        ArrayAdapter<Teams> teamsAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
    }
}