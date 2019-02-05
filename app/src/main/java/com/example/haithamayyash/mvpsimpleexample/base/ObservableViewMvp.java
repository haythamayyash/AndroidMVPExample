package com.example.haithamayyash.mvpsimpleexample.base;

public interface ObservableViewMvp<ListenerType> extends ViewMvp {
    void registerListener(ListenerType listener);

    void unRegisterListener(ListenerType listener);
}
