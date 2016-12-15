package com.example.ivan.lab7_services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.widget.Toast;

/**
 * Created by ivan on 10/25/16.
 */

public class receiver_alarm extends BroadcastReceiver {
    public receiver_alarm(){}
    public void onReceive(Context arg0, Intent arg1) {
        CharSequence intentData = arg1.getCharSequenceExtra("time");
        if(intentData.toString().isEmpty()){
            Toast.makeText(arg0,"Please type in a number in Miliseconds",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(arg0, "Ivan Diaz alarm for  " + intentData + "ms", Toast.LENGTH_LONG).show();
            ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM,
                    100);
            toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD,
                    Integer.parseInt(intentData.toString())); //The intent holds the duration grabbed by editText
        }
    }
}
