package com.duongnx.ndk.examples.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duongnx.ndk.examples.R;
import com.duongnx.ndk.examples.utils.Utils;

/**
 * Created by duongnx on 11/12/16.
 */

public class FrgAbout extends FrgBase {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.frg_about, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity.setTitle("About");
        Utils.setTextWithLinks((TextView) mRootView.findViewById(R.id.tvContent), Utils.fromHtml(getString(R.string.application_info_text, Utils.getVersionName(mActivity))));
        Utils.setTextWithLinks((TextView) mRootView.findViewById(R.id.tvDev), Utils.fromHtml(getString(R.string.developer_info_text)));
    }
}
