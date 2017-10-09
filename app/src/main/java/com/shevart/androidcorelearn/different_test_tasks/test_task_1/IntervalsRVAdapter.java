package com.shevart.androidcorelearn.different_test_tasks.test_task_1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.Interval;

import java.util.ArrayList;
import java.util.List;

class IntervalsRVAdapter extends RecyclerView.Adapter<IntervalsRVAdapter.ViewHolder> {
    private List<Interval> intervals = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_prime_number, parent));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return intervals.size();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
