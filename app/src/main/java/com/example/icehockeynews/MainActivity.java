package com.example.icehockeynews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.icehockeynews.helper.RankingNhl;
import com.example.icehockeynews.model.Division;
import com.example.icehockeynews.model.Teams;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    private List<Division> Divisionen = new ArrayList<Division>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQueue = Volley.newRequestQueue(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        jsonParse();
    }

    private void jsonParse(){
        String url ="https://statsapi.web.nhl.com/api/v1/standings";
        ListView teams = findViewById(R.id.teamsliste);
        ArrayAdapter<Teams> teamsArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                   Divisionen.addAll(RankingNhl.createTabelleFromJsonString(response));
                    teamsArrayAdapter.addAll(Divisionen.get(0).getTeamsList());
                    teams.setAdapter(teamsArrayAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

    private void addTeamsToClickableList(){
        ListView teams = findViewById(R.id.teamsliste);
        ArrayAdapter<Teams> teamsAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
    }
}