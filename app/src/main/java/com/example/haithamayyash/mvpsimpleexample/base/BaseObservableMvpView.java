package com.example.haithamayyash.mvpsimpleexample.base;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseObservableMvpView<ListenerType> extends BaseViewMvp
        implements ObservableViewMvp<ListenerType> {
    private List<ListenerType> listeners = new ArrayList<>();

    @Override
    public void registerListener(ListenerType listener) {
        listeners.add(listener);
    }

    @Override
    public void unRegisterListener(ListenerType listener) {
        listeners.remove(listener);
    }

    protected List<ListenerType> getListeners() {
        return listeners;
    }
}
