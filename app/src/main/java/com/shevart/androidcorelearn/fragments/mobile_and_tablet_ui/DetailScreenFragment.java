package com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.SimpleItem;

import java.util.Locale;

public class DetailScreenFragment extends Fragment {
    private static final String ID_FORMAT_PATTERN = "Id: %d";

    private TextView tvSimpleItemId;
    private TextView tvSimpleItemTitle;
    private TextView tvSimpleItemDescription;

    public DetailScreenFragment() {
    }

    public static DetailScreenFragment getInstance(@NonNull SimpleItem item) {
        final DetailScreenFragment fragment = new DetailScreenFragment();
        final Bundle args = new Bundle();
        args.putParcelable(SimpleItem.class.getSimpleName(), item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_detail_screen, container, false);
        tvSimpleItemId = ((TextView) view.findViewById(R.id.tvSimpleItemId));
        tvSimpleItemTitle = ((TextView) view.findViewById(R.id.tvSimpleItemTitle));
        tvSimpleItemDescription = ((TextView) view.findViewById(R.id.tvSimpleItemDescription));
        SimpleItem item = getSimpleItemFromArguments();
        if (item != null)
            update(item);
        return view;
    }

    public void update(@NonNull SimpleItem item) {
        tvSimpleItemId.setText(String.format(Locale.ENGLISH, ID_FORMAT_PATTERN, item.getId()));
        tvSimpleItemTitle.setText(item.getTitle());
        tvSimpleItemDescription.setText(item.getDescription());
    }

    @Nullable
    private SimpleItem getSimpleItemFromArguments() {
        if (getArguments() != null)
            return getArguments().getParcelable(SimpleItem.class.getSimpleName());
        else
            return null;
    }
}