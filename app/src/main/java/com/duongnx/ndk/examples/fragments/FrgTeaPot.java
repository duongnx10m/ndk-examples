package com.duongnx.ndk.examples.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.duongnx.ndk.examples.Defines;
import com.duongnx.ndk.examples.adapter.MainAdapter;

/**
 * Created by duongnx on 11/12/16.
 */

public class FrgTeaPot extends FrgBaseRecylceView {
    public static final String[] DATAS = {Defines.TEA_POTS_CLASSIC, Defines.TEA_POTS_30FPS, Defines.TEA_POTS_30FPS};

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mAdapter == null) {
            mAdapter = new MainAdapter(mActivity, DATAS);
            mAdapter.setOnRecyclerItemClickListener(this);
        }
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRecyclerItemClick(int position) {

    }
}
