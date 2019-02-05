package com.example.haithamayyash.mvpsimpleexample.question_list.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.haithamayyash.mvpsimpleexample.base.BaseActivity;
import com.example.haithamayyash.mvpsimpleexample.question_detail.presenter.QuestionDetailsActivity;
import com.example.haithamayyash.mvpsimpleexample.question_list.FetchQuestionsUseCase;
import com.example.haithamayyash.mvpsimpleexample.question_list.QuestionListAdapter;
import com.example.haithamayyash.mvpsimpleexample.question_list.model.Question;
import com.example.haithamayyash.mvpsimpleexample.question_list.view.QuestionListViewMvp;

import java.util.List;

public class MainActivity extends BaseActivity implements QuestionListAdapter.OnQuestionClickListener, QuestionListViewMvp.Listener, FetchQuestionsUseCase.Listener {
    QuestionListViewMvp questionListViewMvc;
    FetchQuestionsUseCase fetchQuestionsUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questionListViewMvc = getCompositionRoot(this).getQuestionListViewMvc(null);
        setContentView(questionListViewMvc.getView());
        questionListViewMvc.showProgressBar();

        fetchQuestionsUseCase = getCompositionRoot(this).getFetchQuestionUseCase();
        fetchQuestionsUseCase.fetchQuestionsAndNotify();
    }

    @Override
    protected void onStart() {
        super.onStart();
        questionListViewMvc.registerListener(this);
        fetchQuestionsUseCase.registerListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        questionListViewMvc.unRegisterListener(this);
        fetchQuestionsUseCase.unRegisterListener(this);
    }

    @Override
    public void onQuestionClicked(Question question) {
        Intent intent = new Intent(this, QuestionDetailsActivity.class);
        intent.putExtra("question", question);
        startActivity(intent);
    }

    @Override
    public void notifySuccess(List<Question> questionList) {
        questionListViewMvc.bindQuestions(questionList);
        questionListViewMvc.hideProgressBar();

    }

    @Override
    public void notifyFailure(String failureMessage) {
        questionListViewMvc.hideProgressBar();
        Toast.makeText(MainActivity.this, failureMessage, Toast.LENGTH_SHORT).show();
    }
}
