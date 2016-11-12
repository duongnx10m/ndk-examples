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

public class FrgNative extends FrgBaseRecylceView {
    private static final String[] DATAS = {
            Defines.NATIVE_PLASMA, Defines.NATIVE_ACTIVITY,
            Defines.NATIVE_AUDIO, Defines.NATIVE_MEDIA};

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity.setTitle("Native Activities");
        if (mAdapter == null) {
            mAdapter = new MainAdapter(mActivity, DATAS);
            mAdapter.setOnRecyclerItemClickListener(this);
        }
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRecyclerItemClick(int position) {
        String name = mAdapter.getItem(position);
        Intent intent = null;
        switch (name) {
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
