package com.duongnx.ndk.examples.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.duongnx.ndk.examples.Defines;
import com.duongnx.ndk.examples.R;
import com.duongnx.ndk.examples.adapter.MainAdapter;

/**
 * Created by duongnx on 11/4/16.
 */

public class MainActivity extends AppCompatActivity implements MainAdapter.OnRecyclerItemClickListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public static final String[] NDK_EXAMPLES = {Defines.HELLO_JNI, Defines.BITMAP_PLASMA, Defines.HELLO_GL2};

    private RecyclerView recyclerView;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initListView();
        if (mAdapter == null) {
            mAdapter = new MainAdapter(this, NDK_EXAMPLES);
            mAdapter.setOnRecyclerItemClickListener(this);
        }

        recyclerView.setAdapter(mAdapter);

    }

    private void initListView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onRecyclerItemClick(int position) {
        String name = mAdapter.getItem(position);
        Intent intent = null;
        switch (name) {
            case Defines.HELLO_JNI:
                intent = new Intent(this, HelloJniActivity.class);
                break;
            case Defines.BITMAP_PLASMA:
                intent = new Intent(this, PlasmaActivity.class);
                break;
            case Defines.HELLO_GL2:
                intent = new Intent(this, GL2JNIActivity.class);
                break;
            case Defines.NATIVE_PLASMA:
                //intent = new Intent(this, NativeActivity.class);
                break;
            case Defines.NATIVE_AUDIO:
                //intent = new Intent(this, NativeAudioActivity.class);
                break;

        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_view_source:
                break;
        }
        return true;
    }
}
