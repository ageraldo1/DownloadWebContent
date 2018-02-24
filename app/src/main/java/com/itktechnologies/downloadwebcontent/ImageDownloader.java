package com.itktechnologies.downloadwebcontent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Alexandre on 2/24/2018.
 */

public class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
    // pre-run-pos

    @Override
    protected Bitmap doInBackground(String... urls) {
        Bitmap img = null;
        URL url = null;
        HttpURLConnection urlConnection = null;

        try {
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            InputStream in = urlConnection.getInputStream();

            img = BitmapFactory.decodeStream(in);

        } catch (MalformedURLException ue) {
            ue.printStackTrace();

        } catch ( IOException ie) {
            ie.printStackTrace();
        }

        return img;
    }
}
