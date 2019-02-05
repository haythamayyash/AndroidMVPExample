package com.example.haithamayyash.mvpsimpleexample;

import com.example.haithamayyash.mvpsimpleexample.question_list.model.QuestionResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow")
    Call<QuestionResponse> getQuestionList();
}
