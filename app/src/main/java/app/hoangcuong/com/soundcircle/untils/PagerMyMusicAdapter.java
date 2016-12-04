package app.hoangcuong.com.soundcircle.untils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import app.hoangcuong.com.soundcircle.fragments.fragment_playlist;
import app.hoangcuong.com.soundcircle.fragments.fragment_songs_list;

/**
 * Created by Jarvis on 12/4/2016.
 */

public class PagerMyMusicAdapter extends FragmentPagerAdapter {
    public PagerMyMusicAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new fragment_songs_list();
            case 1:
                return new fragment_playlist();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
