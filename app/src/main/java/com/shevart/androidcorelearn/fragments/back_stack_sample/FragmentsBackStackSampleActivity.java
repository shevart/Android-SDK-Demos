package com.shevart.androidcorelearn.fragments.back_stack_sample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.utils.LogUtil;

import java.util.Locale;

public class FragmentsBackStackSampleActivity extends AbsActivity {
    private static final String BACK_STACK_COUNT_PATTERN = "Back stack count: %d";
    private TextView tvBackStackState;
    private View.OnClickListener buttonsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btPutNewFragment:

                    break;
                case R.id.btRemoveByBackStackName:

                    break;
                default:
                    throw new IllegalArgumentException("Check it!");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_back_stack_sample);
        enableToolbarBackButton();

        tvBackStackState = (TextView) findViewById(R.id.tvBackStackState);
        findViewById(R.id.btPutNewFragment).setOnClickListener(buttonsClickListener);
        findViewById(R.id.btRemoveByBackStackName).setOnClickListener(buttonsClickListener);
        updateBackStackDisplay();
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                LogUtil.e("onBackStackChanged()");
                updateBackStackDisplay();
            }
        });
    }

    private void updateBackStackDisplay() {
        tvBackStackState.setText(String.format(Locale.ENGLISH, BACK_STACK_COUNT_PATTERN,
                getSupportFragmentManager().getBackStackEntryCount()));
    }
}