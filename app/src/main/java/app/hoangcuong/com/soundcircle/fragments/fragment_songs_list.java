package app.hoangcuong.com.soundcircle.fragments;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import app.hoangcuong.com.soundcircle.R;
import app.hoangcuong.com.soundcircle.untils.MySong;

/**
 * Created by Jarvis on 12/4/2016.
 */

public class fragment_songs_list extends Fragment {
    private RecyclerView mRecyclerView;
    private List<MySong> mLocal = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_all_list_local, container, false);
//        final String MEDIA_PATH = new String("/sdcard/");
//        File file = new File(MEDIA_PATH);
        String[] projection = {MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.DURATION};
//        ArrayList<File> mySongs = findSongs(file);
        Cursor musicCursor = getContext().getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                null,null,null
        );
        if (musicCursor != null){
            while (musicCursor.moveToNext()){
                int id = musicCursor.getColumnIndex(MediaStore.Audio.Media._ID);
                int artist = musicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
                int title = musicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
                int album = musicCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
                int duration = musicCursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
                mLocal.add(new MySong(
                        musicCursor.getLong(id),
                        musicCursor.getString(artist),
                        musicCursor.getString(title),
                        musicCursor.getString(album),
                        musicCursor.getLong(duration)
                ));
            }
        }
//        for(File f: mySongs){
////            String s = f.getName();
//
////            mLocal.add(musicCursor.getString(3));
//        }
        mRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_all_list_local_recycler_view);
        LocalMusicAdapter adapter = new LocalMusicAdapter(mLocal);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }
    public class LocalMusicAdapter extends RecyclerView.Adapter<LocalMusicAdapter.viewHolder>{
        private List<MySong> mLocalMusic;

        public LocalMusicAdapter(List<MySong> mLocalMusic) {
            this.mLocalMusic = mLocalMusic;
        }

        public class viewHolder extends RecyclerView.ViewHolder{
            public TextView mTextViewName;
            public TextView mTextViewDuration;
            public TextView mTextViewArtist;
            public viewHolder(View itemView) {
                super(itemView);
                mTextViewName = (TextView) itemView.findViewById(R.id.item_text_view_name);
                mTextViewArtist = (TextView) itemView.findViewById(R.id.item_text_view_artist);
                mTextViewDuration = (TextView) itemView.findViewById(R.id.item_text_view_time);
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
            TextView txtName = holder.mTextViewName;
            TextView txtDuration = holder.mTextViewDuration;
            TextView txtArtist = holder.mTextViewArtist;
            String mName = mLocalMusic.get(position).getmTitle();
            txtName.setText(mName);
            String mArtist = mLocalMusic.get(position).getmArtist();
            txtArtist.setText(mArtist);
            long mDuration = mLocalMusic.get(position).getmDuration();
            txtDuration.setText(millisecondsToString(mDuration));
        }

        @Override
        public int getItemCount() {
            return mLocalMusic.size();
        }
    }
    private String millisecondsToString(long milliseconds){
        long minutes = TimeUnit.MILLISECONDS.toMinutes((long) milliseconds);
        long seconds = TimeUnit.MILLISECONDS.toSeconds((long) milliseconds)
                - TimeUnit.MINUTES.toSeconds(minutes);
        return  String.format("%d : %d",minutes,seconds);
    }
//    public ArrayList<File> findSongs(File root){
//        ArrayList<File> all = new ArrayList<>();
//        File[] files = root.listFiles();
//        for(File singleFile : files){
//            if(singleFile.isDirectory() && !singleFile.isHidden()){
//                all.addAll(findSongs(singleFile));
//            }else if(singleFile.getName().endsWith(".mp3") && singleFile.length() > 0){
//                all.add(singleFile);
//            }
//        }
//        return all;
//    }
}
