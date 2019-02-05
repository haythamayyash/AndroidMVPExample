package com.example.haithamayyash.mvpsimpleexample.question_list.view;

import com.example.haithamayyash.mvpsimpleexample.base.ObservableViewMvp;
import com.example.haithamayyash.mvpsimpleexample.question_list.model.Question;

import java.util.List;

public interface QuestionListViewMvp extends ObservableViewMvp<QuestionListViewMvp.Listener> {
    interface Listener {
        void onQuestionClicked(Question question);
    }

    void bindQuestions(List<Question> questionList);

    void showProgressBar();

    void hideProgressBar();
}
