package com.tracker.tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.tracker.tracker.dao.TracksDao;
import com.tracker.tracker.model.Tracks;

@Service
public class TracksService {

	private TracksDao tracksdao;
	
	public List<Tracks> listAll(){
		return tracksdao.findAll();
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

	