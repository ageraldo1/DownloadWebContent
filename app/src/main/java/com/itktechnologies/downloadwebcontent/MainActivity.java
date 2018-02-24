package com.itktechnologies.downloadwebcontent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String result=null;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask task = new DownloadTask();

        try {
            result = task.execute("https://www.ecowebhosting.co.uk", "http://www.google.com").get();

        } catch (InterruptedException ie) {
            ie.printStackTrace();

        } catch (ExecutionException ee) {
            ee.printStackTrace();
        }

        Log.i ("Result", result);

    }
}
