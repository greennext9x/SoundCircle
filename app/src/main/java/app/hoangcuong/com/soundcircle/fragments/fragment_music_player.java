package app.hoangcuong.com.soundcircle.fragments;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.io.IOException;

import app.hoangcuong.com.soundcircle.R;

/**
 * Created by Jarvis on 12/3/2016.
 */

public class fragment_music_player extends Fragment {
    private ImageView mPlayTogle;
    private SeekBar mSeekbar;
    private MediaPlayer mPlayer;
    public static Fragment newInstance() {
        return new fragment_music_player();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);
//        mPlayTogle = (ImageView) view.findViewById(R.id.button_play_toggle);
//        mSeekbar = (SeekBar) view.findViewById(R.id.seek_bar);
//        mPlayer = new MediaPlayer();
//        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                togglePlayPause();
//            }
//        });
//        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                mPlayTogle.setImageResource(R.drawable.ic_play);
//            }
//        });
//        if(mPlayer.isPlaying()){
//            mPlayer.stop();
//            mPlayer.reset();
//        }
//        try{
//            mPlayer.setDataSource("https://api.soundcloud.com/tracks/189231349/stream?client_id=b3e58eefda17605c8215157fdc46266e");
//            mPlayer.prepareAsync();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        return view;

    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        if (mPlayer != null) {
//            if (mPlayer.isPlaying()) {
//                mPlayer.stop();
//            }
//            mPlayer.release();
//            mPlayer = null;
//        }
//    }
//
//    private void togglePlayPause(){
//        if(mPlayer.isPlaying()){
//            mPlayer.pause();
//            mPlayTogle.setImageResource(R.drawable.ic_play);
//        }else {
//            mPlayer.pause();
//            mPlayTogle.setImageResource(R.drawable.ic_pause);
//        }
//    }

}

