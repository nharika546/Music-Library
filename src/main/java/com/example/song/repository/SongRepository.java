package com.example.song.repository;

import java.util.ArrayList;

import com.example.song.model.Song;

public interface SongRepository {
    ArrayList<Song> getsongs();

    Song getsongById(int songId);

    Song addsong(Song song);

    Song updatesong(int songId, Song song);

    void deletesong(int songId);

}