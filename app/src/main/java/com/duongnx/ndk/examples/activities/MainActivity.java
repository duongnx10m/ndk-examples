package com.duongnx.ndk.examples.activities;

import android.app.NativeActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.duongnx.ndk.examples.Defines;
import com.duongnx.ndk.examples.R;
import com.duongnx.ndk.examples.adapter.MainAdapter;
import com.duongnx.ndk.examples.fragments.FrgAbout;
import com.duongnx.ndk.examples.fragments.FrgMiniGame;
import com.duongnx.ndk.examples.fragments.FrgNative;
import com.duongnx.ndk.examples.fragments.FrgNdkExample;
import com.duongnx.ndk.examples.fragments.FrgTeaPot;
import com.duongnx.ndk.examples.utils.Utils;

/**
 * Created by duongnx on 11/4/16.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    // Used to load the 'native-lib' library on application startup.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
        setTitle(R.string.title_name);

        changeMenuFragment(new FrgNdkExample());
    }

    private void initViews() {
        // set up toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // set up drawerlayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_view_source:
                Utils.startActivityWithUrl(this, Defines.GIT_MY_SOURCE);
                break;
            case R.id.menu_rate: {
                Utils.startActivityWithUrl(this, Defines.RATE);
                break;
            }
            case R.id.menu_more: {
                Utils.startActivityWithUrl(this, Defines.MORE_APPS);
            }
            break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        closeDrawer();
        switch (item.getItemId()) {
            case R.id.nav_ndk_ex:
                changeMenuFragment(new FrgNdkExample());
                break;
            case R.id.nav_teapot:
                changeMenuFragment(new FrgTeaPot());
                break;
            case R.id.nav_native:
                changeMenuFragment(new FrgNative());
                break;
            case R.id.nav_game:
                changeMenuFragment(new FrgMiniGame());
                break;
            case R.id.nav_about:
                changeMenuFragment(new FrgAbout());
                break;
        }
        return true;
    }


    public void changeMenuFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content, fragment);
            fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
            fragmentTransaction.commitAllowingStateLoss();
        }
    }

    public void openDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

}
