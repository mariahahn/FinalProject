package com.example.finalproject4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
//Maria Santos- Final Project
public class MainActivity extends AppCompatActivity {

    List<ElementsModel> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);

        jsonParse();

        ElementsAdapter adapter = new ElementsAdapter(this, modelList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void jsonParse(){
        String url = "https://run.mocky.io/v3/f413edff-f2c4-46d8-85c4-710e9786cc2d";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject element = response.getJSONObject(i);
                                String name = element.getString("name");
                                int number = element.getInt("number");
                               String symbol = element.getString("symbol");
                                String summary = element.getString("summary");


                                ElementsModel elementsModel = new ElementsModel(name, number, symbol, summary);
                                modelList.add(elementsModel);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}