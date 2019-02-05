package com.example.haithamayyash.mvpsimpleexample.question_detail.view;

import com.example.haithamayyash.mvpsimpleexample.base.ViewMvp;
import com.example.haithamayyash.mvpsimpleexample.question_list.model.Question;

public interface QuestionDetailsViewMvp extends ViewMvp {
    void bindQuestionDetails(Question question);
}
