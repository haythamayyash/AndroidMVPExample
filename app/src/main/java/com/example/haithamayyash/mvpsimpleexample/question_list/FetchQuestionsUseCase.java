package com.example.haithamayyash.mvpsimpleexample.question_list;

import com.example.haithamayyash.mvpsimpleexample.ApiInterface;
import com.example.haithamayyash.mvpsimpleexample.base.BaseObservable;
import com.example.haithamayyash.mvpsimpleexample.question_list.model.Question;
import com.example.haithamayyash.mvpsimpleexample.question_list.model.QuestionResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchQuestionsUseCase extends BaseObservable<FetchQuestionsUseCase.Listener> {
    public interface Listener {
        void notifySuccess(List<Question> questionList);

        void notifyFailure(String failureMessage);
    }

    private final ApiInterface apiInterface;

    public FetchQuestionsUseCase(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public void fetchQuestionsAndNotify() {
        apiInterface.getQuestionList().enqueue(new Callback<QuestionResponse>() {
            @Override
            public void onResponse(Call<QuestionResponse> call, Response<QuestionResponse> questionResponse) {
                for (Listener listener : getListeners()) {
                    listener.notifySuccess(questionResponse.body().getQuestions());
                }
            }

            @Override
            public void onFailure(Call<QuestionResponse> call, Throwable t) {
                for (Listener listener : getListeners()) {
                    listener.notifyFailure(t.getMessage());
                }
            }
        });
    }
}
