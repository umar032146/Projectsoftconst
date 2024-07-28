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

public class transport extends AppCompatActivity{

    String locname;
    String transportname;
    TextView transport1;
    TextView transport2;
    TextView transport3;
    TextView transport4;
    TextView transport5;
    TextView transport6;
    TextView transport7;
    TextView transport8;
    TextView transport9;
    TextView loc1;
    TextView loc2;
    TextView loc3;
    TextView loc4;
    TextView loc5;
    TextView loc6;
    TextView loc7;
    TextView loc8;
    TextView loc9;
    String urltran;
    Button transport;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.transport);
        Button backbtn = findViewById(R.id.backbtntrans);
         transport = findViewById(R.id.transportapi);
         transport2 = findViewById(R.id.trnasport2);
        transport3 = findViewById(R.id.trnasport3);
        transport4 = findViewById(R.id.trnasport4);
        transport5 = findViewById(R.id.trnasport5);
        transport6 = findViewById(R.id.trnasport6);
        transport7 = findViewById(R.id.trnasport7);
        transport8 = findViewById(R.id.trnasport8);
        transport9 = findViewById(R.id.trnasport9);
        transport1 = findViewById(R.id.trnasport1);

        loc1 =findViewById(R.id.loc1);
        loc2 =findViewById(R.id.loc2);
        loc3 =findViewById(R.id.loc3);
        loc4 =findViewById(R.id.loc4);
        loc5 =findViewById(R.id.loc5);
        loc6 =findViewById(R.id.loc6);
        loc7 =findViewById(R.id.loc7);
        loc8 =findViewById(R.id.loc8);
        loc9 =findViewById(R.id.loc9);

        urltran ="https://worldtimeapi.org/api/timezone/Asia/Karachi";
        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchtransport();
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(transport.this, homepageadmin.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void fetchtransport(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                urltran,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Toast.makeText(transport.this, "Data is Shown", Toast.LENGTH_SHORT).show();
                             transportname=response.getString("abbreviation");
                             locname=response.getString("day_of_year");
                            transport1.setText(transportname);
                            transport2.setText(transportname);
                            transport3.setText(transportname);
                            transport4.setText(transportname);
                            transport5.setText(transportname);
                            transport6.setText(transportname);
                            transport7.setText(transportname);
                            transport8.setText(transportname);
                            transport9.setText(transportname);

                            loc1.setText(locname);
                            loc2.setText(locname);
                            loc3.setText(locname);
                            loc4.setText(locname);
                            loc5.setText(locname);
                            loc6.setText(locname);
                            loc7.setText(locname);
                            loc8.setText(locname);
                            loc9.setText(locname);

                        }catch (Exception e){
                            Toast.makeText(transport.this, e.toString(), Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VolleyError", error.toString());
                Toast.makeText(transport.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }
}
