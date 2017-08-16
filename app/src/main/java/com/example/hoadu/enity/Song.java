package com.example.hoadu.enity;

/**
 * Created by hoadu on 19/04/2017.
 */

public class Song {
    private String mCode;
    private String mTitle;
    private String mLyric;
    private String mArtist;

    public Song(String code, String title, String lyric, String artist) {
        this.mCode = code;
        this.mTitle = title;
        this.mLyric = lyric;
        this.mArtist = artist;
    }
    public String getmArtist() {
        return mArtist;
    }

    public void setmArtist(String mArtist) {
        this.mArtist = mArtist;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getmLyric() {
        return mLyric;
    }

    public void setmLyric(String mLyric) {
        this.mLyric = mLyric;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
