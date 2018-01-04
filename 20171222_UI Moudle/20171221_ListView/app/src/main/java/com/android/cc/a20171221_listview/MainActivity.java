package com.android.cc.a20171221_listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private String[] name1 = { "cat", "dog", "elephant", "lion","monkey","tiger" };
    private int[] images = { R.drawable.cat, R.drawable.dog, R.drawable.elephant,
            R.drawable.lion ,R.drawable.monkey,R.drawable.tiger};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.mylist);
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name1.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("n1", name1[i]);
            item.put("img", images[i]);
            items.add(item);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, items,
                R.layout.simple_adapter, new String[] { "n1", "img" },
                new int[] { R.id.name1, R.id.header });
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View v, int position,long id) {
                TextView text=(TextView)v.findViewById(R.id.name1);
                Toast.makeText(getApplicationContext(),text.getText(), Toast.LENGTH_LONG).show();
            }
        });

    }

}