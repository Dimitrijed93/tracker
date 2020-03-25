package com.tracker.tracker.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tracker.tracker.model.Tracks;

@Repository("TracksDao")
public interface TracksDao extends CrudRepository<Tracks, Integer>{
	
}
