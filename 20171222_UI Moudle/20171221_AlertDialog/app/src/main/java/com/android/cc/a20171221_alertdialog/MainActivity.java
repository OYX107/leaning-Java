package com.android.cc.a20171221_alertdialog;


import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater mInflater = LayoutInflater.from(MainActivity.this);
        view = mInflater.inflate(R.layout.activity_main, null);
        final EditText edit_loginform_username = (EditText) view
                .findViewById(R.id.username);
        final EditText edit_loginform_password = (EditText) view
                .findViewById(R.id.password);
        builder.setView(view);
        builder.create().show();
    }
}
