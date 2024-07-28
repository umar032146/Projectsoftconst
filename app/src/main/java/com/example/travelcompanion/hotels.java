package com.example.travelcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class hotels extends AppCompatActivity {
    String url;
    TextView hotel1;
    TextView hotel2;
    TextView hotel3;
    TextView hotel4;
    TextView hotel5;
    TextView hotel6;
    TextView hotel7;
    TextView hotel8;
    TextView hotel9;
    TextView city1;
    TextView city2;
    TextView city3;
    TextView city4;
    TextView city5;
    TextView city6;
    TextView city7;
    TextView city8;
    TextView city9;
    Button refresh;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotels);
        Button backbtn=findViewById(R.id.backbtnhotel);
        refresh =findViewById(R.id.refreshapi);

        hotel1 =findViewById(R.id.hotel1);
        hotel2 =findViewById(R.id.hotel2);
        hotel3 =findViewById(R.id.hotel3);
        hotel4 =findViewById(R.id.hotel4);
        hotel5 =findViewById(R.id.hotel5);
        hotel6 =findViewById(R.id.hotel6);
        hotel7 =findViewById(R.id.hotel7);
        hotel8 =findViewById(R.id.hotel8);
        hotel9 =findViewById(R.id.hotel9);

        city1= findViewById(R.id.city1);
        city2= findViewById(R.id.city2);
        city3= findViewById(R.id.city3);
        city4= findViewById(R.id.city4);
        city5= findViewById(R.id.city5);
        city6= findViewById(R.id.city6);
        city7= findViewById(R.id.city7);
        city8= findViewById(R.id.city8);
        city9= findViewById(R.id.city9);
        url ="https://worldtimeapi.org/api/timezone/Asia/Karachi";

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchhotels();
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hotels.this, homepageadmin.class);
                startActivity(intent);
                finish();
            }
        });


    }
    public void fetchhotels(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Toast.makeText(hotels.this, "Data is shown", Toast.LENGTH_SHORT).show();
                            String hotelname=response.getString("timezone");
                            String location=response.getString("utc_offset");
                            hotel1.setText(hotelname);
                            hotel2.setText(hotelname);
                            hotel3.setText(hotelname);
                            hotel4.setText(hotelname);
                            hotel5.setText(hotelname);
                            hotel6.setText(hotelname);
                            hotel7.setText(hotelname);
                            hotel8.setText(hotelname);
                            hotel9.setText(hotelname);
                            city1.setText(location);
                            city2.setText(location);
                            city3.setText(location);
                            city4.setText(location);
                            city5.setText(location);
                            city6.setText(location);
                            city7.setText(location);
                            city8.setText(location);
                            city9.setText(location);

                        }catch (Exception e){
                            Toast.makeText(hotels.this, "Data is not shown", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error here
                        Log.e("VolleyError", error.toString());
                        Toast.makeText(hotels.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        Volley.newRequestQueue(this).add(jsonObjectRequest);

    }
}
