package com.rmc.rmc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Registration extends ActionBarActivity {

    Button continueBtn;
    TextView status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registartion);
        continueBtn=(Button)findViewById(R.id.cntbtn);
        status=(TextView)findViewById(R.id.status);
        continueBtn.setEnabled(false);

        new Register().execute();
    }

    public void onContinue(View view) {

        startActivity(new Intent(this,HelthMonitoring.class));
    }


    class Register extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected void onPreExecute() {
            status.setText("Registering");
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            status.setText("Ready");
            continueBtn.setEnabled(true);
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


}
