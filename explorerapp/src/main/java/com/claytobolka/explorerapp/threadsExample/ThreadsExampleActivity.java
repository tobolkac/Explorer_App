package com.claytobolka.explorerapp.threadsExample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.claytobolka.explorerapp.app.MainActivity;
import com.claytobolka.explorerapp.app.R;

import java.util.Random;


public class ThreadsExampleActivity extends Activity {

    private TextView threadText;

    private int threadCount = 0;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // get the bundle and extract data by key
            Bundle b = msg.getData();
            String key = b.getString("My Key");
            threadText.setText(threadText.getText() + "Item " + key +System.getProperty("line.separator"));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads_example);

        threadText = (TextView) findViewById(R.id.threadText);
        threadText.setMovementMethod(new ScrollingMovementMethod());
        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a new thread
                Thread background = new Thread(new Runnable() {

                    @Override
                    public void run() {

                        try {
                            Random ran = new Random();
                            int x = ran.nextInt(6) + 1;
                            Log.d("rand int", ""+x);
                            Thread.sleep(1000*x);
                            Message msg = new Message();
                            Bundle b = new Bundle();
                            b.putString("My Key", "My Value: " + String.valueOf(threadCount));
                            threadCount++;
                            msg.setData(b);
                            // send message to the handler with the current message handler
                            handler.sendMessage(msg);
                        } catch (Exception e) {
                            Log.v("Error", e.toString());
                        }

                    }
                });

                background.start();

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.threads_example, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_home){
            Intent intent = new Intent(ThreadsExampleActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
