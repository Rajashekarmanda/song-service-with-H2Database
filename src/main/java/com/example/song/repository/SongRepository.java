// Write your code here
package com.example.song.repository;

import com.example.song.model.Song;
import java.util.*;

public interface SongRepository {

    ArrayList<Song> getSongs();

    Song getSongDetails(int songId);

    Song createSong(Song song);

    Song updateSongDetails(int songId, Song song);

    Song deleteSong(int songId);

}