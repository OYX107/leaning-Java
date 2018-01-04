package com.android.cc.a20171222_menu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        TextView textView = (TextView) findViewById(R.id.test);
        switch (item.getItemId()){
            case R.id.Size_ten:
                textView.setTextSize(10);
                break;
            case R.id.Size_sixteen:
                textView.setTextSize(16);
                break;
            case R.id.Size_twenty:
                textView.setTextSize(20);
                break;
            case R.id.action_simple:
                textView.setTextColor(Color.parseColor("#808080"));
                textView.setTextSize(13);
                break;
            case R.id.Color_black:
                textView.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.Color_red:
                textView.setTextColor(Color.parseColor("#ff0000"));

        }

        return super.onOptionsItemSelected(item);
    }
}
