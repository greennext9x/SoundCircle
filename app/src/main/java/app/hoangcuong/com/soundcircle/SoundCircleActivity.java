package app.hoangcuong.com.soundcircle;

import android.support.v4.app.Fragment;
import app.hoangcuong.com.soundcircle.fragments.fragment_music_player;

public class SoundCircleActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return fragment_music_player.newInstance();
    }
}