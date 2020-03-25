package com.tracker.tracker.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tracker.tracker.model.Tracks;
import com.tracker.tracker.service.TracksService;

@Controller
public class TracksController {
	
	@Autowired
	private TracksService service;

	@RequestMapping("tracksList")
	public String tracks(Model model) {
		List<Tracks> listTracks = service.listAll();
		model.addAttribute("listTracks", listTracks);
		
		return "tracks/tracksList";
	
	
	}
}
