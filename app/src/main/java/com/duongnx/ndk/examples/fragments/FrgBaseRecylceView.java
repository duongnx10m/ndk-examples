package com.duongnx.ndk.examples.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duongnx.ndk.examples.R;
import com.duongnx.ndk.examples.adapter.MainAdapter;

/**
 * Created by duongnx on 11/12/16.
 */

public abstract class FrgBaseRecylceView extends FrgBase implements MainAdapter.OnRecyclerItemClickListener {
    protected RecyclerView recyclerView;
    protected MainAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.frg_ndk_example, container, false);
        recyclerView = (RecyclerView) mRootView.findViewById(R.id.recyclerView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initListView();
    }

    private void initListView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mActivity);
        recyclerView.setLayoutManager(layoutManager);
    }
}
