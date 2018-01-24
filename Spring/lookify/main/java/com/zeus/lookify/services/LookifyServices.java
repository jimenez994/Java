package com.zeus.lookify.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zeus.lookify.models.LookifyModel;
import com.zeus.lookify.repositories.LookifyRepository;

@Service
public class LookifyServices {
	private LookifyRepository lookifyRepository;
	public LookifyServices(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	public ArrayList<LookifyModel> allSongs(){
		return (ArrayList<LookifyModel>) lookifyRepository.findAll();
	}
	public void addSong(LookifyModel song) {
		lookifyRepository.save(song);
	}
	public LookifyModel findSongByIndex(Long id) {
		return lookifyRepository.findOne(id);
	}
	public void updatesong(LookifyModel song) {
		lookifyRepository.save(song);
	}
	public void destroySong(Long id) {
		lookifyRepository.delete(id);
	}
	public ArrayList<LookifyModel> findByArtist(String search){
		return (ArrayList<LookifyModel>) lookifyRepository.findByArtist(search);
	}
	public ArrayList<LookifyModel>  top10(){
		ArrayList<LookifyModel> songs = (ArrayList<LookifyModel>) lookifyRepository.OrderByRatingDesc();
		for(int i = 0; i<songs.size();i++) {
			if(i>10) {
				songs.remove(i);
			}
		}
		return songs;
	}

}
