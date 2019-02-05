package com.example.haithamayyash.mvpsimpleexample;

import android.app.Application;

import com.example.haithamayyash.mvpsimpleexample.di.CompositionRoot;

public class App extends Application {
    private CompositionRoot compositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        compositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return compositionRoot;
    }
}
