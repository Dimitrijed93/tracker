package com.tracker.tracker.dao;

import org.springframework.data.repository.CrudRepository;
import com.tracker.tracker.model.Tracks;

public interface TracksDao extends CrudRepository<Tracks, Integer>  {

	
}
