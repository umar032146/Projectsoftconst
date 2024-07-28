package com.example.travelcompanion;

import android.annotation.SuppressLint;
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

public class attract extends AppCompatActivity{

    String url4;
    TextView fun1;
    TextView fun2;
    TextView fun3;
    TextView fun4;
    TextView fun5;
    TextView fun6;
    TextView fun7;
    TextView fun8;
    TextView fun9;

    TextView joy1;
    TextView joy2;
    TextView joy3;
    TextView joy4;
    TextView joy5;
    TextView joy6;
    TextView joy7;
    TextView joy8;
    TextView joy9;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.funplaces);
         Button backbtn=findViewById(R.id.backbtnatt);
         Button refreshfun = findViewById(R.id.refreshfun);
         url4 = "https://worldtimeapi.org/api/timezone/Asia/Karachi";
         fun1=findViewById(R.id.fun1);
        fun2=findViewById(R.id.fun2);
        fun3=findViewById(R.id.fun3);
        fun4=findViewById(R.id.fun4);
        fun5=findViewById(R.id.fun5);
        fun6=findViewById(R.id.fun6);
        fun7=findViewById(R.id.fun7);
        fun8=findViewById(R.id.fun8);
        fun9=findViewById(R.id.fun9);

        joy1 =findViewById(R.id.joy1);
        joy2 =findViewById(R.id.joy2);
        joy3 =findViewById(R.id.joy3);
        joy4 =findViewById(R.id.joy4);
        joy5 =findViewById(R.id.joy5);
        joy6 =findViewById(R.id.joy6);
        joy7 =findViewById(R.id.joy7);
        joy8 =findViewById(R.id.joy8);
        joy9 =findViewById(R.id.joy9);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(attract.this, homepageadmin.class);
                startActivity(intent);
                finish();
            }
        });
        refreshfun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  fetchattracts();
            }
        });

    }
    public void fetchattracts(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url4,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            Toast.makeText(attract.this, "Data is shown", Toast.LENGTH_SHORT).show();
                            String res=response.getString("utc_datetime");
                            String resname = res.split("T")[0];
                            String resloc=response.getString("week_number");
                            fun1.setText(resname);
                            fun2.setText(resname);
                            fun3.setText(resname);
                            fun4.setText(resname);
                            fun5.setText(resname);
                            fun6.setText(resname);
                            fun7.setText(resname);
                            fun8.setText(resname);
                            fun9.setText(resname);

                            joy1.setText(resloc);
                            joy2.setText(resloc);
                            joy3.setText(resloc);
                            joy4.setText(resloc);
                            joy5.setText(resloc);
                            joy6.setText(resloc);
                            joy7.setText(resloc);
                            joy8.setText(resloc);
                            joy9.setText(resloc);

                        }catch (Exception e){
                            Toast.makeText(attract.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(attract.this, "Data is not shown", Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(jsonObjectRequest);

    }
}
