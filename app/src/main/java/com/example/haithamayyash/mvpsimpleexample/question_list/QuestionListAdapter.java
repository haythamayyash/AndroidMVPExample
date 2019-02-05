package com.example.haithamayyash.mvpsimpleexample.question_list;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.haithamayyash.mvpsimpleexample.R;
import com.example.haithamayyash.mvpsimpleexample.databinding.QuestionListRowItemBinding;
import com.example.haithamayyash.mvpsimpleexample.question_list.model.Question;

import java.util.List;

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListViewHolder> {
    private Context context;
    private List<Question> questionList;
    private QuestionListRowItemBinding itemBinding;
    private OnQuestionClickListener onQuestionClickListener;

    public interface OnQuestionClickListener {
        void onQuestionClicked(Question question);
    }

    public QuestionListAdapter(Context context, OnQuestionClickListener onQuestionClickListener
            , List<Question> questionList) {
        this.context = context;
        this.questionList = questionList;
        this.onQuestionClickListener = onQuestionClickListener;
    }

    @Override
    public QuestionListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context)
                , R.layout.question_list_row_item, parent, false);
        return new QuestionListViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(QuestionListViewHolder holder, int position) {
        Question question = questionList.get(position);
        holder.itemBinding.setQuestion(question);
        holder.itemBinding.listItem.setOnClickListener(view -> {
            onQuestionClickListener.onQuestionClicked(question);
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
}
