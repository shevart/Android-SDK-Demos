package com.shevart.androidcorelearn.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.fragments.commits_samples.CommitsSampleHostActivity;
import com.shevart.androidcorelearn.fragments.mobile_and_tablet_ui.MobileAndTabletUIFragmentsDemoActivity;
import com.shevart.androidcorelearn.fragments.transactions_samples.FragmentTransactionsActivity;

public class FragmentsDemoActivity extends AppCompatActivity {
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btMobileAndTabletFragmentsUi:
                    startActivity(new Intent(FragmentsDemoActivity.this, MobileAndTabletUIFragmentsDemoActivity.class));
                    break;
                case R.id.btCommitsSample:
                    startActivity(new Intent(FragmentsDemoActivity.this, CommitsSampleHostActivity.class));
                    break;
                case R.id.btTransactionsSample:
                    startActivity(new Intent(FragmentsDemoActivity.this, FragmentTransactionsActivity.class));
                    break;
                default:
                    throw new IllegalArgumentException("Check it!");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_demo);
        findViewById(R.id.btMobileAndTabletFragmentsUi).setOnClickListener(clickListener);
        findViewById(R.id.btCommitsSample).setOnClickListener(clickListener);
        findViewById(R.id.btTransactionsSample).setOnClickListener(clickListener);
    }
}