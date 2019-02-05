package com.example.haithamayyash.mvpsimpleexample.question_list;

import android.support.v7.widget.RecyclerView;

import com.example.haithamayyash.mvpsimpleexample.databinding.QuestionListRowItemBinding;

public class QuestionListViewHolder extends RecyclerView.ViewHolder {
    public QuestionListRowItemBinding itemBinding;

    public QuestionListViewHolder(QuestionListRowItemBinding itemBinding) {
        super(itemBinding.getRoot());
        this.itemBinding = itemBinding;
    }
}
