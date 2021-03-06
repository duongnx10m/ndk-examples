/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.duongnx.ndk.examples.activities;

import android.support.annotation.Keep;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.duongnx.ndk.examples.Defines;
import com.duongnx.ndk.examples.R;

public class JniCallbackActivity extends BaseActivity {

    int hour = 0;
    int minute = 0;
    int second = 0;
    TextView tickView;

    @Override
    protected String getGithubLink() {
        return Defines.GIT_HELLO_JNI_CALLBACK;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jnicallback);
        tickView = (TextView) findViewById(R.id.tickView);
        setTitle(Defines.JNI_CALLBACK);
    }

    @Override
    public void onResume() {
        super.onResume();
        hour = minute = second = 0;
        ((TextView) findViewById(R.id.hellojniMsg)).setText(stringFromJNI());
        startTicks();
    }

    @Override
    public void onPause() {
        super.onPause();
        StopTicks();
    }

    /*
     * A function calling from JNI to update current timer
     */
    @Keep
    private void updateTimer() {
        ++second;
        if (second >= 60) {
            ++minute;
            second -= 60;
            if (minute >= 60) {
                ++hour;
                minute -= 60;
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String ticks = "" + JniCallbackActivity.this.hour + ":" +
                        JniCallbackActivity.this.minute + ":" +
                        JniCallbackActivity.this.second;
                JniCallbackActivity.this.tickView.setText(ticks);
            }
        });
    }

    static {
        System.loadLibrary("hello-jnicallback");
    }

    public native String stringFromJNI();

    public native void startTicks();

    public native void StopTicks();
}
