package com.example.haithamayyash.mvpsimpleexample.question_list.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haithamayyash.mvpsimpleexample.R;
import com.example.haithamayyash.mvpsimpleexample.base.BaseObservableMvpView;
import com.example.haithamayyash.mvpsimpleexample.databinding.ActivityMainBinding;
import com.example.haithamayyash.mvpsimpleexample.question_list.model.Question;
import com.example.haithamayyash.mvpsimpleexample.question_list.QuestionListAdapter;

import java.util.List;

public class QuestionListViewMvpImpl extends BaseObservableMvpView<QuestionListViewMvp.Listener>
        implements QuestionListAdapter.OnQuestionClickListener, QuestionListViewMvp {

    private ActivityMainBinding binding;
    private List<Question> questionList;

    public QuestionListViewMvpImpl(LayoutInflater inflater, ViewGroup parent) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_main, parent, false);
        setView(binding.getRoot());
        binding.progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onQuestionClicked(Question question) {
        for (Listener listener : getListeners()) {
            listener.onQuestionClicked(question);
        }
    }

    @Override
    public void bindQuestions(List<Question> questionList) {
        this.questionList = questionList;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext()
                , LinearLayoutManager.VERTICAL, false);
        QuestionListAdapter questionListAdapter = new QuestionListAdapter(getContext()
                , this, questionList);
        binding.recyclerViewQuestionList.setAdapter(questionListAdapter);
        binding.recyclerViewQuestionList.setLayoutManager(layoutManager);
    }

    @Override
    public void showProgressBar() {
        binding.progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        binding.progressbar.setVisibility(View.GONE);
    }

}
