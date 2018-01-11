package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by helpingwithcode on 07/01/18.
 */

public class GetJokeAsync extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... voids) {
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                .setRootUrl("http://192.168.0.12:8080/_ah/api/")
                .setApplicationName("backend")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                        request.setDisableGZipContent(true);
                    }
                });
        MyApi myApi = builder.build();
        String mJoke = "";
        try{
            mJoke = myApi.getJoke().execute().getData();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return mJoke;
    }
}
