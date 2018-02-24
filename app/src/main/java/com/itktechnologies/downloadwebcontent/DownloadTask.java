package com.itktechnologies.downloadwebcontent;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Alexandre on 2/24/2018.
 */

public class DownloadTask extends AsyncTask<String, Void, String> {

    /*  param1 - URL
        param2 - Progress
        param3 - URL Content
     */


    @Override
    protected String doInBackground(String... urls) {
        String result = null;

        URL url = null;
        HttpURLConnection urlConnection = null;

        try {
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader reader = new InputStreamReader(in);

            int data = reader.read();



            while ( data != -1) {
                char current =(char) data;
                result += current;

                data = reader.read();
            }

        } catch (MalformedURLException ue) {
            ue.printStackTrace();
            return "MalformedURLException exception";

        } catch ( IOException ie) {
            ie.printStackTrace();
            return "IOException exception";
        }

        return result;
    }
}
