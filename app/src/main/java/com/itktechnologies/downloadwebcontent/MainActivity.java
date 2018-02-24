package com.itktechnologies.downloadwebcontent;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    public void sampleDownloadMethod() {
        String result=null;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cmdImage(View v) {

        Bitmap sourceImg;
        img = (ImageView) findViewById(R.id.img);

        ImageDownloader task = new ImageDownloader();
        try {
            sourceImg = task.execute("https://vignette.wikia.nocookie.net/youtubepoop/images/e/eb/Homer-simpson_WOOHOO.jpg/revision/latest?cb=20130120090101").get();
            img.setImageBitmap(sourceImg);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
