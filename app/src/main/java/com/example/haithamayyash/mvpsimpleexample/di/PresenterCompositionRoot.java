package com.example.haithamayyash.mvpsimpleexample.di;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.haithamayyash.mvpsimpleexample.ApiInterface;
import com.example.haithamayyash.mvpsimpleexample.question_detail.view.QuestionDetailsViewMvp;
import com.example.haithamayyash.mvpsimpleexample.question_detail.view.QuestionDetailsViewMvpImpl;
import com.example.haithamayyash.mvpsimpleexample.question_list.FetchQuestionsUseCase;
import com.example.haithamayyash.mvpsimpleexample.question_list.view.QuestionListViewMvp;
import com.example.haithamayyash.mvpsimpleexample.question_list.view.QuestionListViewMvpImpl;

public class PresenterCompositionRoot {
    private final CompositionRoot compositionRoot;
    private final Activity activity;

    public PresenterCompositionRoot(CompositionRoot compositionRoot, Activity activity) {
        this.compositionRoot = compositionRoot;
        this.activity = activity;
    }

    private ApiInterface getApiInterface() {
        return compositionRoot.getApiInterface();
    }

    public FetchQuestionsUseCase getFetchQuestionUseCase() {
        return new FetchQuestionsUseCase(getApiInterface());
    }

    public QuestionListViewMvp getQuestionListViewMvc(ViewGroup parent) {
        return new QuestionListViewMvpImpl(LayoutInflater.from(activity)
                , parent);
    }

    public QuestionDetailsViewMvp getQuestionDetailsViewMvp(ViewGroup parent) {
        return new QuestionDetailsViewMvpImpl(LayoutInflater.from(activity), null);
    }
}
