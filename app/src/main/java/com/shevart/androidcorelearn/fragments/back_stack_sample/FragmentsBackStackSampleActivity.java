package com.shevart.androidcorelearn.fragments.back_stack_sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.common.ShortTextWatcher;
import com.shevart.androidcorelearn.utils.LogUtil;
import com.shevart.androidcorelearn.utils.UiScreenMockUtils;

import java.util.Locale;

import static android.support.v4.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

public class FragmentsBackStackSampleActivity extends AbsActivity {
    private static final String BACK_STACK_COUNT_PATTERN = "Back stack count: %d";
    private TextView tvBackStackState;
    private TextView tvButtonsEnableState;
    private EditText etBackStackName;
    private Button btPutNewFragment;
    private Button btRemoveByBackStackName;
    private CheckBox cbPopInclusive;
    private View.OnClickListener buttonsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btPutNewFragment:
                    putNewFragment(UiScreenMockUtils.nextDetailSimpleItemFragment(), etBackStackName.getText().toString());
                    break;
                case R.id.btRemoveByBackStackName:
                    removeByBackStackName(etBackStackName.getText().toString(), cbPopInclusive.isChecked());
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
        tvButtonsEnableState = (TextView) findViewById(R.id.tvButtonsEnableState);
        etBackStackName = (EditText) findViewById(R.id.etBackStackName);
        etBackStackName.addTextChangedListener(new ShortTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                updateButtonsEnableState(s.length() != 0);
            }
        });
        btPutNewFragment = (Button) findViewById(R.id.btPutNewFragment);
        btRemoveByBackStackName = (Button) findViewById(R.id.btRemoveByBackStackName);
        btRemoveByBackStackName.setOnClickListener(buttonsClickListener);
        btPutNewFragment.setOnClickListener(buttonsClickListener);
        cbPopInclusive = (CheckBox) findViewById(R.id.cbPopInclusive);
        updateButtonsEnableState(false);
        updateBackStackDisplay();
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                LogUtil.e("onBackStackChanged()");
                updateBackStackDisplay();
            }
        });
    }

    private void updateButtonsEnableState(boolean enable) {
        btPutNewFragment.setEnabled(enable);
        btRemoveByBackStackName.setEnabled(enable);
        tvButtonsEnableState.setVisibility(enable ? View.INVISIBLE : View.VISIBLE);
    }

    private void putNewFragment(@NonNull Fragment fragment, @NonNull String backStackName) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flBackStackContainer, fragment)
                .addToBackStack(backStackName)
                .commit();
    }

    private void updateBackStackDisplay() {
        tvBackStackState.setText(String.format(Locale.ENGLISH, BACK_STACK_COUNT_PATTERN,
                getSupportFragmentManager().getBackStackEntryCount()));
    }

    private void removeByBackStackName(@NonNull String backStackName, boolean isPopBackStackInclusive) {
        getSupportFragmentManager().popBackStack(backStackName,
                isPopBackStackInclusive ? POP_BACK_STACK_INCLUSIVE : 0);
    }
}