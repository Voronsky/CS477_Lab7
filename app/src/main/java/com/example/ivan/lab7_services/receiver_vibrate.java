package com.example.ivan.lab7_services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

/**
 * Created by ivan on 10/25/16.
 */

public class receiver_vibrate extends BroadcastReceiver {
    public receiver_vibrate(){

    }

    @Override
    public void onReceive(Context arg0, Intent arg1){
            CharSequence intentData = arg1.getCharSequenceExtra("time");
        if(intentData.toString().isEmpty()){
            Toast.makeText(arg0,"Please make sure you've typed in a number",Toast.LENGTH_SHORT).show();
        }else {
            try {
                Toast.makeText(arg0, "Ivan Diaz, idiaz3, G00711429 time: " + intentData, Toast.LENGTH_SHORT).show();
                Vibrator vibrator = (Vibrator) arg0.getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(Integer.parseInt(intentData.toString())); //Vibrate for 1000 miliseconds?
            } catch (Exception e) {
                Toast.makeText(arg0, "Please make sure you've typed in a number", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
