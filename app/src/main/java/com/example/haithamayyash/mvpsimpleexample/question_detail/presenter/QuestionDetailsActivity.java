package com.example.haithamayyash.mvpsimpleexample.question_detail.presenter;

import android.os.Bundle;

import com.example.haithamayyash.mvpsimpleexample.base.BaseActivity;
import com.example.haithamayyash.mvpsimpleexample.question_detail.view.QuestionDetailsViewMvp;
import com.example.haithamayyash.mvpsimpleexample.question_list.model.Question;

public class QuestionDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QuestionDetailsViewMvp questionDetailsViewMvc =
                getCompositionRoot(this).getQuestionDetailsViewMvp(null);
        setContentView(questionDetailsViewMvc.getView());
        Question question = getIntent().getParcelableExtra("question");
        questionDetailsViewMvc.bindQuestionDetails(question);
    }
}
