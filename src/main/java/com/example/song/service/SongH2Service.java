/*
 * 
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.song.service;

import com.example.song.model.Song;
import com.example.song.model.SongRowMapper;
import org.springframework.stereotype.Service;
import com.example.song.repository.SongRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@Service
public class SongH2Service implements SongRepository {

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Song> getSongs() {
        List<Song> songsList = db.query("select * from PLAYLIST", new SongRowMapper());
        ArrayList<Song> songs = new ArrayList<>(songsList);
        return songs;
    }

    @Override
    public Song getSongDetails(int songId) {
        try {
            Song song = db.queryForObject("select * from PLAYLIST where songId = ?", new SongRowMapper(), songId);
            return song;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song createSong(Song song) {
        db.update("insert into PLAYLIST(songName,lyricist,singer,musicDirector) values(?,?,?,?)", song.getSongName(),
                song.getLyricist(), song.getSinger(), song.getMusicDirector());
        Song savedSong = db.queryForObject("select * from PLAYLIST where songName = ?", new SongRowMapper(),
                song.getSongName());
        return savedSong;

    }

    @Override
    public Song updateSongDetails(int songId, Song song) {
        if (song.getSongName() != null) {
            db.update("update PLAYLIST set songName= ? where songId = ?", song.getSongName(), songId);
        }
        return getSongDetails(songId);

    }

    @Override
    public Song deleteSong(int songId) {
        Song savedSong = getSongDetails(songId);
        if (savedSong != null) {
            db.update("delete from PLAYLIST where songId = ?", songId);
            return savedSong;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}