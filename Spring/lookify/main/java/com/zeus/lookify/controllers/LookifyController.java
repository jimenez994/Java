package com.zeus.lookify.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zeus.lookify.models.LookifyModel;
import com.zeus.lookify.services.LookifyServices;

@Controller
@RequestMapping("/")
public class LookifyController {
	
	private final LookifyServices lookifyService;
	public LookifyController(LookifyServices lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model,@ModelAttribute("songs")LookifyModel song) {
		ArrayList<LookifyModel> songs = lookifyService.allSongs();
		model.addAttribute("songs", songs);
		System.out.println(songs);
		return "dashboard.jsp";
	}
	@RequestMapping("/song/{id}")
	public String selectedSong(@PathVariable("id") Long id, Model model) {
		LookifyModel song = lookifyService.findSongByIndex(id);
		if(song != null) {
			model.addAttribute("song",song);
			return "song.jsp";
		}else {
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/song/new")
	public String newSong(@Valid @ModelAttribute("songs") LookifyModel song, BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp";
		}else {
			lookifyService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping("/song/delete/{id}")
	public String destroySong(@PathVariable("id") Long id) {
		lookifyService.destroySong(id);
		return"redirect:/dashboard";
	}
	@RequestMapping("/search")
	public String searchArtist(@RequestParam(value="artist") String artist, Model model) {
		ArrayList<LookifyModel> artists = lookifyService.findByArtist(artist);
		System.out.println(artists.size());
		if(artists.size() >= 1) {
			model.addAttribute("artists", artists);
			return "search.jsp";
		}else {
			return"redirect:/dashboard";
		}	
	}
	@RequestMapping("/songs/top10")
	public String top10(Model model) {
		model.addAttribute("songs",lookifyService.top10());
		return "topSongs.jsp";
	}
	

}
