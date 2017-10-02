package com.shevart.androidcorelearn.fragments.transactions_samples;

import android.os.Bundle;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;

public class FragmentTransactionsActivity extends AbsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_transactions);
        enableToolbarBackButton();
    }
}