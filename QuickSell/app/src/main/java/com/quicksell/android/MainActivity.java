package com.quicksell.android;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MyBackgroundTask().execute();
    }

    public class MyBackgroundTask extends CustomAsyncTask {

        @Override
        public void onPreExecute() {
            Toast.makeText(MainActivity.this,"Pre execute",Toast.LENGTH_SHORT).show();
            Log.d(getClass().getSimpleName(),"pre execute");
        }

        @Override
        public void onPostExecute(Object[] result) {
            Toast.makeText(MainActivity.this,"Post execute",Toast.LENGTH_SHORT).show();
            Log.d(getClass().getSimpleName(),"post execute");
        }

        @Override
        public Object doInBackground(Object[] params) {

            Log.d(getClass().getSimpleName(),"do in background");
            return null;
        }

    }
}
