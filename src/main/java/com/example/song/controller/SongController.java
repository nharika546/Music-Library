package com.example.song.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.song.model.Song;
import com.example.song.service.SongJpaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
public class SongController {
    @Autowired
    public SongJpaService songService;

    @GetMapping("/songs")
    public ArrayList<Song> getsongs() {
        return songService.getsongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getsongById(@PathVariable("songId") int songId) {
        return songService.getsongById(songId);
    }

    @PostMapping("/songs")
    public Song addsong(@RequestBody Song song) {
        return songService.addsong(song);

    }

    @PutMapping("/songs/{songId}")
    public Song updatesong(@PathVariable("songId") int songId, @RequestBody Song song) {
        return songService.updatesong(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deletesong(@PathVariable("songId") int songId) {
        songService.deletesong(songId);
    }

}