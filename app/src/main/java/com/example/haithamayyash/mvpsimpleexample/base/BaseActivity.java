package com.example.haithamayyash.mvpsimpleexample.base;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.example.haithamayyash.mvpsimpleexample.App;
import com.example.haithamayyash.mvpsimpleexample.di.PresenterCompositionRoot;

public class BaseActivity extends AppCompatActivity {
    private PresenterCompositionRoot presenterCompositionRoot;

    public PresenterCompositionRoot getCompositionRoot(Activity activity) {
        if (presenterCompositionRoot == null) {
            return presenterCompositionRoot = new PresenterCompositionRoot(((App) getApplication())
                    .getCompositionRoot(), activity);
        } else {
            return presenterCompositionRoot;
        }
    }
}
