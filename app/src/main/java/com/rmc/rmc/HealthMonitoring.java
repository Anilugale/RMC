package com.rmc.rmc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.rmc.rmc.adapter.ListAdapter;

import java.util.HashMap;
import java.util.Map;


public class HealthMonitoring extends ActionBarActivity {

    ListView health;
    Map<String,String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helth_monitoring);

        setList();
    }


    private void setList() {
        health=(ListView) findViewById(R.id.health_list);

        data=new HashMap<>();
        for(int i=10;i<20;i++)
        {
            data.put(""+i,"");
        }
        ListAdapter adapter=new ListAdapter(this,data);
        health.setAdapter(adapter);


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(HealthMonitoring.this,Master.class));
                        finish();
                    }
                });

            }
        }).start();


    }
}
