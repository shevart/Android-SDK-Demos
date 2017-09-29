package com.shevart.androidcorelearn.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.utils.UiUtil;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class SimpleItemsRVAdapter extends RecyclerView.Adapter<SimpleItemsRVAdapter.ViewHolder> {
    private List<SimpleItem> items = new ArrayList<>();
    private OnSimpleItemSelectedListener simpleItemSelectedListener;

    public SimpleItemsRVAdapter(@NonNull OnSimpleItemSelectedListener listener,
                                @NonNull List<SimpleItem> items) {
        simpleItemSelectedListener = listener;
        update(items);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(UiUtil.inflate(parent, R.layout.item_simple_rv));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        SimpleItem item = items.get(position);
        holder.tvSimpleItem.setText(item.getTitle());
        holder.tvSimpleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleItemSelectedListener.onSimpleItemSelected(
                        items.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void update(@NonNull List<SimpleItem> newItems) {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvSimpleItem;

        public ViewHolder(View itemView) {
            super(itemView);
            tvSimpleItem = (TextView) itemView.findViewById(R.id.tvSimpleItem);
        }
    }

    public interface OnSimpleItemSelectedListener {
        void onSimpleItemSelected(@NonNull SimpleItem simpleItem);
    }
}