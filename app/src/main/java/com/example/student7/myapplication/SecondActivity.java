package com.example.student7.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends ActionBarActivity {

    private EditText wwwView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle intentExtras = getIntent().getExtras();
        String username = intentExtras.getString("username");
        TextView helloView = (TextView) findViewById(R.id.hello);
        helloView.setText("Witaj " + username + "!");
        wwwView = (EditText) findViewById(R.id.url);

    }

    public void openClicked(View view) {
        String url = wwwView.getText().toString();
        if (!url.startsWith("http://")) {
            url = "http://" + url;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
