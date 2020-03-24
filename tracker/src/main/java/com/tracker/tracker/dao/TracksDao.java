package com.tracker.tracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tracker.tracker.model.Tracks;

@Repository("TracksDao")
public interface TracksDao extends JpaRepository<Tracks, Integer>  {

	
}
