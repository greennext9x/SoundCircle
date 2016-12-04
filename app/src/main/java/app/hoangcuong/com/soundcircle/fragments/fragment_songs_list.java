package app.hoangcuong.com.soundcircle.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import app.hoangcuong.com.soundcircle.R;

/**
 * Created by Jarvis on 12/4/2016.
 */

public class fragment_songs_list extends Fragment {
    private RecyclerView mRecyclerView;
    private List<String> mLocal = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_all_list_local, container, false);
        final String MEDIA_PATH = new String("/sdcard/");
        File file = new File(MEDIA_PATH);
        ArrayList<File> mySongs = findSongs(file);
        for(File f: mySongs){
            String s = f.getName();
            mLocal.add(s);
        }
        mRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_all_list_local_recycler_view);
        LocalMusicAdapter adapter = new LocalMusicAdapter(mLocal);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }
    public class LocalMusicAdapter extends RecyclerView.Adapter<LocalMusicAdapter.viewHolder>{
        private List<String> mLocalMusic;

        public LocalMusicAdapter(List<String> mLocalMusic) {
            this.mLocalMusic = mLocalMusic;
        }

        public class viewHolder extends RecyclerView.ViewHolder{
            public TextView mTextViewName;
//            public TextView mTextViewArtist;
            public viewHolder(View itemView) {
                super(itemView);
                mTextViewName = (TextView) itemView.findViewById(R.id.item_text_view_name);
//                mTextViewArtist = (TextView) itemView.findViewById(R.id.item_text_view_artist);
            }
        }

        @Override
        public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View viewMusicLocal = inflater.inflate(R.layout.item_file_music, parent, false);
            viewHolder mHolder = new viewHolder(viewMusicLocal);
            return mHolder;
        }

        @Override
        public void onBindViewHolder(viewHolder holder, int position) {
            TextView txt = holder.mTextViewName;
            String s = mLocalMusic.get(position);
            txt.setText(s);
        }

        @Override
        public int getItemCount() {
            return mLocalMusic.size();
        }
    }
    public ArrayList<File> findSongs(File root){
        ArrayList<File> all = new ArrayList<>();
        File[] files = root.listFiles();
        for(File singleFile : files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                all.addAll(findSongs(singleFile));
            }else if(singleFile.getName().endsWith(".mp3") && singleFile.length() > 0){
                all.add(singleFile);
            }
        }
        return all;
    }
}
