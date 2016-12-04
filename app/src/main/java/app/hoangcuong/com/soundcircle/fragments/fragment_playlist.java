package app.hoangcuong.com.soundcircle.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Jarvis on 12/4/2016.
 */

public class fragment_playlist extends Fragment{
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_all_list_local, container, false);
//        return v;
        TextView tv = new TextView(getActivity());
        tv.setText("First tab");
        tv.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        tv.setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
        tv.setBackgroundColor(Color.GREEN);
        return tv;
    }
}
