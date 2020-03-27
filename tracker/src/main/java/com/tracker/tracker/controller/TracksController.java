package com.tracker.tracker.controller;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tracker.tracker.dao.TracksDao;
import com.tracker.tracker.model.Tracks;

@RestController
@RequestMapping("api/v1/tracks")
public class TracksController {
	
	@Autowired
	private TracksDao tracksDao;
	
	@GetMapping
	public List<Tracks> list() {
		return tracksDao.findAll();
	}

	@GetMapping
	@RequestMapping("{id}")
	public Tracks get(@PathVariable Integer id) {
		return tracksDao.getOne(id);
	}
	@PostMapping
	public Tracks create(@RequestBody final Tracks tracks) {
		return tracksDao.saveAndFlush(tracks);
	}
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		tracksDao.deleteById(id);
	}
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Tracks update(@PathVariable Integer id, @RequestBody Tracks tracks) {
		
	Tracks existingTracks = tracksDao.getOne(id);
	BeanUtils.copyProperties(tracks, existingTracks,"id");
	return tracksDao.saveAndFlush(existingTracks);
	}
	
	}

