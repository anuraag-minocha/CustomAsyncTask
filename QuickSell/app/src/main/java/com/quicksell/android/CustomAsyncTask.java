package com.quicksell.android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/**
 * Created by Alienware on 08-06-2017.
 */

public abstract class CustomAsyncTask<Params,Progress,Result> {

    Result result;

    public abstract void onPreExecute();

    public abstract void onPostExecute(Result... result);

    public abstract Result doInBackground(Params... params);

    public void onProgressUpdate(Progress... progress){}

    public CustomAsyncTask(){
    }

    public void execute(final Params... params){

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {

                onPreExecute();

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        result = doInBackground(params);

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {

                                onPostExecute(result);
                            }
                        });

                    }
                }).start();

            }
        });
    }
}
