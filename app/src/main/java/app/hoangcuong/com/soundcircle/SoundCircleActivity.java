package app.hoangcuong.com.soundcircle;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import app.hoangcuong.com.soundcircle.fragments.SoundCircleFragment;

public class SoundCircleActivity{

    public static Intent newIntent(Context context) {
        return new Intent(context, SoundCircleActivity.class);
    }
}
