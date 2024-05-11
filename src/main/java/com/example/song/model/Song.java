// Write your code here
package com.example.song.model;

public class Song {
    private int songId;
    private String songName;
    private String lyricist;
    private String singer;
    private String musicDirector;

    public Song(int songId, String songName, String lyricist, String singer, String musicDirector) {
        this.songId = songId;
        this.songName = songName;
        this.lyricist = lyricist;
        this.singer = singer;
        this.musicDirector = musicDirector;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setMusicDirector(String musicDirector) {
        this.musicDirector = musicDirector;
    }

    public int getSongId() {
        return this.songId;
    }

    public String getSongName() {
        return this.songName;
    }

    public String getLyricist() {
        return this.lyricist;
    }

    public String getSinger() {
        return this.singer;
    }

    public String getMusicDirector() {
        return this.musicDirector;
    }

}