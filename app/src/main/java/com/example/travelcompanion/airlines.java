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

public class airlines extends AppCompatActivity {
    String url2;
    TextView flight1;
    TextView flight2;
    TextView flight3;
    TextView flight4;
    TextView flight5;
    TextView flight6;
    TextView flight7;
    TextView flight8;
    TextView flight9;
    TextView time1;
    TextView time2;
    TextView time3;
    TextView time4;
    TextView time5;
    TextView time6;
    TextView time7;
    TextView time8;
    TextView time9;
    Button refresh2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airline);
        Button backbtnairline=findViewById(R.id.backbtnairline);
        refresh2 =findViewById(R.id.refreshapi2);

        flight1 =findViewById(R.id.flight1);
        flight2 =findViewById(R.id.flight2);
        flight3 =findViewById(R.id.flight3);
        flight4 =findViewById(R.id.flight4);
        flight5 =findViewById(R.id.flight5);
        flight6 =findViewById(R.id.flight6);
        flight7 =findViewById(R.id.flight7);
        flight8 =findViewById(R.id.flight8);
        flight9 =findViewById(R.id.flight9);

        time1= findViewById(R.id.time1);
        time2= findViewById(R.id.time2);
        time3= findViewById(R.id.time3);
        time4= findViewById(R.id.time4);
        time5= findViewById(R.id.time5);
        time6= findViewById(R.id.time6);
        time7= findViewById(R.id.time7);
        time8= findViewById(R.id.time8);
        time9= findViewById(R.id.time9);
        url2 ="https://worldtimeapi.org/api/timezone/Asia/Karachi";

        refresh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchairlines();
            }
        });
        backbtnairline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(airlines.this, homepageadmin.class);
                startActivity(intent);
                finish();
            }
        });


    }
    public void fetchairlines(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url2,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Toast.makeText(airlines.this, "Data is shown", Toast.LENGTH_SHORT).show();
                            String hotelname=response.getString("timezone");
                            String location=response.getString("utc_offset");
                            flight1.setText(hotelname);
                            flight2.setText(hotelname);
                            flight3.setText(hotelname);
                            flight4.setText(hotelname);
                            flight5.setText(hotelname);
                            flight6.setText(hotelname);
                            flight7.setText(hotelname);
                            flight8.setText(hotelname);
                            flight9.setText(hotelname);
                            time1.setText(location);
                            time2.setText(location);
                            time3.setText(location);
                            time4.setText(location);
                            time5.setText(location);
                            time6.setText(location);
                            time7.setText(location);
                            time8.setText(location);
                            time9.setText(location);

                        }catch (Exception e){
                            Toast.makeText(airlines.this, "Data is not shown", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error here
                        Log.e("VolleyError", error.toString());
                        Toast.makeText(airlines.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        Volley.newRequestQueue(this).add(jsonObjectRequest);

    }
}
