package com.tracker.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tracker.model.Tracks;
import com.tracker.service.TracksService;

@RestController
@RequestMapping(value = "tracksList")
public class TracksController {
	
	@Autowired
	private TracksService tracksService;

	
	
	@RequestMapping(value = "all" , method = RequestMethod.GET)
	public List<Tracks> list() {
		return tracksService.listAll();
	}

	@GetMapping
	@RequestMapping("{id}")
	public Tracks get(@PathVariable Integer id) {
		return tracksService.get(id);
	}
	@PostMapping
	public Tracks create(@RequestBody final Tracks tracks) {
		return tracksService.save(tracks);
	}
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		tracksService.delete(id);
	}
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Tracks update(@PathVariable Integer id, @RequestBody Tracks tracks) {
	
	return tracksService.update(id, tracks);
	}
	
	}

