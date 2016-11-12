package com.duongnx.ndk.examples.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.duongnx.ndk.examples.activities.MainActivity;

/**
 * Created by duongnx on 11/12/16.
 */

public class FrgBase extends Fragment {
    protected View mRootView;
    protected MainActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
    }
}
