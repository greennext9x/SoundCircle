package app.hoangcuong.com.soundcircle.fragments;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import app.hoangcuong.com.soundcircle.R;
import app.hoangcuong.com.soundcircle.SoundCircleActivity;

/**
 * Created by Jarvis on 12/3/2016.
 */

public class fragment_music_player extends Fragment {
    private ImageView mPlayTogle, mPlayNext;
    private SeekBar mSeekbar;
    private Handler handler = new Handler();
    private MediaPlayer mPlayer;
    private TextView txtProgress, txtDuration;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        txtProgress = (TextView) view.findViewById(R.id.text_view_progress);
        txtDuration = (TextView) view.findViewById(R.id.text_view_duration);
        mPlayTogle = (ImageView) view.findViewById(R.id.button_play_toggle);
        mPlayNext = (ImageView) view.findViewById(R.id.button_play_next);
        mSeekbar = (SeekBar) view.findViewById(R.id.seek_bar);
        mSeekbar.setClickable(true);
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(mPlayer != null && fromUser){
                    mPlayer.seekTo(progress);
                    UpdateSeebarThread updateSeekbarThread = new UpdateSeebarThread();
                    handler.postDelayed(updateSeekbarThread, 50);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                togglePlayPause();
                int duration = mPlayer.getDuration();
                int currentPosition = mPlayer.getCurrentPosition();
                if(currentPosition == 0){
                    mSeekbar.setMax(duration);
                    String maxTimeString = millisecondsToString(duration);
                    txtDuration.setText(maxTimeString);
                }else if(currentPosition == duration){
                    mPlayer.stop();
                }
                UpdateSeebarThread updateSeekbarThread = new UpdateSeebarThread();
                handler.postDelayed(updateSeekbarThread, 50);
                Log.i("Duration1",String.valueOf(duration));
            }
        });
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mPlayTogle.setImageResource(R.drawable.ic_play);
            }
        });
        mPlayTogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePlayPause();
            }
        });
        if(mPlayer.isPlaying()){
            mPlayer.stop();
            mPlayer.reset();
        }
        try{
            mPlayer.setDataSource("https://api.soundcloud.com/tracks/189231349/stream?client_id=b3e58eefda17605c8215157fdc46266e");
            mPlayer.prepareAsync();

        }catch (IOException e){
            e.printStackTrace();
        }
        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer != null) {
            if (mPlayer.isPlaying()) {
                mPlayer.stop();
            }
            mPlayer.release();
            mPlayer = null;
        }
    }

    private void togglePlayPause(){
        if(mPlayer.isPlaying()){
            mPlayer.pause();
            mPlayTogle.setImageResource(R.drawable.ic_play);

        }else {
            mPlayer.start();
            mPlayTogle.setImageResource(R.drawable.ic_pause);
        }
    }
    public class UpdateSeebarThread implements Runnable{
        @Override
        public void run() {
            int currentPosition = mPlayer.getCurrentPosition();
            String currentPositionStr = millisecondsToString(currentPosition);
            txtProgress.setText(currentPositionStr);
            mSeekbar.setProgress(currentPosition);
            handler.postDelayed(this,50);
        }
    }
    private String millisecondsToString(int milliseconds){
        long minutes = TimeUnit.MILLISECONDS.toMinutes((long) milliseconds);
        long seconds = TimeUnit.MILLISECONDS.toSeconds((long) milliseconds)
                - TimeUnit.MINUTES.toSeconds(minutes);
        return  String.format("%d : %d",minutes,seconds);
    }

}

