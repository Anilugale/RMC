package com.rmc.rmc;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;


public class Master extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
    }


    public void start(View view) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                sendData();
            }
        }).start();

       /* DBHelper db= null;
        try {
            db = new DBHelper(this);
db.addData(new Data("okat"));
            List<Data> list =db.getAll();

            for (Data d:list)
            {
                System.out.println(d.getData());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/
    }

   void sendData()
    {
        try{

        while (true)
        {


            Socket s = new Socket();
            s.connect(new InetSocketAddress("192.168.42.122", 7979), 1000);
            System.out.println(s);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            String string="##,2B,359586015829802,'S',143050,12312015,0,0000000000,0000000000,000000,0000000,0000000,000,10,R,0,1,003.5,003.5,004.5,120.5,178.00,004.5,120.5,178.00;";
         //   dout.write("##,2A,123456789,1,1.5,1.5;".getBytes(),0,"##,2A,123456789,1,1.5,1.5;".getBytes().length);
            dout.write(string.getBytes(),0,string.getBytes().length);
            dout.flush();
            DataInputStream din = new DataInputStream(s.getInputStream());
            byte[] oj = new  byte[100];
            din.read(oj);

            System.out.println(new String(oj));
        }


    } catch (Exception e) {
        System.out.println(e);
    }
    }
}
