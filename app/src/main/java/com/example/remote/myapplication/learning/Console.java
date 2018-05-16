package com.example.remote.myapplication.learning;

import android.util.Log;

public class Console implements Callback {

    private Generator generator;

    public Console() {
        generator = new Generator(this);
        startOutput();
    }

    private void startOutput() {
        Log.d("asdasdasdasd", "tic:" + 1);
        Log.d("asdasdasdasd", "tic:" + 2);
        Log.d("asdasdasdasd", "tic:" + 3);
        Log.d("asdasdasdasd", "tic:" + 4);
        Log.d("asdasdasdasd", "tic:" + 5);

        Log.d("asdasdasdasd", "result: " + generator.startGenerationSync());
        generator.startGenerationAsync();

        Log.d("asdasdasdasd", "tic:" + 6);
        Log.d("asdasdasdasd", "tic:" + 7);
        Log.d("asdasdasdasd", "tic:" + 8);
        Log.d("asdasdasdasd", "tic:" + 9);


    }


    @Override
    public void finishedGeneration(String result) {
        Log.d("asdasdasdasd", "result: " + result);
    }
}
