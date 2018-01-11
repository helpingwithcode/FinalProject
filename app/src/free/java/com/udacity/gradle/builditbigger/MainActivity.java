package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jokedisplayer.JokeDisplayerActivity;
import com.example.jokerandomprovider.JokeRandomProvider;


public class MainActivity extends AppCompatActivity {

    private ProgressBar loadingPb;
    private boolean loadingJoke = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadingPb = (ProgressBar) findViewById(R.id.pb_loading);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        if(loadingJoke)
            return;
        loadingJoke = true;
        loadingPb.setVisibility(View.VISIBLE);
        new GetJokeAsync(){
            @Override
            protected void onPostExecute(String s){
                loadingPb.setVisibility(View.INVISIBLE);
                if(s.isEmpty())
                    Toast.makeText(MainActivity.this, "no joke for you, error insued", Toast.LENGTH_SHORT).show();
                else
                    launchActivity(s);
                loadingJoke = false;
            }
        }.execute();
    }

    private void launchActivity(String s) {
        Log.e("Main", "launchActivty!");
        Intent jokeDisplayerIntent = new Intent(this, JokeDisplayerActivity.class);
        jokeDisplayerIntent.putExtra(Intent.EXTRA_TEXT, s);
        startActivity(jokeDisplayerIntent);
    }

    private String getJokeFromLibrary() {
        JokeRandomProvider jokeRandomProvider = new JokeRandomProvider();
        return jokeRandomProvider.getAJoke();
    }


}
