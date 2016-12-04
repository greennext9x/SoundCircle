package app.hoangcuong.com.soundcircle.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import app.hoangcuong.com.soundcircle.R;
import app.hoangcuong.com.soundcircle.SoundCircleActivity;
import app.hoangcuong.com.soundcircle.ui.MyMusicActivity;

/**
 * Created by Irelia on 12/3/2016.
 */

public class SoundCircleFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "SoundCircleFragment";
    private  DrawerLayout drawer;
    public static Fragment newInstance() {
        return new SoundCircleFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sound_circle, container, false);
        drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        return view;
}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_mymusic) {
            Intent intent = new Intent(getActivity(), MyMusicActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_new_hot) {

        } else if (id == R.id.nav_top50) {

        } else if (id == R.id.nav_recent) {

        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_exit) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
