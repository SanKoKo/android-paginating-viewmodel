package world.hello.san.stackoverflowproject.util;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import java.util.List;

import world.hello.san.stackoverflowproject.model.Item;

public class QuestionDiff extends DiffUtil.ItemCallback<Item>{


    @Override
    public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
        return oldItem.getQuestionId().equals(newItem.getQuestionId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
        return oldItem.equals(newItem);
    }
}

