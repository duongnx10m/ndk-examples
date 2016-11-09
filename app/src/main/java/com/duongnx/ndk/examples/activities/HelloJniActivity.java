package com.duongnx.ndk.examples.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.duongnx.ndk.examples.Defines;

/**
 * Created by duongnx on 11/4/16.
 */

public class HelloJniActivity extends BaseActivity {

    @Override
    protected String getGithubLink() {
        return Defines.GIT_HELLO_JNI;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(Defines.HELLO_JNI);

        TextView textView = new TextView(this);
        textView.setText(stringFromJNI());
        textView.setTextSize(18);
        textView.setPadding(20, 20, 20, 20);
        setContentView(textView);
    }

    public native String stringFromJNI();
}
