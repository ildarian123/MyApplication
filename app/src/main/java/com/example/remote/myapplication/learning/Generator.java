package com.example.remote.myapplication.learning;

public class Generator {

    private Callback callback;

    public Generator(Callback callback) {
        this.callback = callback;
    }

    public void startGenerationAsync() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                callback.finishedGeneration("Acync generation finished");
            }
        }).start();

    }

    public String startGenerationSync() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Sync generation finished";
    }


}

