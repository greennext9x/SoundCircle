package app.hoangcuong.com.soundcircle;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;

import app.hoangcuong.com.soundcircle.fragments.SoundCircleFragment;


public class SoundCircleActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return SoundCircleFragment.newInstance();
    }
}