package com.tracker.service;


import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tracker.dao.TracksDao;
import com.tracker.model.Tracks;

@Service
public class TracksServiceImpl implements TracksService {

	@Autowired
	public TracksDao tracksDao;
	
	@Override
	public List<Tracks> listAll() {
		
		return tracksDao.findAll();
	}

	@Override
	public Tracks save(Tracks tracks) {
		
		return tracksDao.save(tracks);
	}

	@Override
	public Tracks update(int id, Tracks tracks) {
		
		Tracks existingTracks = tracksDao.getOne(id);
		BeanUtils.copyProperties(tracks, existingTracks,"id");
		return tracksDao.saveAndFlush(existingTracks);
	}

	@Override
	public void delete(int id) {
		
		tracksDao.deleteById(id);
		
	}

	@Override
	public Tracks get(int id) {

		return tracksDao.getOne(id);
	}



}

	