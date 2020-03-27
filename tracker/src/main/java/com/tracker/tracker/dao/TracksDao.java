package com.tracker.tracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tracker.tracker.model.Tracks;


public interface TracksDao extends JpaRepository<Tracks, Integer>{
		
	}

