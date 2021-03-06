/*
 * Copyright (C) 2007 The Android Open Source Project
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

import android.app.Activity;
import android.os.Bundle;

import com.duongnx.ndk.examples.Defines;
import com.duongnx.ndk.examples.wigets.GL2JNIView;


public class GL2JNIActivity extends BaseActivity {

    static {
        System.loadLibrary("gl2jni");
    }

    private GL2JNIView mView;

    @Override
    protected String getGithubLink() {
        return Defines.GIT_HELLO_GL2;
    }

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        mView = new GL2JNIView(getApplication());
        setContentView(mView);
        setTitle(Defines.HELLO_GL2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mView.onResume();
    }
}
