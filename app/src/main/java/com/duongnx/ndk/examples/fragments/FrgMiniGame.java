package com.duongnx.ndk.examples.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duongnx.endlesstunnel.EndlessTunnelActivity;
import com.duongnx.ndk.examples.R;

/**
 * Created by duongnx on 11/12/16.
 */

public class FrgMiniGame extends FrgBase {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.frg_mini_game, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity.setTitle("Mini Game");
        mRootView.findViewById(R.id.btPlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, EndlessTunnelActivity.class);
                mActivity.startActivity(intent);
            }
        });
    }
}
