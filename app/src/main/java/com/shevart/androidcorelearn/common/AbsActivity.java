package com.shevart.androidcorelearn.common;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

@SuppressWarnings("unused")
public abstract class AbsActivity extends AppCompatActivity {
    @SuppressWarnings("ConstantConditions")
    protected void enableToolbarBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @SuppressWarnings("ConstantConditions")
    protected void disableToolbarBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
