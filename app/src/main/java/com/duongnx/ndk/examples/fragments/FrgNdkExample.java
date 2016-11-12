package com.duongnx.ndk.examples.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.duongnx.ndk.examples.Defines;
import com.duongnx.ndk.examples.activities.AccelerometerGraphActivity;
import com.duongnx.ndk.examples.activities.GL2JNIActivity;
import com.duongnx.ndk.examples.activities.GLES3JNIActivity;
import com.duongnx.ndk.examples.activities.HelloJniActivity;
import com.duongnx.ndk.examples.activities.HelloNeonActivity;
import com.duongnx.ndk.examples.activities.JniCallbackActivity;
import com.duongnx.ndk.examples.activities.NativeAudioActivity;
import com.duongnx.ndk.examples.activities.NativeMediaActivity;
import com.duongnx.ndk.examples.activities.NativePlasmaActivity;
import com.duongnx.ndk.examples.activities.PlasmaActivity;
import com.duongnx.ndk.examples.activities.SanAngelActivity;
import com.duongnx.ndk.examples.adapter.MainAdapter;

/**
 * Created by duongnx on 11/12/16.
 */

public class FrgNdkExample extends FrgBaseRecylceView {

    public static final String[] NDK_EXAMPLES = {
            Defines.HELLO_JNI, Defines.BITMAP_PLASMA, Defines.HELLO_GL2,
            Defines.GLES3_JNI, Defines.JNI_CALLBACK, Defines.HELLO_NEON,
            Defines.SAN_ANGELES, Defines.SENSOR_GRAPH,
            Defines.NATIVE_PLASMA, Defines.NATIVE_ACTIVITY,
            Defines.NATIVE_AUDIO, Defines.NATIVE_MEDIA
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity.setTitle("NDK EXAMPLES");
        if (mAdapter == null) {
            mAdapter = new MainAdapter(mActivity, NDK_EXAMPLES);
            mAdapter.setOnRecyclerItemClickListener(this);
        }
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onRecyclerItemClick(int position) {
        String name = mAdapter.getItem(position);
        Intent intent = null;
        switch (name) {
            case Defines.HELLO_JNI:
                intent = new Intent(mActivity, HelloJniActivity.class);
                break;
            case Defines.BITMAP_PLASMA:
                intent = new Intent(mActivity, PlasmaActivity.class);
                break;
            case Defines.HELLO_GL2:
                intent = new Intent(mActivity, GL2JNIActivity.class);
                break;
            case Defines.GLES3_JNI:
                intent = new Intent(mActivity, GLES3JNIActivity.class);
                break;
            case Defines.JNI_CALLBACK:
                intent = new Intent(mActivity, JniCallbackActivity.class);
                break;
            case Defines.HELLO_NEON:
                intent = new Intent(mActivity, HelloNeonActivity.class);
                break;
            case Defines.SAN_ANGELES:
                intent = new Intent(mActivity, SanAngelActivity.class);
                break;
            case Defines.SENSOR_GRAPH:
                intent = new Intent(mActivity, AccelerometerGraphActivity.class);
                break;
            case Defines.NATIVE_PLASMA:
                intent = new Intent(mActivity, NativePlasmaActivity.class);
                break;
            case Defines.NATIVE_ACTIVITY:
                intent = new Intent(mActivity, com.duongnx.ndk.examples.activities.NativeActivity.class);
                break;
            case Defines.NATIVE_AUDIO:
                intent = new Intent(mActivity, NativeAudioActivity.class);
                break;
            case Defines.NATIVE_MEDIA:
                intent = new Intent(mActivity, NativeMediaActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
