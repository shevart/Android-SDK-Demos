package com.shevart.androidcorelearn.arch_components;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.arch_components.viewmodel.SimpleViewModelSampleActivity;
import com.shevart.androidcorelearn.common.AbsActivity;

public class ArchComponentsActivity extends AbsActivity {
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btViewModelTopic:
                    startActivity(new Intent(ArchComponentsActivity.this, SimpleViewModelSampleActivity.class));
                    break;
                default:
                    throw new IllegalArgumentException("Check it!");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arch_components);
        enableToolbarBackButton();

        findViewById(R.id.btViewModelTopic).setOnClickListener(clickListener);
    }
}