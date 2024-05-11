/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.song.controller;

import com.example.song.model.Song;
import com.example.song.service.SongH2Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
class SongController {

    @Autowired
    public SongH2Service songService;

    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return songService.getSongs();
    }

    @PostMapping("/songs/createSong")
    public Song createSong(@RequestBody Song song) {
        return songService.createSong(song);
    }

    @GetMapping("/songs/{songId}")
    public Song getSongDetails(@PathVariable("songId") int songId) {
        return songService.getSongDetails(songId);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSongDetails(@PathVariable("songId") int songId, @RequestBody Song song) {
        return songService.updateSongDetails(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public Song deleteSong(@PathVariable("songId") int songId) {
        return songService.deleteSong(songId);
    }

}