package com.example.jokedisplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayerActivity extends AppCompatActivity {

    TextView jokeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_displayer);
        parseIntent();
    }

    public void parseIntent() {
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra(Intent.EXTRA_TEXT))
            return;
        jokeTv = (TextView) findViewById(R.id.tv_joke);
        jokeTv.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
    }
}
