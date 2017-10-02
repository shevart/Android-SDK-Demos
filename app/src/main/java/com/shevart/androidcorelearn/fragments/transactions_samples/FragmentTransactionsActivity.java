package com.shevart.androidcorelearn.fragments.transactions_samples;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.shevart.androidcorelearn.R;
import com.shevart.androidcorelearn.common.AbsActivity;
import com.shevart.androidcorelearn.utils.FragmentUtil;
import com.shevart.androidcorelearn.utils.LogUtil;
import com.shevart.androidcorelearn.utils.UiNotificationsUtils;

import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Queue;

import static com.shevart.androidcorelearn.utils.UiScreenMockUtils.nextDetailSimpleItemFragment;

public class FragmentTransactionsActivity extends AbsActivity {
    private static final String BACK_STACK_COUNT_PATTERN = "Back stack count: %d";
    private CheckBox cbAddToBackStack;
    private TextView tvBackStackState;
    private Queue<Fragment> fragmentQueue = new ArrayDeque<>();
    private View.OnClickListener buttonsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btAdd:
                    add(obtainFragment(), cbAddToBackStack.isChecked());
                    break;
                case R.id.btReplace:
                    replace(obtainFragment(), cbAddToBackStack.isChecked());
                    break;
                case R.id.btRemove:
                    remove(fragmentQueue.poll(), cbAddToBackStack.isChecked());
                    break;
                default:
                    throw new RuntimeException("Check it!");
            }
        }
    };

    private Fragment obtainFragment() {
        Fragment fragment = nextDetailSimpleItemFragment();
        fragmentQueue.add(fragment);
        return fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_transactions);
        enableToolbarBackButton();

        cbAddToBackStack = (CheckBox) findViewById(R.id.cbAddToBackStack);
        tvBackStackState = (TextView) findViewById(R.id.tvBackStackState);
        findViewById(R.id.btAdd).setOnClickListener(buttonsClickListener);
        findViewById(R.id.btReplace).setOnClickListener(buttonsClickListener);
        findViewById(R.id.btRemove).setOnClickListener(buttonsClickListener);

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

    private void add(@NonNull Fragment fragment, boolean backStack) {
        FragmentUtil
                .addFragment(getSupportFragmentManager(), fragment, R.id.flTransactionsContainer, backStack);
    }

    private void replace(@NonNull Fragment fragment, boolean backStack) {
        FragmentUtil
                .replaceFragment(getSupportFragmentManager(), fragment, R.id.flTransactionsContainer, backStack);
    }

    private void remove(@Nullable Fragment fragment, boolean backStack) {
        if (fragment != null)
            FragmentUtil.removeFragment(getSupportFragmentManager(), fragment, backStack);
        else
            UiNotificationsUtils.showDevMessage(this, "There is no fragments!");
    }
}