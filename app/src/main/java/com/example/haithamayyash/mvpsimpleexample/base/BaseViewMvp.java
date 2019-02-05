package com.example.haithamayyash.mvpsimpleexample.base;

import android.content.Context;
import android.view.View;

public abstract class BaseViewMvp implements ViewMvp {
    private View view;

    protected void setView(View view) {
        this.view = view;
    }

    @Override
    public View getView() {
        return view;
    }

    protected Context getContext() {
        return view.getContext();
    }
}
