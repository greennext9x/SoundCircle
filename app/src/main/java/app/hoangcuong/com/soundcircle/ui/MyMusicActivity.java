package app.hoangcuong.com.soundcircle.ui;

import android.support.v4.app.Fragment;

import app.hoangcuong.com.soundcircle.SingleFragmentActivity;
import app.hoangcuong.com.soundcircle.fragments.FragmentMyMusic;

/**
 * Created by Jarvis on 12/4/2016.
 */

public class MyMusicActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return FragmentMyMusic.newInstance();
    }
}
