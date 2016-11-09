package com.duongnx.ndk.examples.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.duongnx.ndk.examples.Defines;
import com.duongnx.ndk.examples.R;
import com.duongnx.ndk.examples.utils.Utils;

/**
 * Created by duongnx on 11/4/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract String getGithubLink();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_view_source:
                Utils.startActivityWithUrl(BaseActivity.this, getGithubLink());
                break;
            case R.id.menu_copy_link:
                Utils.copyToClipboard(this, getGithubLink());
                Toast.makeText(this, "Copied to clipboard!", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_share_link:
                Utils.shareLink(this, getGithubLink());
                break;
        }
        return true;
    }


}
