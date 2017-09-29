package com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shevart.androidcorelearn.R;

public class DetailScreenFragment extends Fragment {
    public DetailScreenFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_screen, container, false);
    }
}