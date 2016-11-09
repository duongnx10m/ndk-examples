package com.duongnx.ndk.examples.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

/**
 * Created by duongnx on 11/9/16.
 */

public class Utils {

    public static void shareLink(Context context, String url) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, url);
        context.startActivity(Intent.createChooser(intent, "Share"));
    }

    public static boolean copyToClipboard(Context context, String text) {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB)
                clipboardManager.setText(text);
            else {
                ClipData clipData = ClipData.newPlainText("Copied text", text);
                clipboardManager.setPrimaryClip(clipData);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void startActivityWithUrl(Context context, String url) {
        if (!TextUtils.isEmpty(url) && context != null) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            context.startActivity(intent);
        }
    }
}
