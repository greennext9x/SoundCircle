package app.hoangcuong.com.soundcircle.fragments;

import android.app.FragmentTransaction;
import android.os.Bundle;;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import app.hoangcuong.com.soundcircle.R;
import app.hoangcuong.com.soundcircle.untils.PagerMyMusicAdapter;

/**
 * Created by Jarvis on 12/4/2016.
 */

public class FragmentMyMusic extends Fragment {

    private ViewPager mPager;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private PagerMyMusicAdapter mPagerAdapter;
    public static Fragment newInstance() {
        return new FragmentMyMusic();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_music, container, false);
        mToolbar = (Toolbar) view.findViewById(R.id.fragment_my_music_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        mTabLayout = (TabLayout) view.findViewById(R.id.fragment_tab_layout_my_music);
        mTabLayout.addTab(mTabLayout.newTab().setText("SONGS"));
        mTabLayout.addTab(mTabLayout.newTab().setText("PLAYIST"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mPager = (ViewPager) view.findViewById(R.id.fragment_pager_my_music);
        mPagerAdapter = new PagerMyMusicAdapter(getFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }
}
