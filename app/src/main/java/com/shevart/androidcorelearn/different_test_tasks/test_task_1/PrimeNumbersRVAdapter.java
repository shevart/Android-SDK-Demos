package com.shevart.androidcorelearn.different_test_tasks.test_task_1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.different_test_tasks.test_task_1.model.PrimeNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SuppressWarnings("unused")
class PrimeNumbersRVAdapter extends RecyclerView.Adapter<PrimeNumbersRVAdapter.ViewHolder> {
    private List<PrimeNumber> items = new ArrayList<>();
    private final String THREAD_ID_PATTERN;
    private final String PRIME_NUMBER_PATTERN;

    PrimeNumbersRVAdapter(@NonNull Context context) {
        THREAD_ID_PATTERN = context.getString(R.string.thread_number_pattern);
        PRIME_NUMBER_PATTERN = context.getString(R.string.prime_number_generated_pattern);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_prime_number, parent));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PrimeNumber number = items.get(position);
        holder.tvThreadId.setText(formatThreadID(number.getThreadId()));
        holder.tvThreadPrimeNumber.setText(formatPrimeNumber(number.getPrimeNumber()));
    }

    private String formatThreadID(int threadId) {
        return String.format(Locale.ENGLISH, THREAD_ID_PATTERN, threadId);
    }

    private String formatPrimeNumber(int primeNumber) {
        return String.format(Locale.ENGLISH, PRIME_NUMBER_PATTERN, primeNumber);
    }

    public void updateItems(@NonNull List<PrimeNumber> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void addItem(@NonNull PrimeNumber number) {
        this.items.add(number);
        notifyItemInserted(items.size());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvThreadId;
        final TextView tvThreadPrimeNumber;
        ViewHolder(View itemView) {
            super(itemView);
            tvThreadId = (TextView) itemView.findViewById(R.id.tvThreadId);
            tvThreadPrimeNumber = (TextView) itemView.findViewById(R.id.tvThreadPrimeNumber);
        }
    }
}
