package com.example.travelcompanion;

import android.content.Intent;
import android.os.Bundle;
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


public class restaurants extends AppCompatActivity {

    String url3;
    TextView res1;
    TextView res2;
    TextView res3;
    TextView res4;
    TextView res5;
    TextView res6;
    TextView res7;
    TextView res8;
    TextView res9;

    TextView menu1;
    TextView menu2;

    TextView menu3;
    TextView menu4;
    TextView menu5;
    TextView menu6;
    TextView menu7;
    TextView menu8;
    TextView menu9;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurants);
        Button backbtnres=findViewById(R.id.backbtnres);
        Button refreshres= findViewById(R.id.refreshres);
        url3 = "https://worldtimeapi.org/api/timezone/Asia/Karachi";
        res1 =findViewById(R.id.res1);
        res2 =findViewById(R.id.res2);
        res3 =findViewById(R.id.res3);
        res4 =findViewById(R.id.res4);
        res5 =findViewById(R.id.res5);
        res6 =findViewById(R.id.res6);
        res7 =findViewById(R.id.res7);
        res8 =findViewById(R.id.res8);
        res9 =findViewById(R.id.res9);

        menu1 =findViewById(R.id.menu1);
        menu2 =findViewById(R.id.menu2);
        menu3 =findViewById(R.id.menu3);
        menu4 =findViewById(R.id.menu4);
        menu5 =findViewById(R.id.menu5);
        menu6 =findViewById(R.id.menu6);
        menu7 =findViewById(R.id.menu7);
        menu8 =findViewById(R.id.menu8);
        menu9 =findViewById(R.id.menu9);

        refreshres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               fetchrestaurants();
            }
        });

        backbtnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(restaurants.this, homepageadmin.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void fetchrestaurants(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url3,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                     try {
                         Toast.makeText(restaurants.this, "Data is shown", Toast.LENGTH_SHORT).show();
                         String resname=response.getString("unixtime");
                         String resloc=response.getString("raw_offset");
                         res1.setText(resname);
                         res2.setText(resname);
                         res3.setText(resname);
                         res4.setText(resname);
                         res5.setText(resname);
                         res6.setText(resname);
                         res7.setText(resname);
                         res8.setText(resname);
                         res9.setText(resname);

                         menu1.setText(resloc);
                         menu2.setText(resloc);
                         menu3.setText(resloc);
                         menu4.setText(resloc);
                         menu5.setText(resloc);
                         menu6.setText(resloc);
                         menu7.setText(resloc);
                         menu8.setText(resloc);
                         menu9.setText(resloc);

                     }catch (Exception e){
                         Toast.makeText(restaurants.this, e.toString(), Toast.LENGTH_SHORT).show();
                     }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(restaurants.this, "Data is not shown", Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(jsonObjectRequest);

    }
}
