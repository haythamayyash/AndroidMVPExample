package com.example.haithamayyash.mvpsimpleexample.base;

import java.util.ArrayList;
import java.util.List;

public class BaseObservable<ListenerType> {
    private List<ListenerType> listeners = new ArrayList<>();

    public void registerListener(ListenerType listenerType) {
        listeners.add(listenerType);
    }

    public void unRegisterListener(ListenerType listenerType) {
        listeners.remove(listenerType);
    }

    protected List<ListenerType> getListeners() {
        return listeners;
    }

}
