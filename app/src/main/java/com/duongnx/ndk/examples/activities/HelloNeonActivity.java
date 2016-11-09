package com.duongnx.ndk.examples.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.duongnx.ndk.examples.Defines;
import com.duongnx.ndk.examples.R;

public class HelloNeonActivity extends BaseActivity {

    @Override
    protected String getGithubLink() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(Defines.HELLO_NEON);
        setContentView(R.layout.activity_hello_neon);

        ((TextView) findViewById(R.id.text_view_hello_neon))
                .setText(stringFromJNI());
    }

    public native String stringFromJNI();

    static {
        System.loadLibrary("hello-neon");
    }
}
