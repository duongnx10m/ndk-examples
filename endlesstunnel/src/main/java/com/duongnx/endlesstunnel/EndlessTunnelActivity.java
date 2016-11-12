package com.duongnx.endlesstunnel;

import android.app.NativeActivity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

/**
 * Created by duongnx on 11/12/16.
 */

public class EndlessTunnelActivity extends NativeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}
