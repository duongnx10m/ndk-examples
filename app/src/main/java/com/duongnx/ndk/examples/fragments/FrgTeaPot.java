package com.duongnx.ndk.examples.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.duongnx.choreographer.ChoreographerNativeActivity;
import com.duongnx.moreteapots.MoreTeapotsNativeActivity;
import com.duongnx.ndk.examples.Defines;
import com.duongnx.ndk.examples.adapter.MainAdapter;
import com.duongnx.teapotclassic.TeapotNativeActivity;

/**
 * Created by duongnx on 11/12/16.
 */

public class FrgTeaPot extends FrgBaseRecylceView {
    public static final String[] DATAS = {Defines.TEA_POTS_CLASSIC, Defines.TEA_POTS_30FPS, Defines.TEA_POTS_MORE};

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity.setTitle("TEAPOT 3D");
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
            case Defines.TEA_POTS_CLASSIC:
                intent = new Intent(mActivity, TeapotNativeActivity.class);
                break;
            case Defines.TEA_POTS_MORE:
                intent = new Intent(mActivity, MoreTeapotsNativeActivity.class);
                break;
            case Defines.TEA_POTS_30FPS:
                intent = new Intent(mActivity, ChoreographerNativeActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
