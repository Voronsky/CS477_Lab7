package com.example.ivan.lab7_services;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer player;
    EditText timeInput;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeInput = (EditText)findViewById(R.id.getTimeInput);
        final Button button = (Button) findViewById(R.id.buttonStart);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View src) {
                try {
                    broadcastCustomIntent1(src);
                    startService(new Intent(MainActivity.this,
                            MusicService.class));
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Please type in a number in Miliseconds",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        final Button button2 = (Button) findViewById(R.id.buttonStart2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View src) {
                player = MediaPlayer.create(MainActivity.this,
                        R.raw.braincandy);
                player.setLooping(false);
                player.start();
            }
        });

        final Button alarmBtn = (Button)findViewById(R.id.alarmBtn);
        alarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    broadcastCustomIntent2(v);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Please type in a number in Miliseconds",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /**
     * This is the static call
     * @param view
     */
    public void broadcastCustomIntent1(View view)    // static
    {
        Intent intent = new Intent("MyCustomIntent");
        // add data to the Intent
        intent.putExtra("time", (CharSequence)timeInput.getText().toString());
        intent.setAction("broadcast_vibrate_RECEIVER_customIntent1");
        sendBroadcast(intent);
    }

    public void broadcastCustomIntent2(View view)    // dynamic
    {
        Intent intent = new Intent("MyCustomIntent");
        // add data to the Intent
        intent.putExtra("time", (CharSequence)timeInput.getText().toString());
        intent.setAction("broadcast_alarm_RECEIVER_customIntent2");
        sendBroadcast(intent);
    }


    @Override
    public void onPause() {
        if (player != null) player.stop();
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
