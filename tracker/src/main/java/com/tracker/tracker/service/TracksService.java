package com.tracker.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.tracker.tracker.dao.TracksDao;
import com.tracker.tracker.model.Tracks;

@Service
public class TracksService {
	
	@Autowired
	@Qualifier("TracksDao")
	private TracksDao tracksdao;
	
	public List<Tracks> listAll(){
		return (List<Tracks>) tracksdao.findAll();
	}
	
	public void save(Tracks tracks) {
		tracksdao.save(tracks);
	}
	
	public Tracks get(int id) {
		return tracksdao.findById(id).get();
	}
	
	public void delete(int id) {
		tracksdao.deleteById(id);
	}
}

	