package com.shevart.androidcorelearn.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.utils.UiUtil;

@SuppressWarnings("WeakerAccess")
public class SimpleItemsRVAdapter extends RecyclerView.Adapter<SimpleItemsRVAdapter.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(UiUtil.inflate(parent, R.layout.item_simple_rv));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }


}
