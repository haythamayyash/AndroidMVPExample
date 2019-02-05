package com.example.haithamayyash.mvpsimpleexample.question_detail.view;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haithamayyash.mvpsimpleexample.R;
import com.example.haithamayyash.mvpsimpleexample.databinding.ActivityQuestionDetailsBinding;
import com.example.haithamayyash.mvpsimpleexample.question_list.model.Question;

public class QuestionDetailsViewMvpImpl implements QuestionDetailsViewMvp {
    ActivityQuestionDetailsBinding itemBinding;

    public QuestionDetailsViewMvpImpl(LayoutInflater inflater, ViewGroup parent) {
        itemBinding = DataBindingUtil.inflate(inflater, R.layout.activity_question_details
                , parent, false);
    }

    @Override
    public View getView() {
        return itemBinding.getRoot();
    }

    @Override
    public void bindQuestionDetails(Question question) {
        itemBinding.setQuesiton(question);
    }
}
