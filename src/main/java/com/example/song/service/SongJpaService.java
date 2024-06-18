package com.example.song.service;

import com.example.song.repository.SongRepository;
import java.util.*;
import com.example.song.model.Song;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.song.repository.SongJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Service
public class SongJpaService implements SongRepository {
	@Autowired
	private SongJpaRepository songJpaRepository;

	@Override
	public ArrayList<Song> getsongs() {
		List<Song> songlist = songJpaRepository.findAll();
		ArrayList<Song> arr = new ArrayList<>(songlist);
		return arr;
	}

	@Override
	public Song getsongById(int songId) {
		try {
			Song b = songJpaRepository.findById(songId).get();
			return b;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Song addsong(Song song) {
		songJpaRepository.save(song);
		return song;
	}

	@Override
	public Song updatesong(int songId, Song song) {
		try {
			Song newsong = songJpaRepository.findById(songId).get();
			if (song.getSongName() != null) {
				newsong.setSongName(song.getSongName());
			}
			songJpaRepository.save(newsong);
			return newsong;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deletesong(int songId) {
		try {
			songJpaRepository.deleteById(songId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}