package app.hoangcuong.com.soundcircle.untils;

/**
 * Created by Jarvis on 12/5/2016.
 */

public class MySong {
    long mId;
    String mArtist;
    String mTitle;
    String mAlbum;
    long mDuration;

    public MySong(long mId, String mArtist, String mTitle, String mAlbum, long mDuration) {
        this.mId = mId;
        this.mArtist = mArtist;
        this.mTitle = mTitle;
        this.mAlbum = mAlbum;
        this.mDuration = mDuration;
    }

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    public String getmArtist() {
        return mArtist;
    }

    public void setmArtist(String mArtist) {
        this.mArtist = mArtist;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmAlbum() {
        return mAlbum;
    }

    public void setmAlbum(String mAlbum) {
        this.mAlbum = mAlbum;
    }

    public long getmDuration() {
        return mDuration;
    }

    public void setmDuration(long mDuration) {
        this.mDuration = mDuration;
    }
}
