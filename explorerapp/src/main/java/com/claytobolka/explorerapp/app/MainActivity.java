package com.claytobolka.explorerapp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.claytobolka.explorerapp.navigaitondrawer.NavigationDrawerActivity;
import com.claytobolka.explorerapp.progressbar.ProgessBarWithRunnableActivity;

public class MainActivity extends Activity {

    String[] arr = {"Navigation Drawer Example", "Progress Bar with Runnable"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView l = (ListView) findViewById(R.id.mainListView);
        l.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , arr));

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0)
            {
                Intent intent = new Intent(MainActivity.this, NavigationDrawerActivity.class);
                startActivity(intent);
            }
            if (position == 1)
            {
                Intent intent = new Intent(MainActivity.this, ProgessBarWithRunnableActivity.class);
                startActivity(intent);
            }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        return super.onOptionsItemSelected(item);
    }

}
